# Review — All Four Correct ✅

*(Tiny thing: missing semicolon in Part A — assuming typo.)*

## Part B — Defensive thinking for interviews

Your code works perfectly with the given data. But if an interviewer asks *"what if two employees have the same name?"*:

```java
// 💥 Throws IllegalStateException with duplicate names
Collectors.toMap(Employee::getName, Employee::getSalary)

// ✅ Defensive — decide on collision strategy
Collectors.toMap(Employee::getName, Employee::getSalary, (existing, replacement) -> existing)
```

In a real interview, calling this out **before being asked** earns points. Even just saying *"I'm assuming names are unique here — if not, I'd add a merge function"* shows production mindset.

## `toMap` four-argument form

Just like `groupingBy`, you can control the map type:

```java
Collectors.toMap(
    Employee::getName,
    Employee::getSalary,
    Math::max,
    LinkedHashMap::new    // preserves insertion order
)
```

## Summary of `toMap` overloads

| Arguments | Duplicate keys? | Map type |
|---|---|---|
| `(key, value)` | ❌ throws | HashMap |
| `(key, value, merge)` | ✅ resolved | HashMap |
| `(key, value, merge, supplier)` | ✅ resolved | You choose |

---

Ready for Task 9? It covers **`reduce` in depth**, `collectingAndThen`, and `teeing`  — powerful but lesser-known collectors that impress interviewers.