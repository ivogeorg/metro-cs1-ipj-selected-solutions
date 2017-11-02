### Guidance

IPJ 3.1.29 (modified)

### Notes

1. Do not write a library of `static` methods, but an instantiable Java class `RawPicture`. That is, each `RawPicture` should be an object that contains all its data in private fields. 
2. You will need members/fields/variables for:
    * Height
    * Width
    * All the pixel values, each of which is a `Color` triple. Use the `java.awt.Color` to represent each individual pixel.
    * File name it was read from, if any
    * File name it would be written to by the `write()` method
    * `Picture`, for when you create a `RawPicture` from a `Picture`
    * `BifferedImage`, for when you create a `RawPicture` from a file read into a `BufferedImage` (see below)
3. Use the IPJ `Picture.java` library to read in a GIF, JPG or PNG image from a file, and then the `get()` method to get the pixel values.
4. Your class should have three (3) constructors:
    1. `RawPicture()`
        * Default constructor that creates an empty `RawPicture`
        * The data members can later be populated by a call to `read()`, as specified below
    2. `RawPicture(Picture picture)`
        * A constructor which takes a `Picture` object, which is assumed to have been initialized from a GIF, JPG or PNG file beforehand
        * Assign the private `Picture` member of `RawPicture` to the object passed as argument
        * Use the proper methods of the `Picture` object to populate the private data members of `RawPicture`
    3. `RawPicture(String filename)`
        * A constructor that takes a filename to read the image data from. There are two cases
        * If the file is in one of the GIF, JPG or PNG formats, borrow the code from the `Picture(String filename)` constructor to open a `File` and read the data into an image, using the Java classes [`javax.imageio.ImageIO`](https://docs.oracle.com/javase/8/docs/api/java/io/File.html) and [`java.awt.image.BufferedImage`](https://docs.oracle.com/javase/8/docs/api/java/awt/image/BufferedImage.html). 
        * Afterwards, use the proper methods of the `BufferedImage` object to populate the private data members of `RawPicture`
        * If the image is in the _raw_ format, written by `write()`, as specified below, use `read()` to read in the data and populate the private members of `RawPicture` directly
5. The `read()` and `write()` methods should not work with `Picture` objects. 
    1. `read(String fromFilename)` should read a `RawPicture` from a _raw_ file (see below)
    2. `write(String toFilename)` should write the data of a `RawPicture` to a file. Use the extension `.RAW` to be able to distinguish from GIF, JPG or PNG files for the constructor which takes a filename
