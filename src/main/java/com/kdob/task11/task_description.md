# Task 10 — Downstream Power Moves: `filtering`, `flatMapping`, Multi-level Grouping

## Knowledge

**`Collectors.filtering(predicate, downstream)`** *(Java 9+)* — Filters elements *within each group* during collection. **Critical difference** from `stream.filter()`:

```java
// ❌ stream filter — departments with no matches DISAPPEAR from the map
employees.stream()
    .filter(e -> e.getSalary() >= 80000)
    .collect(groupingBy(Employee::getDepartment));
// {Engineering=[Alice, Charlie]} — Marketing and Sales GONE

// ✅ downstream filtering — ALL department keys preserved
employees.stream().collect(
    groupingBy(Employee::getDepartment,
        filtering(e -> e.getSalary() >= 80000, toList())));
// {Engineering=[Alice, Charlie], Marketing=[], Sales=[]}
```

This distinction is a **favorite interview trap**.

**`Collectors.flatMapping(mapper, downstream)`** *(Java 9+)* — Like `flatMap` but as a downstream collector. Flattens nested collections within each group:

```java
groupingBy(Employee::getDepartment,
    flatMapping(e -> e.getSkills().stream(), toSet()))
```

**Multi-level `groupingBy`** — Nest `groupingBy` as a downstream collector:
```java
groupingBy(Employee::getDepartment,          // outer key
    groupingBy(Employee::getSeniorityLevel)) // inner key
// → Map<String, Map<String, List<Employee>>>
```

## Updated Employee Model

```java
public class Employee {
    private String name;
    private String department;
    private double salary;
    private int age;
    private List<String> skills;
    // constructor with all fields, getters
}
```

## Task

```java
List<Employee> employees = List.of(
    new Employee("Alice", "Engineering", 95000, 32, List.of("Java", "Python", "AWS")),
    new Employee("Bob", "Marketing", 62000, 28, List.of("SEO", "Content", "Analytics")),
    new Employee("Charlie", "Engineering", 110000, 40, List.of("Java", "Kubernetes", "AWS")),
    new Employee("Diana", "Marketing", 58000, 25, List.of("SEO", "Social Media")),
    new Employee("Eve", "Engineering", 88000, 35, List.of("Python", "Docker", "AWS")),
    new Employee("Frank", "Sales", 72000, 30, List.of("CRM", "Negotiation"))
);
```

**Part A:** Group by department, but within each group **only include employees earning ≥ 80,000**. All department keys must be present, even if their list is empty. Return `Map<String, List<Employee>>`.

**Part B:** Group by department and collect all **unique skills** per department. Return `Map<String, Set<String>>`.

**Part C:** Create a **two-level grouping**: first by department, then by age bracket. Age brackets should be strings: `"20-29"`, `"30-39"`, `"40-49"`. Return `Map<String, Map<String, List<Employee>>>`.

---

Send all three when ready.