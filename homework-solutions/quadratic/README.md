### Solution _(in progress)_
IPJ 1.2.8

### Notes

1. We are using this simple project to introduce unit tests and the `JUnit` library. See the separate section on [unit testing](#unit-testing).
2. Note that to use `JUnit` effectively, we cannot have most code in the `main()` function in REPL style. We need non-`static` variables (aka _members_) and methods.
3. Note that the general quadratic equation ![image](https://user-images.githubusercontent.com/6043344/31571148-a14c66e0-b04a-11e7-87f7-ed3f333392f5.png) has _two complex roots_. We are using IPJ's `Complex.java` ([Section 3.2](http://introcs.cs.princeton.edu/java/32class/)) to provide the general functionality for complex numbers.
4. Note that we disallow the coefficient of the quadratic term to be zero, both in `main()` and the constructor.

### Unit testing

TODO