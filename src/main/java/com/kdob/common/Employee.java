package com.kdob.common;

import java.util.List;

public class Employee {
    private String name;
    private String department;
    private double salary;
    private int age;
    private List<String> skills;

    public Employee(String name, String department, double salary, int age) {
        this.name = name;
        this.department = department;
        this.salary = salary;
        this.age = age;
    }

    public Employee(final String name, final String department, final double salary, final int age, final List<String> skills) {
        this.name = name;
        this.department = department;
        this.salary = salary;
        this.age = age;
        this.skills = skills;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(final String department) {
        this.department = department;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(final double salary) {
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(final int age) {
        this.age = age;
    }

    public List<String> getSkills() {
        return skills;
    }

    public void setSkills(final List<String> skills) {
        this.skills = skills;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", salary=" + salary +
                ", age=" + age +
                ", skills=" + skills +
                '}';
    }
}
