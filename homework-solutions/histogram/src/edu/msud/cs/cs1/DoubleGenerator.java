package edu.msud.cs.cs1;

public class DoubleGenerator {
    public static void main(String[] args) {
        double lo = Double.parseDouble(args[0]);
        double hi = Double.parseDouble(args[1]);
        double l = hi - lo;

        for (int i = 0; i < 1000; i++) {
            double d = l * Math.random() + lo;
            System.out.print(d + ", ");
        }
    }
}
