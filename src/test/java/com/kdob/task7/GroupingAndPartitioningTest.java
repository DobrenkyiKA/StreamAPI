package com.kdob.task7;

import com.kdob.common.Employee;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class GroupingAndPartitioningTest {

    private final GroupingAndPartitioning task = new GroupingAndPartitioning();

    @Test
    void shouldReturnEmptyMapForEmptyListWhenGroupingByDepartment() {
        Map<String, List<Employee>> result = task.getEmployeesByDepartment(List.of());
        assertTrue(result.isEmpty());
    }

    @Test
    void shouldGroupEmployeesByDepartment() {
        Employee e1 = new Employee("John", "Engineering", 100000, 30);
        Employee e2 = new Employee("Jane", "Engineering", 95000, 28);
        Employee e3 = new Employee("Alice", "HR", 80000, 25);

        Map<String, List<Employee>> result = task.getEmployeesByDepartment(List.of(e1, e2, e3));

        assertEquals(2, result.size());
        assertEquals(2, result.get("Engineering").size());
        assertTrue(result.get("Engineering").containsAll(List.of(e1, e2)));
        assertEquals(1, result.get("HR").size());
        assertTrue(result.get("HR").contains(e3));
    }

    @Test
    void shouldReturnEmptyMapForEmptyListWhenCountingByDepartment() {
        Map<String, Long> result = task.getNumberOfEmployeesPerDepartment(List.of());
        assertTrue(result.isEmpty());
    }

    @Test
    void shouldCountEmployeesPerDepartment() {
        Employee e1 = new Employee("John", "Engineering", 100000, 30);
        Employee e2 = new Employee("Jane", "Engineering", 95000, 28);
        Employee e3 = new Employee("Alice", "HR", 80000, 25);

        Map<String, Long> result = task.getNumberOfEmployeesPerDepartment(List.of(e1, e2, e3));

        assertEquals(2, result.size());
        assertEquals(2L, result.get("Engineering"));
        assertEquals(1L, result.get("HR"));
    }

    @Test
    void shouldReturnEmptyMapForEmptyListWhenPartitioningByEarnings() {
        Map<Boolean, List<Employee>> result = task.partitionByEarnings(List.of());
        // partitioningBy always returns a map with both keys (true and false) even if the input is empty
        assertEquals(2, result.size());
        assertTrue(result.get(true).isEmpty());
        assertTrue(result.get(false).isEmpty());
    }

    @Test
    void shouldPartitionEmployeesByEarnings() {
        Employee e1 = new Employee("Rich Guy", "Engineering", 100000, 30);
        Employee e2 = new Employee("Edge Guy", "Engineering", 80000, 28);
        Employee e3 = new Employee("Poor Guy", "HR", 79999.99, 25);

        Map<Boolean, List<Employee>> result = task.partitionByEarnings(List.of(e1, e2, e3));

        assertEquals(2, result.size());
        assertEquals(2, result.get(true).size());
        assertTrue(result.get(true).containsAll(List.of(e1, e2)));
        assertEquals(1, result.get(false).size());
        assertTrue(result.get(false).contains(e3));
    }
}
