### Guidance
IPJ 2.2.12

### Notes

1. Represent matrices as two-dimensional arrays. Java uses _row-major_ traversal, so the first index will index the rows, and the second will index the columns.
2. Remember that to multiply two matrices M and N, their inner dimensions should match. That is, if M is x-by-y (x rows and y columns) and N is a-by-b, then multiplication is only defined _if and only iff_ y is equal to a.
3. Note that functions returning multidimensional arrays should create new arrays before populating them and returning them.
4. Note that in the product of two matrices L = M x N:
  * As mentioned, the number of columns of M has to be equal to the number of rows of N.
  * L has the same number of rows as M and the same number of columns as N.
  * You can compute this easily with nested loops and the property ![image](https://user-images.githubusercontent.com/6043344/31571482-c587995c-b050-11e7-86fe-e8b3db82d81a.png).
  * The multiplication of a matrix and a vector and a vector and a matrix are special cases of the general case.
  * Remember, matrix multiplication is *not commutative*, that is M x N is not equal to N x M (which might be undefined even if M x N is.

