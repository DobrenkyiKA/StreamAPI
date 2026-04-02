# Review — Excellent Solution 🎯

This is beyond what I expected for Task 1. A few things worth highlighting:

## What you did well
- **Named predicates** with `Predicate.and()` composition — clean, reusable, testable. This is production-grade thinking.
- **Constant extraction** for the department string — small thing, but interviewers notice it.

## One interview-critical detail

You used `.toList()` instead of `.collect(Collectors.toList())`. Both work, but they're **not identical**:

```java
// Java 16+ — returns an UNMODIFIABLE list (like List.of())
employees.stream().filter(...).toList();

// Returns a MUTABLE ArrayList
employees.stream().filter(...).collect(Collectors.toList());

// Explicitly unmodifiable (Java 10+)
employees.stream().filter(...).collect(Collectors.toUnmodifiableList());
```

If an interviewer asks *"can I add elements to the result?"* — your answer depends on which one you used. `.toList()` will throw `UnsupportedOperationException`. This has come up in real interviews.

**Your choice of `.toList()` is the modern, correct default** — immutability is preferred unless mutation is specifically needed.

---

Ready for Task 2? It will build on this with `map` and a new stream creation method.