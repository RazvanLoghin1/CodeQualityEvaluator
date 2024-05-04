package Testing;

import java.io.*;

import com.CodeQualityEvaluator;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.InputStream;


public class unitTests {

    @Test
    void testDirectoryWithJavaFiles() throws IOException {
        String testDirectoryPath = "src/filesToTest/javaFiles";

        // Set up expected outcomes
        Map<String, Integer> expectedMethodComplexity = new HashMap<>();
        expectedMethodComplexity.put("veryComplexMethod", 3);
        expectedMethodComplexity.put("ComplexMethod", 2);
        expectedMethodComplexity.put("convertListToMap", 1);
        double expectedPercentageNonCamelCase = 6.67;

        // Run the method under test
        CodeQualityEvaluator.evaluateCodeQuality(testDirectoryPath);

        // Assert expected outcomes
        assertEquals(expectedMethodComplexity, CodeQualityEvaluator.getMethodComplexity());
        // Make sure the difference is negligible in order to bypass the division approximation
        assertTrue(Math.abs(expectedPercentageNonCamelCase - CodeQualityEvaluator.getPercentageNonCamelCase()) < 0.01);
    }

    @Test
    void testDirectoryWithKotlinFiles() throws IOException {
        // Create a mock input stream with the directory path
        String testDirectoryPath = "src/filesToTest/kotlinFiles";

        // Expected method complexity map
        Map<String, Integer> expectedMethodComplexity = new HashMap<>();
        expectedMethodComplexity.put("calculateSum", 4);
        expectedMethodComplexity.put("printDetails", 2);
        expectedMethodComplexity.put("processMap", 1);
        double expectedPercentageNonCamelCase = 0;

        // Run the method under test
        CodeQualityEvaluator.evaluateCodeQuality(testDirectoryPath);

        // Assert expected outcomes
        assertEquals(expectedMethodComplexity, CodeQualityEvaluator.getMethodComplexity());
        // Make sure the difference is negligible in order to bypass the division approximation
        assertTrue(Math.abs(expectedPercentageNonCamelCase - CodeQualityEvaluator.getPercentageNonCamelCase()) < 0.01);
    }
}


