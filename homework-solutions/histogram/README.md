### Solution
IPJ 1.5.30
### Notes

1. Note how we can reduce the complexity of a problem by breaking it down into independent parts/steps.
2. By thinking about breaking the problem up first, we clear our minds from the burden of details.
3. No we can tackle each part/step separately, assuming the others are, or will be in due time, solved.
4. Notice that the problem asks for doubles in the input stream, and how, by creating a local array that we can populate with random doubles between `lo` and `hi`, we get the same effect but don't have to deal with command line piping.
5. Note the use of _scaled_ and _offset_ `Math.random()` to get doubles between `lo` and `hi`.
6. Notice how we can create a constant `DOUBLE_COUNT` to set the number of doubles we want to generate. There are at least three places where we want to use this number so it's best to be a constant that we can change once, and not have to change hardcoded values in three different places. For a larger program, this is a life saver.
7. Notice how we encapsulate the double generation into a neat function `generator` to clean up our `main` code.
8. Note that `generator` and `DOUBLE_COUNT` are both `private`. This is because we only need to access them from _inside_ the class.
9. Notice how, by arriving at a formula for calculating the correct interval, our code works for any values of the arguments `n`, `lo`, and `hi`.
