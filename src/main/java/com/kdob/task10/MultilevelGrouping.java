package com.kdob.task10;

import com.kdob.common.Employee;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class MultilevelGrouping {

    private static final Predicate<Employee> RICHEST_EMPLOYEE_PREDICATE = employee -> employee.getSalary() >= 80_000;
    private static final Collector<Employee, ?, List<Employee>> GET_RICHEST_EMPLOYEE = Collectors.filtering(RICHEST_EMPLOYEE_PREDICATE, Collectors.toList());
    public Map<String, List<Employee>> getRichestByDepartment(final List<Employee> employees) {
        return employees.stream()
                .collect(groupingBy(Employee::getDepartment, GET_RICHEST_EMPLOYEE));
    }

    private static final Collector<Employee, ?, Set<String>> GET_SKILLS_SET = Collectors.flatMapping(employee -> employee.getSkills().stream(), Collectors.toSet());
    public Map<String, Set<String>> getSkillsByDepartment(final List<Employee> employees) {
        return employees.stream()
                .collect(groupingBy(Employee::getDepartment, GET_SKILLS_SET));
    }

    private static final Function<Employee, String> AGE_RANGE_FUNCTION = employee -> (employee.getAge()/10 * 10) + "-" + (employee.getAge()/10 * 10 + 9);
    public Map<String, Map<String, List<Employee>>> getEmployeesByAgeByDepartment(final List<Employee> employees) {
        return employees.stream()
                .collect(
                        groupingBy(Employee::getDepartment,
                                groupingBy(AGE_RANGE_FUNCTION)));
    }
}

