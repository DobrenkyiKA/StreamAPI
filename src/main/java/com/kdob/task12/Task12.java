package com.kdob.task12;

import com.kdob.common.Employee;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task12 {
    public List<Double> partA(List<Employee> employees) {
        return employees.stream()
                .filter(e -> "Engineering".equals(e.getDepartment()))
                .peek(engineer -> System.out.println(engineer.getName()))
                .map(Employee::getSalary)
                .toList();
    }

    public boolean partB1(List<Employee> employees) {
        return employees.stream()
                .anyMatch(employee -> employee.getSalary() > 100_000);
    }

    public boolean partB2(List<Employee> employees) {
        return employees.stream()
                .allMatch(employee -> employee.getAge() > 21);
    }

    public boolean partB3(List<Employee> employees) {
        return employees.stream()
                .noneMatch(employee -> "HR".equals(employee.getDepartment()));
    }

    public Map<Character, Long> partC(String string) {
        return string.chars()
                .mapToObj(ch -> (char) ch)
                .filter(ch -> ' ' != ch)
                .collect(Collectors.groupingBy(ch -> ch, Collectors.counting()));
    }

    public Employee[] partD(List<Employee> employees, String department) {
        return (employees == null ? Stream.<Employee>empty() : employees.stream())
                .filter(e -> department.equals(e.getDepartment()))
                .toArray(Employee[]::new);
    }
}
