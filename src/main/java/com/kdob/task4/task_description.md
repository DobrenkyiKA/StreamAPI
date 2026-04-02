# Task 4 — reduce, min, max, and findFirst

## Knowledge

**`min(Comparator)` / `max(Comparator)`** — Terminal operations that return `Optional<T>` (because the stream could be empty):

```java
stream.max(Comparator.comparing(Employee::getSalary))  // Optional<Employee>
```

**`findFirst()`** — Returns `Optional<T>` with the first element in encounter order. Often combined with `filter` + `sorted`.

**`findAny()`** — Similar, but doesn't guarantee which element. Exists for parallel stream performance — we'll revisit this later.

**`reduce(identity, BinaryOperator)`** — Combines all elements into a single result by repeatedly applying an operation:

```java
// Summing integers: start at 0, keep adding
Stream.of(1, 2, 3).reduce(0, Integer::sum)  // 6
```

The **identity** is the starting value (and also the return value for an empty stream). Without identity, `reduce(BinaryOperator)` returns `Optional<T>`.

**`Optional<T>` basics** — Since these operations might find nothing:
```java
optional.orElse(defaultValue)        // return default if empty
optional.orElseThrow()               // throw NoSuchElementException if empty
```

## Task

Same employee list from Task 3.

**Part A:** Find the **employee with the highest salary**. Return `Optional<Employee>`.

**Part B:** Calculate the **total salary** of all employees using `reduce`. Return `double`.

**Part C:** Find the **first employee alphabetically by name** who works in Marketing. Return `Optional<Employee>`. *(Expected: Diana)*

---

Send all three when ready.