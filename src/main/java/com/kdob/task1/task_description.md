# Task 1 — Filtering a Collection

## Domain Model

You'll use this `Employee` class throughout many tasks. Define it first:

```java
public class Employee {
    private String name;
    private String department;
    private double salary;
    private int age;

    public Employee(String name, String department, double salary, int age) {
        this.name = name;
        this.department = department;
        this.salary = salary;
        this.age = age;
    }

    // getters, toString — assume they exist
}
```

## Knowledge

**`Collection.stream()`** — Every `Collection` (List, Set, etc.) has a `.stream()` method that returns a sequential `Stream<T>`. This is the most common way to create a stream.

**`filter(Predicate<T>)`** — An *intermediate operation* that keeps only elements matching the predicate. It takes a `Predicate<T>` (a function that returns `boolean`).

**`collect(Collector)`** — A *terminal operation* that transforms the stream into a concrete result. `Collectors.toList()` gathers elements into a `List<T>`.

**Key concept — Lazy evaluation:** Intermediate operations like `filter` do *nothing* by themselves. The pipeline only executes when a terminal operation (like `collect`) is called. This is the #1 concept interviewers test.

## Task

Given this list:

```java
List<Employee> employees = List.of(
    new Employee("Alice", "Engineering", 95000, 32),
    new Employee("Bob", "Marketing", 62000, 28),
    new Employee("Charlie", "Engineering", 110000, 40),
    new Employee("Diana", "Marketing", 58000, 25),
    new Employee("Eve", "Engineering", 88000, 35)
);
```

**Write a method** that returns a `List<Employee>` of all employees in the `"Engineering"` department with a salary greater than `90000`.

---

Take your time. Send me your solution when ready, or ask if something's unclear.