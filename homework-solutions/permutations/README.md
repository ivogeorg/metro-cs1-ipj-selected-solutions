### Solution

IPJ 2.3.17

### Solution

1. The recursive solution consists of a growing _prefix_ and a shrinking _suffix_.
2. If the _suffix_ is non-empty, the call generates recursive calls with the current _prefix_ with one of the characters of the _suffix_ added, and the remaining _suffix_.
3. At the leaves the _prefix_ is a full permutation and the _suffix_ is empty.

#### TODO
  * avoid `String`
  * more elegant and efficient calculation of `tail` for the recursive call