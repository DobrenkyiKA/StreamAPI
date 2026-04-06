# Review — All Correct ✅

Strong solutions. A few details worth banking:

## Part A — `peek` golden rule

Your usage is correct. In interviews, always state: *"`peek` is for debugging/logging only — never for business logic or mutations."*

```java
// ❌ Bad — mutating inside peek
.peek(e -> e.setSalary(e.getSalary() * 1.1))

// ✅ Good — observing only
.peek(e -> System.out.println(e.getName()))
```

The Javadoc literally says *"exists mainly to support debugging"*. Some streams implementations may skip `peek` entirely as an optimization.

## Part C — Robustness alternative

Your space filter works for the given input. For unknown input with digits, punctuation, etc., `Character::isLetter` is safer:

```java
.filter(Character::isLetter)   // handles all non-letter characters
```

Also, `ch -> ch` as the classifier works perfectly. `Function.identity()` is the conventional alternative, but with `Character` it requires a cast, so your version is actually cleaner.

## Part D — Nice type witness

`Stream.<Employee>empty()` — most candidates forget the type witness and get a compilation error. Well done.

One edge case: if `department` is also `null`, your filter throws `NullPointerException` since you call `department.equals(...)`. Defensive option:

```java
.filter(e -> Objects.equals(department, e.getDepartment()))
```

Or validate department at method entry with a guard clause.

---

Ready for Task 13? It dives deep into **`Optional` handling in streams** — `Optional.stream()`, `flatMap` with Optionals, and the patterns that separate clean code from messy null-checking.