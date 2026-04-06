package com.kdob.task11;

import com.kdob.common.Employee;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class InfiniteAndSlicingTest {

    private final InfiniteAndSlicing task = new InfiniteAndSlicing();

    @Test
    void shouldReturnFiveRandomUUIDs() {
        List<String> result = task.getFiveRandomUUID();
        assertEquals(5, result.size());
        result.forEach(uuid -> {
            assertNotNull(uuid);
            assertDoesNotThrow(() -> UUID.fromString(uuid));
        });
        assertEquals(5, result.stream().distinct().count(), "UUIDs should be unique");
    }

    @Test
    void shouldReturnTenPowersOfTwo() {
        List<Integer> result = task.getTenPowersOfTwo();
        List<Integer> expected = List.of(1, 2, 4, 8, 16, 32, 64, 128, 256, 512);
        assertEquals(expected, result);
    }

    @Test
    void shouldReturnMultiplesOfFiveFromFiveToFifty() {
        List<Integer> result = task.getMultiplesOfFiveFromFiveToFifty();
        List<Integer> expected = List.of(5, 10, 15, 20, 25, 30, 35, 40, 45, 50);
        assertEquals(expected, result);
    }

    @Test
    void shouldReturnEmployeesFrom3rdTo5thBySalaryDescending() {
        Employee e1 = new Employee("E1", "D1", 1000, 25);
        Employee e2 = new Employee("E2", "D1", 2000, 25);
        Employee e3 = new Employee("E3", "D1", 3000, 25);
        Employee e4 = new Employee("E4", "D1", 4000, 25);
        Employee e5 = new Employee("E5", "D1", 5000, 25);
        Employee e6 = new Employee("E6", "D1", 6000, 25);

        List<Employee> employees = List.of(e1, e2, e3, e4, e5, e6);
        // Sorted by salary descending: e6 (6000), e5 (5000), e4 (4000), e3 (3000), e2 (2000), e1 (1000)
        // Skip 2: e4 (4000), e3 (3000), e2 (2000), e1 (1000)
        // Limit 3: e4 (4000), e3 (3000), e2 (2000)
        
        List<Employee> result = task.getEmployeesFrom3rdTo5th(employees);
        assertEquals(3, result.size());
        assertEquals(List.of(e4, e3, e2), result);
    }

    @Test
    void shouldReturnIntegersLess50UsingTakeWhile() {
        List<Integer> input = List.of(10, 20, 30, 40, 50, 60, 40, 30);
        List<Integer> result = task.getLess50(input);
        // takeWhile stops when first element >= 50 is encountered
        assertEquals(List.of(10, 20, 30, 40), result);
    }

    @Test
    void shouldReturnIntegersMoreThan49UsingDropWhile() {
        List<Integer> input = List.of(10, 20, 30, 40, 50, 60, 40, 30);
        List<Integer> result = task.getMoreThan49(input);
        // dropWhile drops elements while they are < 50, then keeps the rest
        assertEquals(List.of(50, 60, 40, 30), result);
    }
}
