package com.kdob.task1;

import com.kdob.common.Employee;

import java.util.List;
import java.util.function.Predicate;

public class EngineersWithSalaryOver90000 {

    private static final String ENGINEERING_DEPARTMENT = "Engineering";
    private static final Predicate<Employee> isEngineer = employee -> employee.getDepartment().equals(ENGINEERING_DEPARTMENT);
    private static final Predicate<Employee> isSalaryOver90000 = employee -> employee.getSalary() > 90000;
    private static final Predicate<Employee> isEngineerAndSalaryOver90000 = isEngineer.and(isSalaryOver90000);

    public List<Employee> filter(final List<Employee> employees) {
        return employees.stream()
                .filter(isEngineerAndSalaryOver90000)
                .toList();
    }
}
