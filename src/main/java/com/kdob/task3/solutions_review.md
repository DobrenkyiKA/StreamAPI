# Review — Both Correct ✅

Clean solutions, nothing to fix. Two interview-worthy details:

## Comparator `.reversed()` placement trap

Your chain is correct — but watch where `.reversed()` goes:

```java
// ✅ What you wrote — salary DESC, name ASC
Comparator.comparing(Employee::getSalary).reversed()
          .thenComparing(Employee::getName)

// ❌ Common mistake — reverses EVERYTHING (salary DESC, name DESC)
Comparator.comparing(Employee::getSalary)
          .thenComparing(Employee::getName)
          .reversed()
```

Interviewers love testing this. `.reversed()` reverses the **entire comparator built so far**, not just the last field.

`thenComparing` has an overloaded version that accepts a **comparator for that specific field**:

```java
// salary ASC, name DESC
Comparator.comparing(Employee::getSalary)
          .thenComparing(Employee::getName, Comparator.reverseOrder())
```

`Comparator.reverseOrder()` returns a comparator that sorts in reverse natural order — and it applies **only to the name field**.

You can mix and match freely this way:

```java
// salary DESC, name DESC
Comparator.comparing(Employee::getSalary, Comparator.reverseOrder())
          .thenComparing(Employee::getName, Comparator.reverseOrder())

// salary ASC, name ASC (default — no second argument needed)
Comparator.comparing(Employee::getSalary)
          .thenComparing(Employee::getName)
```

## Rule of thumb

| Need | Approach |
|---|---|
| Reverse **everything** built so far | `.reversed()` at the end |
| Reverse **one specific field** | Pass `Comparator.reverseOrder()` as second argument |

This is much safer than trying to reason about where to place `.reversed()` in a chain.

---

## `distinct()` reminder

Your Part B works perfectly because `map(Employee::getSalary)` produces `Double` objects (auto-boxed), and `Double` has proper `equals()`/`hashCode()`.

If you ever call `distinct()` on a stream of custom objects, make sure `equals()` and `hashCode()` are overridden. Otherwise it compares by **reference** and nothing gets deduplicated. This is a frequent real-world bug.

---

Ready for Task 4? It covers `reduce`, `min`, `max`, and `findFirst` — the core terminal operations interviewers always ask about.