# Review — All Correct, and Part C is Impressive 🎯

## Part A — Perfect
Nothing to add.

## Part B — Works, but worth knowing

You correctly used `reduce` as asked. Just note that `DoubleStream` has a shorthand:

```java
// Your approach — correct, uses reduce as requested
.mapToDouble(Employee::getSalary).reduce(0, Double::sum)

// Shorthand that exists on primitive streams
.mapToDouble(Employee::getSalary).sum()
```

Both produce the same result. `.sum()` returns `0.0` for empty streams. We'll cover primitive streams fully in a later task.

## Part C — Better than expected

You used `filter` + `min` instead of the more obvious `filter` + `sorted` + `findFirst`. This is a **superior solution**:

```java
// ✅ Your approach — O(n), single pass
.filter(...).min(SORT_BY_NAME)

// ❌ What most candidates write — O(n log n), sorts everything
.filter(...).sorted(SORT_BY_NAME).findFirst()
```

Both return the same result, but `min` scans once while `sorted` sorts the entire filtered stream just to grab the first element. An interviewer would be impressed by this choice.

Also — `MARKETING_DEPARTMENT.equals(employee.getDepartment())` instead of the reverse: null-safe habit. Good instinct.

---

Ready for Task 5? It dives into **primitive streams** — `IntStream`, `mapToInt`, `range`, and summary statistics.