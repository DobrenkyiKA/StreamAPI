package com.kdob.task2;

import com.kdob.common.Employee;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class DepartmentNamesTest {

    private final DepartmentNames departmentNames = new DepartmentNames();

    @Test
    void shouldReturnEmptySetWhenInputIsEmpty() {
        Set<String> result = departmentNames.getDepartmentNames(List.of());
        assertTrue(result.isEmpty(), "Result should be empty for empty input list");
    }

    @Test
    void shouldReturnSetOfDepartmentNames() {
        Employee e1 = new Employee("John", "Sales", 100000, 30);
        Employee e2 = new Employee("Jane", "HR", 95000, 28);
        Employee e3 = new Employee("Alice", "Engineering", 90001, 25);
        
        Set<String> result = departmentNames.getDepartmentNames(List.of(e1, e2, e3));
        
        assertEquals(3, result.size(), "Result should contain 3 departments");
        assertTrue(result.containsAll(Set.of("Sales", "HR", "Engineering")));
    }

    @Test
    void shouldReturnUniqueDepartmentNames() {
        Employee e1 = new Employee("John", "Engineering", 100000, 30);
        Employee e2 = new Employee("Jane", "Engineering", 95000, 28);
        Employee e3 = new Employee("Alice", "HR", 90001, 25);
        
        Set<String> result = departmentNames.getDepartmentNames(List.of(e1, e2, e3));
        
        assertEquals(2, result.size(), "Result should contain unique departments only");
        assertTrue(result.containsAll(Set.of("Engineering", "HR")));
    }

    @Test
    void shouldHandleNullOrEmptyDepartmentNames() {
        Employee e1 = new Employee("NoDept", null, 50000, 20);
        Employee e2 = new Employee("EmptyDept", "", 50000, 20);
        
        Set<String> result = departmentNames.getDepartmentNames(List.of(e1, e2));
        
        assertEquals(2, result.size());
        assertTrue(result.contains(null));
        assertTrue(result.contains(""));
    }
}
