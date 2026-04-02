package com.kdob.task4;

import com.kdob.common.Employee;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class FindFirstMaxReduceTest {

    private final FindFirstMaxReduce processor = new FindFirstMaxReduce();

    @Test
    void getFirstMarketerShouldReturnEmptyOptionalWhenInputIsEmpty() {
        Optional<Employee> result = processor.getFirstMarketer(List.of());
        assertTrue(result.isEmpty(), "Should return empty Optional for empty input list");
    }

    @Test
    void getFirstMarketerShouldReturnEmptyOptionalWhenNoMarketerIsPresent() {
        Employee e1 = new Employee("Alice", "Engineering", 100000, 30);
        Employee e2 = new Employee("Bob", "Sales", 90000, 35);
        Optional<Employee> result = processor.getFirstMarketer(List.of(e1, e2));
        assertTrue(result.isEmpty(), "Should return empty Optional when no marketers are present");
    }

    @Test
    void getFirstMarketerShouldReturnFirstMarketerByName() {
        Employee e1 = new Employee("Charlie", "Marketing", 100000, 30);
        Employee e2 = new Employee("Alice", "Marketing", 110000, 25);
        Employee e3 = new Employee("Bob", "Marketing", 120000, 35);
        Employee e4 = new Employee("David", "Engineering", 150000, 40);
        
        Optional<Employee> result = processor.getFirstMarketer(List.of(e1, e2, e3, e4));
        
        assertTrue(result.isPresent(), "Should return a marketer");
        assertEquals("Alice", result.get().getName(), "Should return the marketer with the first name alphabetically");
    }

    @Test
    void getRichestShouldReturnEmptyOptionalWhenInputIsEmpty() {
        Optional<Employee> result = processor.getRichest(List.of());
        assertTrue(result.isEmpty(), "Should return empty Optional for empty input list");
    }

    @Test
    void getRichestShouldReturnTheEmployeeWithMaxSalary() {
        Employee e1 = new Employee("Alice", "Engineering", 100000, 30);
        Employee e2 = new Employee("Bob", "Marketing", 150000, 35);
        Employee e3 = new Employee("Charlie", "Sales", 120000, 40);
        
        Optional<Employee> result = processor.getRichest(List.of(e1, e2, e3));
        
        assertTrue(result.isPresent(), "Should return an employee");
        assertEquals(e2, result.get(), "Should return the richest employee");
    }

    @Test
    void getTotalSalaryShouldReturnZeroWhenInputIsEmpty() {
        double result = processor.getTotalSalary(List.of());
        assertEquals(0, result, "Should return 0 for empty input list");
    }

    @Test
    void getTotalSalaryShouldReturnSumOfSalaries() {
        Employee e1 = new Employee("Alice", "Engineering", 100000, 30);
        Employee e2 = new Employee("Bob", "Marketing", 150000, 35);
        Employee e3 = new Employee("Charlie", "Sales", 120000, 40);
        
        double result = processor.getTotalSalary(List.of(e1, e2, e3));
        
        assertEquals(370000, result, "Should return the sum of all salaries");
    }
}
