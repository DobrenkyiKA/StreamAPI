package com.kdob.task7;

import com.kdob.common.Employee;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class GroupingAndPartitioning {

    private static final Predicate<Employee> RICH_EMPLOYEES_PREDICATE = employee -> employee.getSalary() >= 80000;

    public Map<String, List<Employee>> getEmployeesByDepartment(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
    }

    public Map<String, Long> getNumberOfEmployeesPerDepartment(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
    }

    public Map<Boolean, List<Employee>> partitionByEarnings(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.partitioningBy(RICH_EMPLOYEES_PREDICATE));
    }
}
