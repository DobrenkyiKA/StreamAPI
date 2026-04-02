# Task 3 — Sorting, Deduplication, and Counting

## Knowledge

**`sorted()`** — Intermediate operation. With no arguments, sorts by natural order (`Comparable`). With a `Comparator`, sorts by custom logic:

```java
stream.sorted()                                    // natural order
stream.sorted(Comparator.comparing(Employee::getName))  // by field
```

**Comparator chaining** — Real-world sorting usually involves multiple fields:
```java
Comparator.comparing(Employee::getSalary).reversed()       // descending
          .thenComparing(Employee::getName)                 // tie-breaker
```

**`distinct()`** — Removes duplicates. Uses `equals()` and `hashCode()` under the hood — if these aren't overridden on your objects, you'll get identity comparison (a common bug).

**`count()`** — Terminal operation, returns `long` (not `int`!). Returns the number of elements in the stream.

## Task

Use this updated list with some duplicate salaries:

```java
List<Employee> employees = List.of(
    new Employee("Alice", "Engineering", 95000, 32),
    new Employee("Bob", "Marketing", 62000, 28),
    new Employee("Charlie", "Engineering", 110000, 40),
    new Employee("Diana", "Marketing", 62000, 25),
    new Employee("Eve", "Engineering", 95000, 35),
    new Employee("Frank", "Marketing", 80000, 30)
);
```

**Part A:** Return a `List<Employee>` sorted by salary **descending**. For equal salaries, sort by name **alphabetically**.

**Part B:** Return the **count** of distinct salary values across all employees. (Expected result: `4`)

---

Send both when ready.