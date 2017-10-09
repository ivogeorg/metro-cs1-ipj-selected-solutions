package edu.msud.cs.cs1;

import edu.princeton.cs.introcs.StdDraw;
import edu.princeton.cs.introcs.StdOut;

public class Histogram {

    private static final int DOUBLE_COUNT = 1000;

    private static void generator(double lo, double hi, double[] doubles) {
        double l = hi - lo;

        for (int i = 0; i < DOUBLE_COUNT; i++)
            doubles[i] = l * Math.random() + lo;
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
        double[] doubles = new double[DOUBLE_COUNT];
        generator(lo, hi, doubles);

        // 3. A way to find the interval in which each double falls (DONE)
        int[] intervals = new int[n]; // define a local integer array to hold the counts for n intervals
        double width = (hi - lo) / n; // calculate the width of an interval (interval widths are the same)

        for (int i=0; i<DOUBLE_COUNT; i++) {
            // the following line produces a decimal, the integer part of which is the right interval index
            double loc = (doubles[i] - lo) / width;
            int intervalIndex = (int) loc; // strip the decimal part
            intervals[intervalIndex] ++;   // use the index to update the count for the interval

            // this can also be done in one line of Java code, but it becomes a bit difficult to read
//            intervals[(int) Math.floor((doubles[i] - lo) / width)] ++;
            // note that Math.floor() rounds a number "down" to the first integer, it still produces a double
            // and requires an integer cast to work as an index for an array
        }

        // Sanity check: print the interval counts
        for (int i=0; i<n; i++)
            StdOut.println(intervals[i]);

        // TODO: Use StdDraw to draw the histogram

    }

}
