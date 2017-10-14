package edu.msud.cs.cs1;

import edu.princeton.cs.introcs.Complex;
import edu.princeton.cs.introcs.StdOut;

public class Quadratic {
    private Complex root1, root2;
    private boolean real, complex, same;


    public Quadratic(double a, double b, double c) {
        if (a == 0.0)
            throw new ArithmeticException("Quadratic: quadratic coefficient cannot be zero");

        double determinant = b * b - 4.0 * a * c;

        if (determinant > 0.0) { // real and different roots
            root1 = new Complex((-b + Math.sqrt(determinant)) / (2.0 * a), 0.0);
            root2 = new Complex((-b - Math.sqrt(determinant)) / (2.0 * a), 0.0);
        } else if (determinant == 0.0) { // real and equal roots
            root1 = new Complex(-b / (2 * a), 0.0);
            root2 = Complex.Complex(root1);
        } else { // complex roots
            root1 = new Complex(-b / (2 * a), Math.sqrt(-determinant) / (2 * a));
            root2 = new Complex(-b / (2 * a), -Math.sqrt(-determinant) / (2 * a));
        }

        real = (determinant >= 0.0);
        complex = ! this.real;
        same = root1.equals(root2);
    }

    public boolean isReal() {
        return real;
    }

    public boolean isComplex() {
        return complex;
    }

    public boolean isSame() {
        return same;
    }

    public Complex[] roots() {
        Complex[] roots = {root1, root2};
        return roots;
    }


    public static void main(String[] args) {
        if (args.length != 3) {
            StdOut.println("usage: Quadratic coeff_a coeff_b coeff_c");
            System.exit(1);
        }

        // standard format of quadratic polynomial ax^2 + bx + c
        double a = Double.parseDouble(args[0]);
        double b = Double.parseDouble(args[1]);
        double c = Double.parseDouble(args[2]);

        if (a == 0.0) {
            StdOut.println("error: quadratic coefficient cannot be zero");
            System.exit(1);

        }

        Quadratic quadratic = new Quadratic(a, b, c);
        Complex[] roots = quadratic.roots();
        StdOut.println("Roots: " + roots[0] + ", " + roots[1]);
    }
}