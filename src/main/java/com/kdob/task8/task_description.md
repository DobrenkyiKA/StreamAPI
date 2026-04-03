# Task 7 — Grouping and Partitioning

## Knowledge

**`Collectors.groupingBy(classifier)`** — Groups elements by a key into a `Map<K, List<T>>`:

```java
// Map<String, List<Employee>>
employees.stream().collect(Collectors.groupingBy(Employee::getDepartment));
```

**`Collectors.groupingBy(classifier, downstream)`** — Groups by key, then applies a **downstream collector** to each group instead of collecting to a list:

```java
// Map<String, Long> — count per group
Collectors.groupingBy(Employee::getDepartment, Collectors.counting())
```

Common downstream collectors: `counting()`, `mapping()`, `maxBy()`, `minBy()`, `summingDouble()`, `toSet()`, etc.

**`Collectors.partitioningBy(predicate)`** — Special case of grouping that splits into **exactly two groups**: `true` and `false`. Returns `Map<Boolean, List<T>>`.

```java
// Key difference from groupingBy:
// - partitioningBy ALWAYS has both keys (true/false), even if one list is empty
// - groupingBy only has keys that exist in the data
```

## Task

Use this employee list:

```java
List<Employee> employees = List.of(
    new Employee("Alice", "Engineering", 95000, 32),
    new Employee("Bob", "Marketing", 62000, 28),
    new Employee("Charlie", "Engineering", 110000, 40),
    new Employee("Diana", "Marketing", 58000, 25),
    new Employee("Eve", "Engineering", 88000, 35),
    new Employee("Frank", "Sales", 72000, 30)
);
```

**Part A:** Group employees by department. Return `Map<String, List<Employee>>`.

**Part B:** Group employees by department, but return the **number of employees** in each department. Return `Map<String, Long>`.

**Part C:** Partition employees into two groups: those earning **≥ 80,000** and those earning less. Return `Map<Boolean, List<Employee>>`.

---

Send all three when ready.