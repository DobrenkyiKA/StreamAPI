package com.kdob.task3;

import com.kdob.common.Employee;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OrderingAndDistinctionTest {

    private final OrderingAndDistinction processor = new OrderingAndDistinction();

    @Test
    void shouldReturnEmptyListWhenInputIsEmptyForOrder() {
        List<Employee> result = processor.order(List.of());
        assertTrue(result.isEmpty(), "Result should be empty for empty input list");
    }

    @Test
    void shouldSortBySalaryDescendingThenByNameAscending() {
        Employee e1 = new Employee("Alice", "Engineering", 100000, 30);
        Employee e2 = new Employee("Bob", "Sales", 100000, 35);
        Employee e3 = new Employee("Charlie", "HR", 120000, 40);
        Employee e4 = new Employee("David", "Engineering", 80000, 25);
        
        List<Employee> input = List.of(e1, e2, e3, e4);
        List<Employee> result = processor.order(input);
        
        // Correct order: 
        // 1. Charlie (120000)
        // 2. Alice (100000) - name A
        // 3. Bob (100000) - name B
        // 4. David (80000)
        
        assertEquals(List.of(e3, e1, e2, e4), result);
    }

    @Test
    void shouldReturnZeroForDistinctionWhenInputIsEmpty() {
        long result = processor.distinction(List.of());
        assertEquals(0, result, "Count should be 0 for empty input");
    }

    @Test
    void shouldCountUniqueSalaries() {
        Employee e1 = new Employee("Alice", "Engineering", 100000, 30);
        Employee e2 = new Employee("Bob", "Sales", 100000, 35); // duplicate salary
        Employee e3 = new Employee("Charlie", "HR", 120000, 40);
        Employee e4 = new Employee("David", "Engineering", 80000, 25);
        Employee e5 = new Employee("Eve", "Sales", 80000, 28); // duplicate salary
        
        List<Employee> input = List.of(e1, e2, e3, e4, e5);
        long result = processor.distinction(input);
        
        // Unique salaries: 100000, 120000, 80000 (3 in total)
        assertEquals(3, result, "Should count 3 unique salaries");
    }

    @Test
    void shouldHandleSingleEmployee() {
        Employee e = new Employee("John", "Sales", 100000, 30);
        List<Employee> input = List.of(e);
        
        assertEquals(List.of(e), processor.order(input));
        assertEquals(1, processor.distinction(input));
    }
}
