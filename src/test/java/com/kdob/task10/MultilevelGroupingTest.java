package com.kdob.task10;

import com.kdob.common.Employee;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class MultilevelGroupingTest {

    private final MultilevelGrouping task = new MultilevelGrouping();

    @Test
    void shouldReturnEmptyMapForGetRichestByDepartmentWithEmptyList() {
        Map<String, List<Employee>> result = task.getRichestByDepartment(List.of());
        assertTrue(result.isEmpty());
    }

    @Test
    void shouldReturnEmptyListForDepartmentsWithNoRichestEmployees() {
        Employee e1 = new Employee("John", "Engineering", 70000, 30);
        Employee e2 = new Employee("Alice", "HR", 50000, 25);

        Map<String, List<Employee>> result = task.getRichestByDepartment(List.of(e1, e2));

        assertEquals(2, result.size());
        assertTrue(result.get("Engineering").isEmpty());
        assertTrue(result.get("HR").isEmpty());
    }

    @Test
    void shouldReturnRichestEmployeesByDepartment() {
        Employee e1 = new Employee("John", "Engineering", 85000, 30);
        Employee e2 = new Employee("Jane", "Engineering", 75000, 35);
        Employee e3 = new Employee("Alice", "HR", 90000, 25);
        Employee e4 = new Employee("Bob", "HR", 80000, 40);

        Map<String, List<Employee>> result = task.getRichestByDepartment(List.of(e1, e2, e3, e4));

        assertEquals(2, result.size());
        assertEquals(List.of(e1), result.get("Engineering"));
        assertEquals(List.of(e3, e4), result.get("HR"));
    }

    @Test
    void shouldReturnEmptyMapForGetSkillsByDepartmentWithEmptyList() {
        Map<String, Set<String>> result = task.getSkillsByDepartment(List.of());
        assertTrue(result.isEmpty());
    }

    @Test
    void shouldReturnSkillsByDepartment() {
        Employee e1 = new Employee("John", "Engineering", 80000, 30, List.of("Java", "SQL"));
        Employee e2 = new Employee("Jane", "Engineering", 85000, 35, List.of("Java", "AWS"));
        Employee e3 = new Employee("Alice", "HR", 60000, 25, List.of("Recruiting"));
        Employee e4 = new Employee("Bob", "HR", 65000, 40, List.of("Recruiting", "Excel"));

        Map<String, Set<String>> result = task.getSkillsByDepartment(List.of(e1, e2, e3, e4));

        assertEquals(2, result.size());
        assertEquals(Set.of("Java", "SQL", "AWS"), result.get("Engineering"));
        assertEquals(Set.of("Recruiting", "Excel"), result.get("HR"));
    }

    @Test
    void shouldReturnEmptyMapForGetEmployeesByAgeByDepartmentWithEmptyList() {
        Map<String, Map<String, List<Employee>>> result = task.getEmployeesByAgeByDepartment(List.of());
        assertTrue(result.isEmpty());
    }

    @Test
    void shouldReturnEmployeesByAgeRangeAndDepartment() {
        Employee e1 = new Employee("John", "Engineering", 80000, 25);
        Employee e2 = new Employee("Jane", "Engineering", 85000, 28);
        Employee e3 = new Employee("Bob", "Engineering", 90000, 35);
        Employee e4 = new Employee("Alice", "HR", 60000, 22);
        Employee e5 = new Employee("Charlie", "HR", 65000, 45);

        Map<String, Map<String, List<Employee>>> result = task.getEmployeesByAgeByDepartment(List.of(e1, e2, e3, e4, e5));

        assertEquals(2, result.size());

        Map<String, List<Employee>> engineering = result.get("Engineering");
        assertEquals(2, engineering.size());
        assertEquals(List.of(e1, e2), engineering.get("20-29"));
        assertEquals(List.of(e3), engineering.get("30-39"));

        Map<String, List<Employee>> hr = result.get("HR");
        assertEquals(2, hr.size());
        assertEquals(List.of(e4), hr.get("20-29"));
        assertEquals(List.of(e5), hr.get("40-49"));
    }
}
