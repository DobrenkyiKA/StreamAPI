# Review — All Three Perfect ✅

Textbook solutions. A few interview points worth memorizing:

## `groupingBy` default map type

`groupingBy` returns a `HashMap` — **no ordering guarantee**. If an interviewer asks for departments in insertion order or sorted order, use the three-argument overload:

```java
// Preserves encounter order
Collectors.groupingBy(
    Employee::getDepartment,
    LinkedHashMap::new,          // map factory (second argument)
    Collectors.counting()
)
```

## `partitioningBy` vs `groupingBy` with boolean

An interviewer might ask: *"Why not just do `groupingBy(e -> e.getSalary() >= 80000)`?"*

The key difference: `partitioningBy` **always** returns both keys:

```java
// partitioningBy with NO employees matching:
{true=[], false=[...all employees...]}   // both keys present

// groupingBy with boolean — if nobody matches:
{false=[...all employees...]}            // true key is MISSING
```

This matters when downstream code does `map.get(true)` — with `groupingBy` it returns `null`, with `partitioningBy` it returns an empty list. Fewer `NullPointerException` surprises.

---

Ready for Task 8? It goes deeper into **advanced collectors** — `toMap`, `joining`, `mapping`, and the merge function trap that catches almost everyone.