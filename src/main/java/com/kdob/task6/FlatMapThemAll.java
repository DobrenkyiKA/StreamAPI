package com.kdob.task6;

import com.kdob.common.Department;
import com.kdob.common.Employee;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class FlatMapThemAll {

    public static final Function<String, String[]> SPLIT_ON_NON_WORDS_FUNCTION = sentence -> sentence.split("\\W+");

    public List<Employee> getAllEmployees(List<Department> departments) {
        return departments.stream()
                .map(Department::getEmployees)
                .flatMap(List::stream)
                .toList();
    }

    public List<String> getSortedWords(List<String> sentences) {
        return sentences.stream()
                .map(SPLIT_ON_NON_WORDS_FUNCTION)
                .flatMap(Arrays::stream)
                .map(String::toLowerCase)
                .distinct()
                .sorted()
                .toList();
    }
}
