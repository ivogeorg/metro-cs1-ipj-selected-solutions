package edu.msud.cs.cs1;

import java.awt.Color;

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
        this.picture = picture;
        height = picture.height();
        width = picture.width();
        // ... populate pixels from picture using an ArrayList
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

    }

    public void read(String fromFilename) {

    }

    public static void main(String[] args) {

    }
}
