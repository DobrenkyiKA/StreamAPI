# Review — All Correct ✅

Clean solutions across the board.

## Part C — `skip`/`limit` ordering trap

Your `skip(2).limit(3)` is correct. But interviewers love asking: *"What if you reverse them?"*

```java
// ✅ Your code — skip 2, then take 3 → employees ranked 3rd-5th
.skip(2).limit(3)    // [3rd, 4th, 5th]

// ❌ Reversed — take 3, then skip 2 of those → only 1 employee
.limit(3).skip(2)    // [3rd] — not what we want!
```

**Rule:** `skip` first, `limit` second for pagination-style queries. This maps directly to SQL's `OFFSET` / `LIMIT`.

## Part A — Minor alternative

Your `map(UUID::toString)` works perfectly. Slightly more compact alternative generating strings directly:

```java
Stream.generate(() -> UUID.randomUUID().toString())
```

Neither is better — just two styles.

## Part D — Complement pattern

Worth noting to an interviewer: `takeWhile` and `dropWhile` with the **same predicate** on a **sorted stream** cleanly partition the data. They're logical complements — one gets the "head", the other gets the "tail".

On an **unsorted stream** this guarantee breaks, so always mention the sorted precondition.

---

Ready for Task 12? It covers **`peek`**, **match operations** (`anyMatch`, `allMatch`, `noneMatch`), **`toArray`**, **`forEachOrdered`**, **`Stream.empty()`**, and **`String.chars()`** — filling the remaining gaps in core operations.