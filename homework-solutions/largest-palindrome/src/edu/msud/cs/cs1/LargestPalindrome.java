package edu.msud.cs.cs1;

public class LargestPalindrome {

    private String str, palindrome;

    public LargestPalindrome(String input) {
        str = input;
        palindrome = longestPaliSub(str, str.length());
    }

    private boolean isPalindrome(String s) { // use to test the substrings
        return s.equals((new StringBuffer(s)).reverse().toString());
    }

    private String longestPaliSub(String s, int length) {
        // TODO
        // Hint: Use ArrayList to collect the substrings of a particular length
        // Hint: You terminate the recursion when you find a palindrome or length == 1
        // Hint: Up to you whether to consider a single character a palindrome
        // Note: There might be more than one palindrome of the same length (e.g. mama)

        return "";
    }

    public String get() {
        return palindrome;
    }

    public static void main(String[] args) {
        System.out.println((new LargestPalindrome("alcohol")).get()); // should print "oho"
        System.out.println((new LargestPalindrome("alhambra")).get()); // should print nothing
        System.out.println((new LargestPalindrome("tattarrattat")).get()); // should print "tattarrattat"
    }
}
