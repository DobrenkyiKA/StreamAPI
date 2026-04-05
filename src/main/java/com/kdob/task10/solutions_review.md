# Review — All Three Perfect ✅

Consistently clean, production-quality code. Your habit of extracting collectors and functions as named constants makes complex pipelines genuinely readable — especially in Part C where inline nesting would become hard to parse.

## Part C — Age bracket formula

Your integer division trick is elegant:

```java
(age / 10 * 10) + "-" + (age / 10 * 10 + 9)
// age 32 → 30-39 ✓
// age 28 → 20-29 ✓
// age 40 → 40-49 ✓
```

An interviewer might follow up: *"What if age is 8?"* → produces `"0-9"`. Just worth knowing your edge cases.

## Coverage check

You've now mastered the major collectors. Here's what's left:

- ✅ `groupingBy`, `partitioningBy`, `toMap`, `joining`, `filtering`, `flatMapping`, `teeing`, `collectingAndThen`, `mapping`, `reducing`, `summingDouble`, `counting`
- 🔲 Infinite streams, `limit`, `skip`, `takeWhile`, `dropWhile`
- 🔲 Match operations, `peek`, `toArray`
- 🔲 `Optional` handling in depth
- 🔲 Parallel streams
- 🔲 Advanced concepts and traps

---

Ready for Task 11? It covers **infinite streams** (`generate`, `iterate`) and **slicing operations** (`limit`, `skip`, `takeWhile`, `dropWhile`) — powerful tools with subtle traps.