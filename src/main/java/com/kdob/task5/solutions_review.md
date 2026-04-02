# Review — All Three Perfect ✅

Clean, correct solutions across the board.

## Noteworthy details

**Part B — Empty stream gotcha:** If the employee list is empty, `summaryStatistics()` doesn't throw. Instead it returns deceptive defaults:

```java
getMin()     → Double.MAX_VALUE   // not 0!
getMax()     → Double.MIN_VALUE   // not 0!
getAverage() → 0.0
getCount()   → 0
```

An interviewer might ask: *"What happens with an empty list?"* — this surprises most people.

Also, `summaryStatistics()` is ideal when you need **multiple stats** (one pass). If you only need the average, prefer `.average()` which returns `OptionalDouble` — properly signaling emptiness.

**Part C — `IntPredicate` usage:** You correctly used `IntPredicate` instead of `Predicate<Integer>`. This is the primitive specialization — avoids autoboxing. Most candidates miss this distinction. The same pattern exists for `IntFunction`, `IntConsumer`, `IntUnaryOperator`, etc.

**Why `boxed()` is necessary:** `IntStream` has no `.collect(Collectors.toList())` or `.toList()` that returns `List<Integer>`. You must go through `boxed()` first to get back to `Stream<Integer>`. Alternative is `.toArray()` which returns `int[]`.

---

Ready for Task 6? It tackles **`flatMap`** — flattening nested structures. This is one of the most frequently tested stream operations in interviews.