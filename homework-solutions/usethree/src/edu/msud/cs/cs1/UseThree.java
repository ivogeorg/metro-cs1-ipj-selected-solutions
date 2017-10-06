package edu.msud.cs.cs1;

public class UseThree {
    public static void main(String[] args) {
        if (args.length != 3) {
            System.out.println("usage: UseThree name1 name2 name3");
            System.exit(1);
        }

        System.out.println(args[2] + " and " + args[1] + " are chasing after " + args[0]);
        System.exit(0);
    }
}
