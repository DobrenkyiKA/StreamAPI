# Review — Clean and Correct ✅

Both solutions are spot-on. Nothing to fix.

## Quick notes worth banking for interviews

**Part A** — An interviewer might follow up: *"What if I need unique departments but in a specific order?"* `toSet()` returns a `HashSet` (no ordering guarantee). You'd then use:

```java
// LinkedHashSet preserves insertion order
.collect(Collectors.toCollection(LinkedHashSet::new));
```

**Part B** — `Arrays.stream(extraNames)` is the right choice for arrays. Note that `Stream.of(extraNames)` would also work identically here — for a `String[]`, both produce `Stream<String>`. But beware with primitive arrays:

```java
int[] nums = {1, 2, 3};
Stream.of(nums);          // Stream<int[]> — ONE element! (the array itself)
Arrays.stream(nums);      // IntStream — THREE elements ✓
```

This is a **classic trap** in interviews.

---

Ready for Task 3? It introduces sorting, deduplication, and counting.