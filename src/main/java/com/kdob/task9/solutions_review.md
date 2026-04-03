# Review — All Three Correct ✅

Solid work, especially the `Optional` handling inside the `teeing` merger.

## Nice touches

- `Comparator.comparingDouble` in Part A — avoids auto-boxing that `Comparator.comparing` would cause. Subtle optimization most candidates miss.
- Shared `BY_SALARY_COMPARATOR` constant in Part B — reuse across both collectors.
- `Optional.map(Employee::getName).orElseThrow()` in Part A — cleaner than `orElseThrow().getName()` because it chains functionally.

## Readability note

Part B's `teeing` fits on one line but gets dense. In production or an interview whiteboard, splitting helps:

```java
Collectors.teeing(
    Collectors.maxBy(BY_SALARY_COMPARATOR),
    Collectors.minBy(BY_SALARY_COMPARATOR),
    (max, min) -> max.map(Employee::getSalary).orElseThrow()
                - min.map(Employee::getSalary).orElseThrow()
)
```

## `Collectors.reducing` — alternative for Part C

`summingDouble` is perfect here, but know that `Collectors.reducing` can do the same as a more general-purpose tool:

```java
// Your approach — purpose-built, cleaner
Collectors.summingDouble(Employee::getSalary)

// Equivalent using reducing
Collectors.reducing(0.0, Employee::getSalary, Double::sum)
```

`reducing` is the collector counterpart of `Stream.reduce()`. Use it when no specialized collector (`summingDouble`, `counting`, etc.) exists for your operation.

---

Ready for Task 10? It covers **downstream collector power moves** — `filtering`, `flatMapping`, and **multi-level `groupingBy`** — the kind of complex pipelines that separate mid from senior in interviews.