package com.kdob.task8;

import com.kdob.common.Employee;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class AdvancedCollectorsTest {

    private final AdvancedCollectors task = new AdvancedCollectors();

    @Test
    void shouldReturnEmptyFormattedStringForEmptyListWhenGettingNames() {
        String result = task.getAllEmployeesNames(List.of());
        assertEquals("[]", result);
    }

    @Test
    void shouldReturnSortedAndFormattedEmployeeNames() {
        Employee e1 = new Employee("John", "Engineering", 100000, 30);
        Employee e2 = new Employee("Alice", "HR", 80000, 25);
        Employee e3 = new Employee("Jane", "Engineering", 95000, 28);

        String result = task.getAllEmployeesNames(List.of(e1, e2, e3));

        assertEquals("[Alice, Jane, John]", result);
    }

    @Test
    void shouldReturnEmptyMapForEmptyListWhenGettingSalaryPerEmployee() {
        Map<String, Double> result = task.getSalaryPerEmployee(List.of());
        assertTrue(result.isEmpty());
    }

    @Test
    void shouldReturnMapOfSalaryPerEmployee() {
        Employee e1 = new Employee("John", "Engineering", 100000, 30);
        Employee e2 = new Employee("Alice", "HR", 80000, 25);

        Map<String, Double> result = task.getSalaryPerEmployee(List.of(e1, e2));

        assertEquals(2, result.size());
        assertEquals(100000.0, result.get("John"));
        assertEquals(80000.0, result.get("Alice"));
    }

    @Test
    void shouldThrowExceptionWhenDuplicateNamesInGetSalaryPerEmployee() {
        Employee e1 = new Employee("John", "Engineering", 100000, 30);
        Employee e2 = new Employee("John", "HR", 80000, 25);

        assertThrows(IllegalStateException.class, () -> task.getSalaryPerEmployee(List.of(e1, e2)));
    }

    @Test
    void shouldReturnEmptyMapForEmptyListWhenCalculatingHighestSalaryPerDepartment() {
        Map<String, Double> result = task.calculateHighestSalaryPerDepartment(List.of());
        assertTrue(result.isEmpty());
    }

    @Test
    void shouldCalculateHighestSalaryPerDepartment() {
        Employee e1 = new Employee("John", "Engineering", 100000, 30);
        Employee e2 = new Employee("Jane", "Engineering", 110000, 35);
        Employee e3 = new Employee("Alice", "HR", 80000, 25);
        Employee e4 = new Employee("Bob", "HR", 85000, 40);

        Map<String, Double> result = task.calculateHighestSalaryPerDepartment(List.of(e1, e2, e3, e4));

        assertEquals(2, result.size());
        assertEquals(110000.0, result.get("Engineering"));
        assertEquals(85000.0, result.get("HR"));
    }

    @Test
    void shouldReturnEmptyMapForEmptyListWhenGettingEmployeeNamesPerDepartment() {
        Map<String, List<String>> result = task.employeeNamesPerDepartment(List.of());
        assertTrue(result.isEmpty());
    }

    @Test
    void shouldReturnEmployeeNamesPerDepartment() {
        Employee e1 = new Employee("John", "Engineering", 100000, 30);
        Employee e2 = new Employee("Jane", "Engineering", 110000, 35);
        Employee e3 = new Employee("Alice", "HR", 80000, 25);

        Map<String, List<String>> result = task.employeeNamesPerDepartment(List.of(e1, e2, e3));

        assertEquals(2, result.size());
        assertEquals(List.of("John", "Jane"), result.get("Engineering"));
        assertEquals(List.of("Alice"), result.get("HR"));
    }
}
