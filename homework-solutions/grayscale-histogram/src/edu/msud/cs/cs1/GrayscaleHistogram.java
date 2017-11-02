package edu.msud.cs.cs1;

import edu.princeton.cs.introcs.Luminance;
import edu.princeton.cs.introcs.Picture;

import java.awt.Color;

public class GrayscaleHistogram {
    private int[] grayscaleCounts;
    // other data members to hold the histogram

    public GrayscaleHistogram(String imgFilename) {
        grayscaleCounts = new int[256]; // grayscale shades are from 0 (black) to 255 (white)

        Picture picture = new Picture(imgFilename);
        for (int col = 0; col < picture.width(); col++) {
            for (int row = 0; row < picture.height(); row++) {
                Color color = picture.get(col, row); // count each pixel of the image
                Color gray = Luminance.toGray(color); // convert to grayscale (does nothing if already grayscale)

                // Note: The gray Color contains three equal values (see Luminance.java), so you can get any one of them
                grayscaleCounts[gray.getBlue()]++; // count the occurrence of the found value (in grayscale, R=G=B=Y, where Y is the monochrome luminance)
            }
        }

        // TODO
        // use grayscaleCounts to populate the histogram
        constructHistogram();
    }

    private void constructHistogram() {
        // TODO
    }

    public void printHistogram() {
        // TODO
    }

    public static void main(String[] args) {

    }
}
