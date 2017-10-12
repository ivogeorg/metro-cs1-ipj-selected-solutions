### Guidance _(in progress)_
IPJ 2.2.2
### Notes

1. This one should be a good warmup, so let's do a good job, too. In particular:
  * Keep your code properly indented at all times. To reindent a file in IntelliJ IDEA, select all the code and click **Code | Reformat code**.
  * Adopt a consistent [style for curly braces](https://jeremybytes.blogspot.com/2013/04/where-do-curly-braces-belong.html) and **stick to it**.
  * Pick _descriptive variable names_. E.g. `doublesArray` for an array of double values is okay, `arr` is **not**; `r` for radius is okay, `var5` is **not**.
  * Space out the operators of your assignment, arithmetic, and comparison expressions. E.g. `r <= 0.1` is preferred to `r<=0.1`; `int i = 0;` is preferred to `int i=0;`.
  * Call your class `Hyperbolic`.
2. You are asked to create a mini-library like the Java `Math` for [hyperbolic functions](https://en.wikipedia.org/wiki/Hyperbolic_function). They are the hyperbolic equivalents of the standard trigonometric functions, and are _continous_ and _differentiable_. Make sure your library methods work with `double` parameters/arguments and return values only. See the separate sectionon the distinction between [parameters and arguments](#parameters-and-arguments).
3. You are asked to implement 6 methods: `sinh(x)`, `cosh(x)`, `tanh(x)`, `coth(x)`, `sech(x)`, and `csch(x)`. Note that the last four are defined in terms of the first two. Follow this definition in your implementation for consistency.
4. Just like the `Math` class methods, the `Hyperbolic` methods should be `public static`. See the separate section on [`static`](#static-vs-non-static).
5. Just like the `Math` class, `Hyperbolic` should throw [`ArithmeticException`](https://docs.oracle.com/javase/8/docs/api/java/lang/ArithmeticException.html) whenever a forbidden or undefined operations is attempted. Java exceptions are required in the CS 1050 curriculum so we'll use this opportunity to introduce them gently. See the separate section on [Exceptions](#exceptions) below. You will need to handle:
  * Attempts to divide by zero (since some of the functions are defined as ratios).
  * Attempts to operate on values outside of the defined ranges of the functions.
6. Note that like the trigonometric functions in `Math`, the methods of `Hyperbolic` should work in [_radians_](https://en.wikipedia.org/wiki/Radian).

### Parameters and arguments

In the function definition below
```java
int add(int a, int b) {
  return a + b;
}
```
`a` and `b` are called _parameters_. However, in the following call to `add()`
```java
int x = 9, y = 81;
int z = add(x, y);
```
`x` and `y` are called _arguments_.

### `static` vs non-`static`

`static` variables and methods _belong to the class_. They are always called on the class name itself, as in `Math.cos(x)`, unless they are called from inside other `static` methods belonging to the same class. They cannot be called on an object, and they cannot call non-`static` class methods (aka object methods) in _any_ class.

Despite the introduction by IPJ of `static` methods first (part of the _objects-in-the-middle_ approach to teaching Java), non-`static` methods are far more prevalent. The belong to objects, which are _instantiations_ of a class created with the `new` operator. In the following code snippet
```java
Dog jake = new Dog("greyhound", 5, 40); // assume arguments are breed name, age, and weight in lbs

jake.run();
jake.bark();
```
we can be absolutely sure that the methods `public void run()` and `public void bark()` were declared non-`static`, as they are called on a particular object of `class Dog`.

### Exceptions

Exceptions are a Java mechanism for averting _undefined_ or _forbidden_ operations, like _division by zero_. Since division by zero is not defined in mathemarical theory, the program cannot produce _correct_ output to an expression which results in division by zero. There *isn't* any correct output. However, the program cannot just skip this statement and continue. If such an expression was generated, maybe there is something wrong with the way the library client is trying to use it. This is important _feedback_ to the client, but requires the special machinery of exceptions.

An exception is _"thrown"_ by an expression, usually the one that checks for the _anomalous_ condition (e.g. division by zero) to serve as a _signal_ to the calling code that something went wrong. The syntax is as follows
```java
if (divizor == 0.0) throw new ArithmeticException("error: division by zero attempted");
```
or
```java
if (divizor == 0.0) {
  // do some cleanup before throwing, to leave the program in a consistent state
  throw new ArithmeticException("error: division by zero attempted");
}
```
Notice:
  * The statements after the `throw` line are not executed, and control can jump very far, often unwinding a significant portion of the _call stack_.
  * The throwing code can pass an optional message, which can be printed out to [`System.err`](https://docs.oracle.com/javase/8/docs/api/java/lang/System.html#err) as an error message or logged.
  * Exceptions are objects of exception classes and so they need to be created with the `new` opeartor at the time of throwing.

Exceptions are _"caught"_ by a special code block that is expecting them to be thrown. The syntaxt looks as follows
```java
try {
  // some code that might throw exceptions
} catch (ArithmeticException ex) {
  // do something with the ex object, perhaps log the message
  System.err.println(ex.getMessage());
}
```
Notice:
  * Only statements inside the `try {} catch` code block with be caught.
  * We can catch excpeptions of _specific_ classes.
  * The full syntax adds more flexibility and use cases (see this [reference](https://en.wikibooks.org/wiki/Java_Programming/Throwing_and_Catching_Exceptions)) but this is fine for a start. 
