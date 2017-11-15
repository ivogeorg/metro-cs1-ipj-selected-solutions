### Solution

IPJ 3.2.30

### Notes

1. Clone (or fork-n-clone) the repository to your local environment.
2. Create a project in IntelliJ "From existing sources".
3. Create a Run configuration, specifying `PeriodicTable` as the main class, the project directory as the working directory, and the name of one of the csv files as the single argument.
4. The reads in the file and prints out the elements it managed to read.
5. Notes on reading in the file:
    * Read line-by-line in a `while` loop with the `Scanner::nextLine()`.
    * Initialize a separate `Scanner` with the read-in line `String` and _comma_ delimiter (`"\\s*,\\s*"`) where `"\\s*"` means any number of whitespace characters. There are no spaces, so you can use `","` as the delimiter.
    * Create an element with default data and add it to the table (uses `ArrayList<ChemicalElement>`).
    * In order of appearance, read in, parse if necessary, and set the element data.
6. The `else continue;` statement means stop executing this iteration and _continue_ to the next (in this case, read in the next line).
7. Note that the data is so regular, that the `else continue;` statements are not necessary, since the `elementData.hasNex()` takes care of the missing values (including the _"missing"_ value after the last comma). **UPDATE:** There are missing intermediate values, but still only in the last 5 values. The code has been updated to handle that. Missing values appear in the file as `,,`. Use `elements-fixed.csv` as `Boron` had a missing value that was also missing a comma.
8. If an exception is thrown, the added element is removed from the table as it might be malformed.
9. Note that `ChemicalElement` needs a _default constructor_ and _variable setters_ for this read-in algorithm to work.
10. `read` has been updated to handle a header row.
11. `molecularWeight` has been implemented with Java [regular expressions](http://www.vogella.com/tutorials/JavaRegularExpressions/article.html) for code cleanliness and readability. Note that only simple chemical formulae of the form `symbol-optional digit-symbol-optional digit-...` are handled. The [general case](https://www.periodni.com/solcalc-chemical_compounds.html) requires more complex regular expressions.
