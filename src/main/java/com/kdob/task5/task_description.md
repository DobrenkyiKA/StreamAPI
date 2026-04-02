# Task 5 — Primitive Streams

## Knowledge

**Why primitive streams?** `Stream<Integer>` boxes every value into an object. For numeric work, this wastes memory and CPU. Java provides three specialized streams:
- `IntStream` — for `int`
- `LongStream` — for `long`
- `DoubleStream` — for `double`

**Creating primitive streams:**
```java
IntStream.range(1, 5)          // 1, 2, 3, 4 (exclusive end)
IntStream.rangeClosed(1, 5)    // 1, 2, 3, 4, 5 (inclusive end)
```

**Converting to primitive streams from object streams:**
```java
employees.stream().mapToInt(Employee::getAge)       // Stream<Employee> → IntStream
employees.stream().mapToDouble(Employee::getSalary)  // Stream<Employee> → DoubleStream
```

**Primitive stream terminal operations:**
```java
intStream.sum()                  // int — returns 0 for empty
intStream.average()              // OptionalDouble — empty for empty stream
intStream.summaryStatistics()    // IntSummaryStatistics: min, max, avg, count, sum
```

**`boxed()`** — Converts primitive stream back to object stream:
```java
IntStream.of(1, 2, 3).boxed()   // IntStream → Stream<Integer>
```
This is needed when you want to `collect` into a `List<Integer>`, since primitive streams don't have `collect(Collectors.toList())`.

## Task

**Part A:** Compute the **sum of integers from 1 to 100** using `IntStream.rangeClosed`. Return `int`.

**Part B:** From the employee list, get **`DoubleSummaryStatistics` for salaries**. Use it to print the min, max, and average salary.

**Part C:** Generate a `List<Integer>` containing **all even numbers from 1 to 20** (inclusive). Use `IntStream`, filtering, and `boxed()`.

---

Send all three when ready.