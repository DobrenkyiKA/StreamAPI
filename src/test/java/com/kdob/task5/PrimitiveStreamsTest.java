package com.kdob.task5;

import com.kdob.common.Employee;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PrimitiveStreamsTest {

    private final PrimitiveStreams processor = new PrimitiveStreams();
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    void tearDown() {
        System.setOut(originalOut);
    }

    @Test
    void getEvenNumbersShouldReturnEvenNumbersFrom1To20() {
        List<Integer> result = processor.getEvenNumbers();
        List<Integer> expected = List.of(2, 4, 6, 8, 10, 12, 14, 16, 18, 20);
        assertEquals(expected, result, "Should return even numbers from 2 to 20");
    }

    @Test
    void calcSum1to100ShouldReturnSumOfNumbersFrom1To100() {
        int result = processor.calcSum1to100();
        // Sum of 1..n is n(n+1)/2, so 100*101/2 = 5050
        assertEquals(5050, result, "Should return sum of numbers from 1 to 100 which is 5050");
    }

    @Test
    void summaryStatisticsShouldPrintCorrectStats() {
        Employee e1 = new Employee("Alice", "Engineering", 1000, 30);
        Employee e2 = new Employee("Bob", "Marketing", 2000, 35);
        Employee e3 = new Employee("Charlie", "Sales", 3000, 40);

        processor.summaryStatistics(List.of(e1, e2, e3));

        String output = outContent.toString();
        assertTrue(output.contains("Minimum salary: 1000.0"), "Should contain correct minimum salary");
        assertTrue(output.contains("Maximum salary: 3000.0"), "Should contain correct maximum salary");
        assertTrue(output.contains("Average salary: 2000.0"), "Should contain correct average salary");
    }

    @Test
    void summaryStatisticsShouldHandleEmptyList() {
        processor.summaryStatistics(List.of());

        String output = outContent.toString();
        assertTrue(output.contains("Minimum salary: Infinity"), "Should handle empty list (min is Infinity for empty DoubleSummaryStatistics)");
        assertTrue(output.contains("Maximum salary: -Infinity"), "Should handle empty list (max is -Infinity for empty DoubleSummaryStatistics)");
        assertTrue(output.contains("Average salary: 0.0"), "Should handle empty list (average is 0.0 for empty DoubleSummaryStatistics)");
    }
}
