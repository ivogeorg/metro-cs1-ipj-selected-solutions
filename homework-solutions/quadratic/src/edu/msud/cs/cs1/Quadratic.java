package edu.msud.cs.cs1;

import edu.princeton.cs.introcs.Complex;
import edu.princeton.cs.introcs.StdOut;

public class Quadratic
{
    private double a, b, c;
    private Complex root1, root2;
    private boolean real;
    private boolean imaginary;

    public Quadratic(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;

        // TODO solve & assign


    }

    public boolean isReal() {
        return real;
    }

    public boolean isImaginary() {
        return imaginary;
    }

    public boolean isSame() {
        return same;
    }

    private boolean same;

    public Complex[] roots() {
        Complex[] roots = { root1, root2 };
        return roots;
    }


    public static void main(String[] args)
    {
        if (args.length != 3) {
            StdOut.println("usage: Quadratic coeff_a coeff_b coeff_c");
            System.exit(1);
        }

        // standard format of quadratic polynomial ax^2 + bx + c
        double a = Double.parseDouble(args[0]);
        double b = Double.parseDouble(args[1]);
        double c = Double.parseDouble(args[2]);

        Quadratic quadratic = new Quadratic(a, b, c);
        StdOut.println("Roots: " + quadratic.root1 + ", " + quadratic.root2);

//        double discriminant = b*b - 4.0*c;
//        double d = Math.sqrt(discriminant);
//        System.out.println((-b + d) / 2.0);
//        System.out.println((-b - d) / 2.0);
    }
}