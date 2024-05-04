package com;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This class is responsible for analyzing Java and Kotlin files to calculate the complexity of methods.
 */
public class MethodAnalyzer {

    /**
     * Analyzes the complexity of methods in the provided list of files.
     * @param files The list of file paths to analyze.
     * @return A map containing method names and their complexity scores.
     * @throws IOException if an I/O error occurs while reading the files.
     */
    public Map<String, Integer> analyzeFiles(List<String> files) throws IOException {
        Map<String, Integer> methodComplexity = new HashMap<>();
        for (String file : files) {
            analyzeFile(file, methodComplexity);
        }
        return methodComplexity;
    }

    /**
     * Analyzes the complexity of methods in a single file and updates the method complexity map.
     * @param file The path of the file to analyze.
     * @param methodComplexity The map to store method names and their complexity scores.
     * @throws IOException if an I/O error occurs while reading the file.
     */
    private void analyzeFile(String file, Map<String, Integer> methodComplexity) throws IOException {
        // Determine if the file is a Java or Kotlin file
        boolean isJavaFile = file.endsWith(".java");
        // Choose the appropriate regex pattern based on the file type
        Pattern pattern = isJavaFile ? CodeQualityEvaluator.patternJava : CodeQualityEvaluator.patternKotlin;
        // Read the content of the file
        String content = Files.readString(Paths.get(file));
        // Create a matcher to find method signatures in the file content
        Matcher matcher = pattern.matcher(content);

        // Iterate over each method signature found in the file
        while (matcher.find()) {
            // Extract the method name and calculate its complexity
            String methodName = isJavaFile ? matcher.group(3) : matcher.group(2);
            int complexity = calculateComplexity(content, matcher.start());
            // Update the method complexity map with the calculated complexity score
            methodComplexity.put(methodName, complexity);
        }
    }

    /**
     * Calculates the complexity of a method based on control flow elements.
     * @param content The content of the method.
     * @param startIdx The index of the method's opening brace.
     * @return The complexity score of the method.
     */
    private int calculateComplexity(String content, int startIdx) {
        // Find the index of the opening brace of the method
        int openBraceIndex = content.indexOf('{', startIdx) + 1;
        int braceCount = 1;
        int endIdx = openBraceIndex;

        // Find the matching closing brace of the method
        while (braceCount > 0 && endIdx < content.length()) {
            if (content.charAt(endIdx) == '{') {
                braceCount++;
            } else if (content.charAt(endIdx) == '}') {
                braceCount--;
            }
            endIdx++;
        }

        // Extract only the method's content between the opening and closing braces
        String methodContent = content.substring(openBraceIndex, endIdx - 1);
        // Count control flow keywords within the method's content to calculate complexity
        return countKeywords(methodContent);
    }

    public static int countKeywords(String methodContent) {
        // Patterns to detect keywords, strings, and comments
        String keywordPattern = "\\b(if|for|while|switch|case)\\b";
        String stringPattern = "\"(\\\\.|[^\"\\\\])*\"";
        String singleCommentPattern = "//.*";
        String multiCommentPattern = "/\\*.*?\\*/";

        // Remove strings and comments from the code
        String sanitizedContent = methodContent.replaceAll(stringPattern, "");
        sanitizedContent = sanitizedContent.replaceAll(singleCommentPattern, "");
        sanitizedContent = sanitizedContent.replaceAll(multiCommentPattern, "");

        // Match keywords in the sanitized content
        Pattern pattern = Pattern.compile(keywordPattern);
        Matcher matcher = pattern.matcher(sanitizedContent);

        int count = 0;
        while (matcher.find()) {
            count++;
        }
        return count;
    }
}

