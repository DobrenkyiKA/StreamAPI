package com.kdob.task8;

import com.kdob.common.Employee;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AdvancedCollectors {

    public String getAllEmployeesNames(List<Employee> employees) {
        return employees.stream()
                .map(Employee::getName)
                .sorted()
                .collect(Collectors.joining(", ", "[", "]"));
    }

    public Map<String, Double> getSalaryPerEmployee(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.toMap(Employee::getName, Employee::getSalary));
    }

    public Map<String, Double> calculateHighestSalaryPerDepartment(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.toMap(Employee::getDepartment, Employee::getSalary, Math::max));
    }

    public Map<String, List<String>> employeeNamesPerDepartment(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.mapping(Employee::getName, Collectors.toList())));
    }
}
