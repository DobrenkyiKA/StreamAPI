package com.kdob.task5;

import com.kdob.common.Employee;

import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;

public class PrimitiveStreams {

    private static final IntPredicate IS_EVEN_PREDICATE = it -> it % 2 == 0;

    public List<Integer> getEvenNumbers() {
        return IntStream.rangeClosed(1, 20)
                .filter(IS_EVEN_PREDICATE)
                .boxed()
                .toList();
    }

    public int calcSum1to100() {
        return IntStream.rangeClosed(1, 100)
                .sum();
    }

    public void summaryStatistics(List<Employee> employees) {
        final DoubleSummaryStatistics doubleSummaryStatistics = employees.stream()
                .mapToDouble(Employee::getSalary)
                .summaryStatistics();

        System.out.println("Minimum salary: " + doubleSummaryStatistics.getMin());
        System.out.println("Maximum salary: " + doubleSummaryStatistics.getMax());
        System.out.println("Average salary: " + doubleSummaryStatistics.getAverage());
    }
}
