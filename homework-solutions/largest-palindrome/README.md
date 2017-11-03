### Guidance

IPJ 2.3.34

### Notes

1. You are required to find the largest palindrome substring of a given input string.
2. Moreover, being in the section on recursion, you are to come up with a _recursive_ solution.
3. Finally, the hint suggests that you should look at the string and its reverse. This is natural, since we are looking for palindromes.
4. Here is a test case that can give us intuition for an approach:
    * Pick a word that contains an a palindrome, but is not itself one. I am in a Friday kind of mood, so the first word that came into my mind was _alcohol_.
    * _alcohol_ is not itself a palindrome, but contains a 3-letter one, namely, _oho_.
    * The palindrome is off-center in the containing string, which gives us a perfect used case.
    * If a string is a palindrome, it reads the same in forward and reverse. So we need to be able to reverse a string. Using the [`StringBuffer::reverse()`](https://docs.oracle.com/javase/8/docs/api/java/lang/StringBuffer.html#reverse--) method seems to be the most elegant way to do this in Java.
    * Next, we need to be able to generate substrings of a string. The [`String::substring(int, int)`](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html#substring-int-int-) method is perfect for that as we can control the start and the end character to be included, by index.
    * Since we are looking for the **longest** palindrome, we should generate substrings of decreasing length.
    * So, we generate substings of decreasing length and check if they are palindromes.
    * _Recursion_ is best for problems that apply the same strategy to sub-problems of decreasing size. We have one!
        
```text
length | substrings of that length | any palindromes?
-------|---------------------------|----------------
      7| alcohol                   | no
      6| alcoho, lcohol            | no
      5| alcoh, lcoho, cohol       | no
      4| alco, lcoh, coho, ohol    | no
      3| alc, lco, coh, oho, hol   | yes
```
5. How are we sure that this is the **longest palindrome**? _We have tried all longer substrings and they aren't._
