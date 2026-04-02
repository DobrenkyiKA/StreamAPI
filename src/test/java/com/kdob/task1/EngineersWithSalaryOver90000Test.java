package com.kdob.task1;

import com.kdob.common.Employee;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EngineersWithSalaryOver90000Test {

    private final EngineersWithSalaryOver90000 filterer = new EngineersWithSalaryOver90000();

    @Test
    void shouldReturnEmptyListWhenInputIsEmpty() {
        List<Employee> result = filterer.filter(List.of());
        assertTrue(result.isEmpty(), "Result should be empty for empty input list");
    }

    @Test
    void shouldReturnEmptyListWhenNoEmployeeIsEngineer() {
        Employee e1 = new Employee("John", "Sales", 100000, 30);
        Employee e2 = new Employee("Jane", "HR", 95000, 28);
        List<Employee> result = filterer.filter(List.of(e1, e2));
        assertTrue(result.isEmpty(), "Result should be empty when no engineers are present");
    }

    @Test
    void shouldReturnEmptyListWhenNoEngineerHasSalaryOver90000() {
        Employee e1 = new Employee("Alice", "Engineering", 90000, 25);
        Employee e2 = new Employee("Bob", "Engineering", 80000, 35);
        List<Employee> result = filterer.filter(List.of(e1, e2));
        assertTrue(result.isEmpty(), "Result should be empty when engineers have salary <= 90000");
    }

    @Test
    void shouldReturnEngineersWithSalaryOver90000() {
        Employee e1 = new Employee("Alice", "Engineering", 90001, 25);
        Employee e2 = new Employee("Bob", "Engineering", 120000, 35);
        Employee e3 = new Employee("Charlie", "Engineering", 90000, 40);
        List<Employee> employees = List.of(e1, e2, e3);
        
        List<Employee> result = filterer.filter(employees);
        
        assertEquals(2, result.size(), "Result should contain 2 employees");
        assertTrue(result.contains(e1), "Result should contain Alice");
        assertTrue(result.contains(e2), "Result should contain Bob");
        assertFalse(result.contains(e3), "Result should not contain Charlie (salary not > 90000)");
    }

    @Test
    void shouldFilterMixedEmployeesCorrectly() {
        Employee matching = new Employee("Matching", "Engineering", 95000, 30);
        Employee wrongDept = new Employee("WrongDept", "HR", 100000, 35);
        Employee lowSalary = new Employee("LowSalary", "Engineering", 90000, 25);
        
        List<Employee> result = filterer.filter(List.of(matching, wrongDept, lowSalary));
        
        assertEquals(List.of(matching), result, "Result should only contain matching employee");
    }
}