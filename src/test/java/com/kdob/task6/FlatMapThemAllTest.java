package com.kdob.task6;

import com.kdob.common.Department;
import com.kdob.common.Employee;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FlatMapThemAllTest {

    private final FlatMapThemAll flatMapper = new FlatMapThemAll();

    @Test
    void shouldReturnEmptyListWhenDepartmentsAreEmpty() {
        List<Employee> result = flatMapper.getAllEmployees(List.of());
        assertTrue(result.isEmpty(), "Result should be empty for empty departments list");
    }

    @Test
    void shouldReturnAllEmployeesFromSingleDepartment() {
        Employee e1 = new Employee("John", "Engineering", 100000, 30);
        Employee e2 = new Employee("Jane", "Engineering", 95000, 28);
        Department dept = new Department("Engineering", List.of(e1, e2));
        
        List<Employee> result = flatMapper.getAllEmployees(List.of(dept));
        
        assertEquals(2, result.size());
        assertTrue(result.containsAll(List.of(e1, e2)));
    }

    @Test
    void shouldReturnAllEmployeesFromMultipleDepartments() {
        Employee e1 = new Employee("John", "Engineering", 100000, 30);
        Employee e2 = new Employee("Jane", "Engineering", 95000, 28);
        Department engineering = new Department("Engineering", List.of(e1, e2));

        Employee e3 = new Employee("Alice", "HR", 80000, 25);
        Department hr = new Department("HR", List.of(e3));

        List<Employee> result = flatMapper.getAllEmployees(List.of(engineering, hr));

        assertEquals(3, result.size());
        assertTrue(result.containsAll(List.of(e1, e2, e3)));
    }

    @Test
    void shouldHandleEmptyDepartmentsInList() {
        Employee e1 = new Employee("John", "Engineering", 100000, 30);
        Department engineering = new Department("Engineering", List.of(e1));
        Department emptyDept = new Department("Empty", List.of());

        List<Employee> result = flatMapper.getAllEmployees(List.of(engineering, emptyDept));

        assertEquals(1, result.size());
        assertEquals(e1, result.get(0));
    }

    @Test
    void shouldReturnSortedUniqueWordsFromSentences() {
        List<String> sentences = List.of(
                "The quick brown fox",
                "jumps over the lazy dog",
                "THE QUICK BROWN FOX"
        );

        List<String> result = flatMapper.getSortedWords(sentences);

        List<String> expected = List.of(
                "brown", "dog", "fox", "jumps", "lazy", "over", "quick", "the"
        );

        assertEquals(expected, result);
    }

    @Test
    void shouldHandleSentencesWithNonWordCharacters() {
        List<String> sentences = List.of(
                "Hello, world!",
                "Hello-world: hello.world"
        );

        List<String> result = flatMapper.getSortedWords(sentences);

        List<String> expected = List.of("hello", "world");

        assertEquals(expected, result);
    }

    @Test
    void shouldReturnEmptyListForEmptySentences() {
        List<String> result = flatMapper.getSortedWords(List.of());
        assertTrue(result.isEmpty());
    }

    @Test
    void shouldReturnEmptyListForBlankSentences() {
        List<String> result = flatMapper.getSortedWords(List.of(" ", "  ", "!!!"));
        // SPLIT_ON_NON_WORDS_FUNCTION uses sentence.split("\\W+")
        // " ".split("\\W+") -> [] (empty array)
        // "  ".split("\\W+") -> []
        // "!!!".split("\\W+") -> []
        assertTrue(result.isEmpty(), "Should handle blank or non-word sentences");
    }
}
