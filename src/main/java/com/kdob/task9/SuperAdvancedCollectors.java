package com.kdob.task9;

import com.kdob.common.Employee;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SuperAdvancedCollectors {

    private static final Comparator<Employee> BY_SALARY_COMPARATOR = Comparator.comparingDouble(Employee::getSalary);

    public String theRichestEmployee(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary)), employee -> employee.map(Employee::getName).orElseThrow()));
    }

    public double getSalaryRange(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.teeing(Collectors.maxBy(BY_SALARY_COMPARATOR), Collectors.minBy(BY_SALARY_COMPARATOR), (max, min) -> max.map(Employee::getSalary).orElseThrow() - min.map(Employee::getSalary).orElseThrow()));
    }

    public Map<String, Double> getTotalSalaryPerDepartment(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.summingDouble(Employee::getSalary)));
    }
}
