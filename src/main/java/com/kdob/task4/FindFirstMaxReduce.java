package com.kdob.task4;

import com.kdob.common.Employee;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class FindFirstMaxReduce {

    private static final String MARKETING_DEPARTMENT = "Marketing";
    private static final Predicate<Employee> THE_FIRST_MARKETER_PREDICATE = employee -> MARKETING_DEPARTMENT.equals(employee.getDepartment());
    private static final Comparator<Employee> SORT_BY_NAME = Comparator.comparing(Employee::getName);

    public Optional<Employee> getFirstMarketer(List<Employee> employees) {
        return employees.stream()
                .filter(THE_FIRST_MARKETER_PREDICATE).min(SORT_BY_NAME);
    }

    public Optional<Employee> getRichest(List<Employee> employees) {
        return employees.stream()
                .max(Comparator.comparing(Employee::getSalary));
    }

    public double getTotalSalary(List<Employee> employees) {
        return employees.stream()
                .mapToDouble(Employee::getSalary)
                .reduce(0, Double::sum);
    }
}
