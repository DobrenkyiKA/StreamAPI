# Review — Both Correct ✅

## Style note on both parts

You consistently split `map` + `flatMap` into two steps. This works, but the idiomatic pattern combines them:

```java
// Your style — two steps (works fine)
.map(Department::getEmployees).flatMap(List::stream)

// Idiomatic style — single flatMap
.flatMap(d -> d.getEmployees().stream())
```

Neither is wrong. The single `flatMap` is what most Java codebases and interviewers expect to see. Worth being comfortable with both.

## Part A — Empty department handling

Note that `Sales` has an empty employee list. `flatMap` handles this gracefully — `List.of().stream()` produces an empty stream that simply contributes zero elements. No special handling needed. Interviewers sometimes ask *"what if a department has no employees?"* — your code already handles it.

## Part B — Your punctuation question (great instinct!)

You're right to worry. With punctuation, `"Java!"` and `"Java"` would be treated as different words. The fix — split on **non-word characters** instead of just spaces:

```java
// Instead of:
sentence.split(" ")

// Use regex:
sentence.split("\\W+")   // splits on any non-[a-zA-Z0-9_] sequence
```

This handles commas, periods, exclamation marks, multiple spaces, etc. In an interview, mentioning this edge case unprompted shows thoroughness.

---

Ready for Task 7? It's a big one — **`groupingBy` and `partitioningBy`** — the most interview-heavy collectors.