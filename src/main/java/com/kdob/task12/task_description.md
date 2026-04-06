# Task 12 — `peek`, Match Operations, `toArray`, `Stream.empty()`, `String.chars()`

## Knowledge

**`peek(Consumer<T>)`** — Intermediate operation that performs an action on each element **without modifying the stream**. Primarily used for debugging:

```java
stream.filter(...)
      .peek(e -> System.out.println("After filter: " + e))
      .map(...)
      .collect(toList());
```

⚠️ **Trap:** `peek` is **lazy** — it only fires when a terminal operation pulls elements. And with short-circuiting terminals (`findFirst`, `anyMatch`), peek may **not execute for all elements**.

**Match operations** — Short-circuiting terminals returning `boolean`:
```java
anyMatch(predicate)    // true if ANY element matches (stops at first true)
allMatch(predicate)    // true if ALL elements match (stops at first false)
noneMatch(predicate)   // true if NO element matches (stops at first true)
```
On an **empty stream**: `anyMatch` → `false`, `allMatch` → `true`, `noneMatch` → `true`. This trips people up in interviews.

**`toArray()`** — Terminal operation producing an array:
```java
stream.toArray()                    // returns Object[]
stream.toArray(Employee[]::new)     // returns Employee[] — preferred
```

**`Stream.empty()`** — Returns a stream with zero elements. Useful for null-safe returns and conditional `flatMap`:
```java
return input == null ? Stream.empty() : input.stream();
```

**`String.chars()`** — Returns an `IntStream` of character code points:
```java
"hello".chars()   // IntStream: 104, 101, 108, 108, 111
```
You'll often need `mapToObj(c -> (char) c)` to work with `Character` objects.

**`forEachOrdered(Consumer)`** — Like `forEach`, but **guarantees encounter order**. Identical to `forEach` on sequential streams, but critical for parallel streams (covered in Task 14).

## Task

**Part A:** Given the employee list, build a pipeline that:
1. Filters engineers
2. Uses `peek` to print each engineer's name to console
3. Extracts their salaries
4. Collects to a `List<Double>`

**Part B:** Using the employee list, answer these three questions with one-liner methods:
- Is **any** employee earning more than 100,000?
- Are **all** employees older than 21?
- Is there **no** employee in the `"HR"` department?

**Part C:** Given the string `"java streams"`, return a `Map<Character, Long>` of character frequencies, **excluding spaces**.
*(Expected: {j=1, a=3, v=1, s=2, t=1, r=1, e=1, m=1})*

**Part D:** Write a method that takes a **nullable** `List<Employee>` and a department name, and returns an `Employee[]` of employees in that department. If the list is `null`, use `Stream.empty()`.

---

Send all four when ready.