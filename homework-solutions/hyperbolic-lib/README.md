### Guidance
IPJ 2.2.2
### Notes

1. This one should be a good warmup, so let's do a good job, too. In particular:
  * Keep your code properly indented at all times. To reindent a file in IntelliJ IDEA, select all the code and click **Code | Reformat code**.
  * Adopt a consistent [style for curly braces](https://jeremybytes.blogspot.com/2013/04/where-do-curly-braces-belong.html) and **stick to it**.
  * Pick _descriptive variable names_. E.g. `doublesArray` for an array of double values is okay, `arr` is **not**; `r` for radius is okay, `var5` is **not**.
  * Space out the operators of your assignment, arithmetic, and comparison expressions. E.g. `r <= 0.1` is preferred to `r<=0.1`; `int i = 0;` is preferred to `int i=0;`.
  * Call your class `Hyperbolic`.
2. You are asked to create a mini-library like the Java `Math` for [hyperbolic functions](https://en.wikipedia.org/wiki/Hyperbolic_function). They are the hyperbolic equivalents of the standard trigonometric functions, and are _continous_ and _differentiable_. Make sure your library methods work with `double` values only.
3. You are asked to implement 6 methods: `sinh(x)`, `cosh(x)`, `tanh(x)`, `coth(x)`, `sech(x)`, and `csch(x)`. Note that the last four are defined in terms of the first two. Follow this definition in your implementation for consistency.
4. Just like the `Math` class, `Hyperbolic` should throw `ArithmeticException` whenever a forbidden or undefined operations is attempted. Java exceptions are required in the CS 1050 curriculum so we'll use this opportunity to introduce them gently. See the separate section on [Exceptions](#Exceptions) below.

### Exceptions
