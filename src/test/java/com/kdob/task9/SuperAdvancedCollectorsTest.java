package com.kdob.task9;

import com.kdob.common.Employee;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class SuperAdvancedCollectorsTest {

    private final SuperAdvancedCollectors task = new SuperAdvancedCollectors();

    @Test
    void shouldThrowExceptionWhenGettingRichestEmployeeFromEmptyList() {
        assertThrows(NoSuchElementException.class, () -> task.theRichestEmployee(List.of()));
    }

    @Test
    void shouldReturnTheRichestEmployeeName() {
        Employee e1 = new Employee("John", "Engineering", 100000, 30);
        Employee e2 = new Employee("Alice", "HR", 120000, 25);
        Employee e3 = new Employee("Jane", "Engineering", 110000, 28);

        String result = task.theRichestEmployee(List.of(e1, e2, e3));

        assertEquals("Alice", result);
    }

    @Test
    void shouldThrowExceptionWhenGettingSalaryRangeFromEmptyList() {
        assertThrows(NoSuchElementException.class, () -> task.getSalaryRange(List.of()));
    }

    @Test
    void shouldReturnSalaryRange() {
        Employee e1 = new Employee("John", "Engineering", 100000, 30);
        Employee e2 = new Employee("Alice", "HR", 80000, 25);
        Employee e3 = new Employee("Jane", "Engineering", 110000, 28);

        double result = task.getSalaryRange(List.of(e1, e2, e3));

        assertEquals(30000.0, result, 0.001);
    }

    @Test
    void shouldReturnZeroRangeForSingleEmployee() {
        Employee e1 = new Employee("John", "Engineering", 100000, 30);

        double result = task.getSalaryRange(List.of(e1));

        assertEquals(0.0, result, 0.001);
    }

    @Test
    void shouldReturnEmptyMapWhenGettingTotalSalaryPerDepartmentForEmptyList() {
        Map<String, Double> result = task.getTotalSalaryPerDepartment(List.of());
        assertTrue(result.isEmpty());
    }

    @Test
    void shouldReturnTotalSalaryPerDepartment() {
        Employee e1 = new Employee("John", "Engineering", 100000, 30);
        Employee e2 = new Employee("Jane", "Engineering", 110000, 35);
        Employee e3 = new Employee("Alice", "HR", 80000, 25);
        Employee e4 = new Employee("Bob", "HR", 85000, 40);

        Map<String, Double> result = task.getTotalSalaryPerDepartment(List.of(e1, e2, e3, e4));

        assertEquals(2, result.size());
        assertEquals(210000.0, result.get("Engineering"), 0.001);
        assertEquals(165000.0, result.get("HR"), 0.001);
    }
}
