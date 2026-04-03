# Task 6 — Flattening with `flatMap`

## Knowledge

**The problem:** When you have nested collections (a list of departments, each containing a list of employees), `map` gives you a **stream of streams** — not what you want:

```java
// map → Stream<List<Employee>> — nested, unusable
departments.stream().map(Department::getEmployees)

// flatMap → Stream<Employee> — flattened, perfect
departments.stream().flatMap(d -> d.getEmployees().stream())
```

**`flatMap(Function<T, Stream<R>>)`** — Maps each element to a stream, then **flattens** all those streams into one. Think of it as "one-to-many" mapping:

- `map`: one element → one element
- `flatMap`: one element → zero or many elements

The function you pass **must return a `Stream`**, not a collection.

## New Domain Model

```java
public class Department {
    private String name;
    private List<Employee> employees;

    public Department(String name, List<Employee> employees) {
        this.name = name;
        this.employees = employees;
    }
    // getters
}
```

## Task

**Part A:** Given a list of departments, return a **flat `List<Employee>`** of all employees across all departments.

```java
List<Department> departments = List.of(
    new Department("Engineering", List.of(
        new Employee("Alice", "Engineering", 95000, 32),
        new Employee("Charlie", "Engineering", 110000, 40)
    )),
    new Department("Marketing", List.of(
        new Employee("Bob", "Marketing", 62000, 28),
        new Employee("Diana", "Marketing", 58000, 25)
    )),
    new Department("Sales", List.of())  // empty department!
);
```

**Part B:** Given a list of sentences, return a **sorted list of unique words** in lowercase.

```java
List<String> sentences = List.of(
    "Hello World",
    "World of Java",
    "Java Streams are great"
);
// Expected: [are, great, hello, java, of, streams, world]
```

*Hint for Part B: `String.split(" ")` returns `String[]` — you'll need `Arrays.stream()` to turn it into a stream.*

---

Send both when ready.