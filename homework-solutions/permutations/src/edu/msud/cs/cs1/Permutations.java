package edu.msud.cs.cs1;

public class Permutations {

    private static final String alphabet = "abcdefghijklmnopqrstuvwxyz";

    // TODO: any way to avoid the waste of String?
    private static void printPermutation(String head, String tail) {
        if (tail.length() == 0) {
            System.out.print(head + ' ');
        } else {
            for (int i = 0; i < tail.length(); i++) {
                Permutations.printPermutation(head + tail.charAt(i),
                        (new StringBuffer(tail)).deleteCharAt(i).toString()); // TODO: ugly!
            }
        }
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);

        printPermutation("", alphabet.substring(0, n));
    }
}
