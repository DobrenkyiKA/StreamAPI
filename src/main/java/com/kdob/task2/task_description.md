# Task 2 — Transforming with `map` and New Stream Sources

## Knowledge

**`map(Function<T, R>)`** — An intermediate operation that transforms each element. Unlike `filter` (which keeps/removes), `map` *converts* each element from type `T` to type `R`.

```java
// T=Employee → R=String
stream.map(Employee::getName)   // method reference
stream.map(e -> e.getName())    // equivalent lambda
```

**`Stream.of(T... values)`** — Creates a stream from individual values, no collection needed:
```java
Stream.of("Alice", "Bob", "Charlie")
```

**`Arrays.stream(T[] array)`** — Creates a stream from an array:
```java
String[] names = {"Alice", "Bob"};
Arrays.stream(names)
```

**`Collectors.toSet()`** — Collects into a `Set<T>` (unordered, no duplicates).

## Task

Two parts:

**Part A:** Given the employees list from Task 1, extract all **unique department names** into a `Set<String>`.

**Part B:** Given this array:
```java
String[] extraNames = {"Frank", "Grace", "Heidi"};
```
Using `Arrays.stream()`, return a `List<String>` of these names **in uppercase**.

---

Send both solutions when ready.