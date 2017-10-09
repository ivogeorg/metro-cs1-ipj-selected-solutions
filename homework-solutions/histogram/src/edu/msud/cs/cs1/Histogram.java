package edu.msud.cs.cs1;

import edu.princeton.cs.introcs.StdDraw;
import edu.princeton.cs.introcs.StdOut;

public class Histogram {

    static private double[] doubles;

    private static void generator(double lo, double hi) {
        double l = hi - lo;

        for (int i = 0; i < 1000; i++)
            Histogram.doubles[i] = l * Math.random() + lo;
    }

    public static void main(String[] args) {

        // 0. Givens (DONE)
        //    n - number of intervals of the histogram
        //    lo - lower bound of doubles
        //    hi - higher bound of doubles
        int n     = Integer.parseInt(args[0]);
        double lo = Double.parseDouble(args[1]);
        double hi = Double.parseDouble(args[2]);

        // 1. A way to generate many doubles between lo and hi (DONE)
        // 2. A way to feed them to my program (DONE)
        Histogram.doubles = new double[1000];
        generator(lo, hi);

        // 3. A way to find the interval in which each double falls (DONE)
        int[] intervals = new int[n];
        double width = (hi - lo) / n;

        for (int i=0; i<1000; i++) {
            double loc = (Histogram.doubles[i] - lo) / width;
            int intervalIndex = (int) loc;
            intervals[intervalIndex] ++;
        }

        // Sanity check: print the interval counts
        for (int i=0; i<n; i++)
            StdOut.println(intervals[i]);

        // TODO: Use StdDraw to draw the histogram

    }

}
