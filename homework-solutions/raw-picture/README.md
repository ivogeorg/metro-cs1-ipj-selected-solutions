### Guidance

IPJ 3.1.29 (modified)

### Notes

1. Do not write a library of static methods, but an instantiable Java class `RawPicture`. That is, each `RawPicture` should be an object that contains all its data in private fields. 

2. You will need members/fields/variables for:
  * Height
  * Width
  * All the pixel values, each of which is a `Color` triple. Use the `java.awt.Color` to represent each individual pixel.
  * File name it was read from, if any
  * File name it would be written to by the `write()` method
  * `Picture`, for when you create a `RawPicture` from a `Picture`
  * `BifferedImage`, for when you create a `RawPicture` from a file read into a `BufferedImage` (see below)

3. Use the IPJ `Picture.java` library to read in a GIF, JPG or PNG image from a file, and then the `get()` method to get the pixel values.

4. Your class should have five constructors:
  * A default constructor that creates an empty `RawPicture`. Afterwards it can be filled in with `read()` as specified below.
  * A constructor that takes a filename of a GIF, JPG or PNG image. Use the corresponding `Picture` constructor to read from file.
  * A constructor that takes a `Picture`. This is equivalent with the previous, but skips the reading from a file. You assume that the `Picture` has been initialized already.
  * A constructor that takes a filename of a GIF, JPG or PNG image, but does not use the `Picture` constructor directly. You should study the `Picture(String filename)` constructor for how a `File` is open and the data read into an image of the classes [`javax.imageio.ImageIO`](https://docs.oracle.com/javase/8/docs/api/java/io/File.html) and [`java.awt.image.BufferedImage`](https://docs.oracle.com/javase/8/docs/api/java/awt/image/BufferedImage.html). Links to an external site. are used to read. Use this code to read the image. After performing this, you should still populate your own internal representation, contained in the first three fields specified above.
  * A constructor that takes a filename of a RAW (see below) image and reads it in. Note: We will talk about file I/O and show how it is done.

5. The `read()` and `write()` methods should not work with `Picture` objects. 
read() should read a RawPicture from a RAW file (see below). Note: We will talk about file I/O and show how it is done.
write() should write from a RawPicture to a file. Use the extension RAW.
