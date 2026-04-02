package com.kdob.task3;

import com.kdob.common.Employee;

import java.util.Comparator;
import java.util.List;

public class OrderingAndDistinction {

    public List<Employee> order(List<Employee> employees) {
        return employees.stream()
                .sorted(Comparator.comparing(Employee::getSalary).reversed().thenComparing(Employee::getName))
                .toList();
    }

    public long distinction(List<Employee> employees) {
        return employees.stream()
                .map(Employee::getSalary)
                .distinct()
                .count();
    }
}
