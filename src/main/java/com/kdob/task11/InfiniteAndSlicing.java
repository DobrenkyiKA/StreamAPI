package com.kdob.task11;

import com.kdob.common.Employee;

import java.util.Comparator;
import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

public class InfiniteAndSlicing {
    public List<String> getFiveRandomUUID() {
        return Stream.generate(UUID::randomUUID)
                .limit(5)
                .map(UUID::toString)
                .toList();
    }

    public List<Integer> getTenPowersOfTwo() {
        return Stream.iterate(1, n -> n * 2)
                .limit(10)
                .toList();
    }

    public List<Integer> getMultiplesOfFiveFromFiveToFifty() {
        return Stream.iterate(5, n -> n <= 50, n -> n + 5)
                .toList();
    }

    public List<Employee> getEmployeesFrom3rdTo5th(List<Employee> employees) {
        return employees.stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                .skip(2)
                .limit(3)
                .toList();
    }

    public List<Integer> getLess50(List<Integer> integers) {
        return integers.stream()
                .takeWhile(n -> n < 50)
                .toList();
    }

    public List<Integer> getMoreThan49(List<Integer> integers) {
        return integers.stream()
                .dropWhile(n -> n < 50)
                .toList();
    }


}
