package com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * This class evaluates the complexity of methods within Java and Kotlin files located in a specified directory.
 * It uses regex patterns to identify method signatures and calculates their complexity based on control flow elements.
 */
public class CodeQualityEvaluator {
    private static BufferedReader reader;
    private static Map<String, Integer> methodComplexityGlobal;
    private static double percentageNonCamelCaseGlobal;
    static final Pattern patternJava = Pattern.compile("\\b(public|private|protected)\\s+(static\\s+)?[\\w<>,\\s]+\\s+(\\w+)\\s*\\(([^)]*)\\)\\s*\\{");
    static final Pattern patternKotlin = Pattern.compile(
            "fun\\s+" +                                   // Matches the 'fun' keyword followed by one or more spaces
                    "(?:<\\s*[^>]+\\s*>\\s*)?" +                  // Optionally matches generic parameters with constraints
                    "([\\w?]+(?:\\.[\\w?]+)*\\s+)?"+              // Optionally matches receiver types for extension functions
                    "(\\w+)\\s*" +                                // Matches the function name
                    "\\((.*?)\\)" +                               // Non-greedy match for parameters within parentheses
                    "(\\s*:\\s*[\\w<>,?\\s\\[\\]]+)?\\s*" +       // Optionally matches a return type declaration
                    "\\{"
    );

    /**
     * Main method to execute the application.
     * @param args Command line arguments (not used)
     */
    public static void main(String[] args) {
        try {
            // Set up a reader to capture user input from the console
            reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Please enter the path to the directory containing Java and Kotlin files:");
            String directoryPath = reader.readLine();
            evaluateCodeQuality(directoryPath);
        } catch (IOException e) {
            System.err.println("An error occurred while reading files: " + e.getMessage());
        }
    }

    public static void evaluateCodeQuality(String directoryPath) throws IOException {
        // Check for valid input and handle empty or null paths
        if (directoryPath == null || directoryPath.trim().isEmpty()) {
            System.out.println("No directory path was entered. Exiting program.");
            return;
        }

        // Retrieve list of files from the specified directory
        List<String> files = fetchFiles(directoryPath);
        if (files.isEmpty()) {
            System.out.println("No Java or Kotlin files found in the specified directory.");
            return;
        }

        // Analyze the complexity of methods within the fetched files
        MethodAnalyzer analyzer = new MethodAnalyzer();
        Map<String, Integer> methodComplexity = analyzer.analyzeFiles(files);

        // Display the results of the analysis
        displayResults(methodComplexity);
    }

    /**
     * Fetches Java and Kotlin files from the specified directory path.
     * @param directoryPath The path to the directory to search in.
     * @return A list of file paths.
     * @throws IOException if an I/O error is encountered.
     */
    private static List<String> fetchFiles(String directoryPath) throws IOException {
        return Files.walk(Paths.get(directoryPath))
                .filter(Files::isRegularFile)
                .filter(p -> p.toString().endsWith(".java") || p.toString().endsWith(".kt"))
                .map(Path::toString)
                .collect(Collectors.toList());
    }

    /**
     * Displays the complexity results for the analyzed methods.
     * @param methodComplexity A map of method names to their complexity scores.
     */
    private static void displayResults(Map<String, Integer> methodComplexity) {
        // Extract the map with the most complex 3 methods for testing purposes
        methodComplexityGlobal = methodComplexity.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(3)
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new
                ));
        System.out.println("Top 3 methods by complexity:");
        methodComplexity.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(3)
                .forEach(entry -> System.out.println(entry.getKey() + " - Complexity: " + entry.getValue()));

        long nonCamelCaseCount = methodComplexity.keySet().stream()
                .filter(name -> !name.matches("[a-z]+[a-zA-Z0-9]*"))
                .count();
        double totalMethods = methodComplexity.size();
        double percentageNonCamelCase = (nonCamelCaseCount / totalMethods) * 100;
        percentageNonCamelCaseGlobal = percentageNonCamelCase;
        System.out.println("Percentage of methods not following camelCase: " + String.format("%.2f", percentageNonCamelCase) + "%");
    }

    public static void setReader(BufferedReader bufferedReader) {
        reader = bufferedReader;
    }

    public static Map<String, Integer> getMethodComplexity() {
        return methodComplexityGlobal;
    }

    public static double getPercentageNonCamelCase() {
        return percentageNonCamelCaseGlobal;
    }

}
