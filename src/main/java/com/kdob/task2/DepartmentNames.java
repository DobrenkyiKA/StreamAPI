package com.kdob.task2;

import com.kdob.common.Employee;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class DepartmentNames {
    public Set<String> getDepartmentNames(List<Employee> employees) {
        return employees.stream()
                .map(Employee::getDepartment)
                .collect(Collectors.toSet());
    }
}
