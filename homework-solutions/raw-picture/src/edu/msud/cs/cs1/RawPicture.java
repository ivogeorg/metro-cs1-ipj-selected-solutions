package edu.msud.cs.cs1;

import java.awt.Color;
import java.util.ArrayList;

import edu.princeton.cs.introcs.Picture;

public class RawPicture {
    private int height, width;
    private Color[] pixels;
    private String toFilename, fromFilename;
    private Picture picture;

    public RawPicture() {
        height = width = 0;
        pixels = null;
        toFilename = "picture.RAW";
        fromFilename = null;
    }

    public RawPicture(Picture picture) {
        // initialize relevant private members
        this.picture = picture;
        height = picture.height();
        width = picture.width();

        // read the pixel colors, by columnd and row, from picture using an ArrayList
        ArrayList<Color> tempPix = new ArrayList<>();
        for (int col = 0; col < picture.width(); col ++)
            for (int row = 0; row < picture.height(); row ++)
                tempPix.add(picture.get(col, row));

        // initialize the private pixels array, using the size of the ArrayList
        pixels = new Color[tempPix.size()];

        // populate pixels with the data from the ArrayList
        int i = 0;
        for (Color c: tempPix) pixels[i ++] = c;
    }

    public RawPicture(String filename) {
        fromFilename = filename;
        picture = new Picture(filename);
        height = picture.height();
        width = picture.width();
        // if image is GIF, JPG, or PNG
        // ... populate pixels from BufferedImage read from a File
        // else
        // ... populate pixels with a call to RawPicture::read()
    }

    public void write(String toFilename) {
        // TODO
    }

    public void read(String fromFilename) {
        // TODO
    }

    public static void main(String[] args) {}
}
