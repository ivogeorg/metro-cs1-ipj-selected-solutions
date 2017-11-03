### Guidance 
IPJ 3.1.4

### Notes

1. Use the `edu.princeton.cs.introcs.Picture` library to read in the image.
2. Use the `edu.princeton.cs.introcs.Luminance` class to convert to grayscale. Create a new package under `src` with the name `edu.princeton.cs.introcs` and then download the [source file](https://introcs.cs.princeton.edu/java/31datatype/Luminance.java) into it. `Luminance` has a method `toGray` which takes a `Color` and returns the `Color` converted to grayscale. Note that the returned `Color` continues to have 3 channels. See the [Channels](#channels) section for an explanation.
3. Query the `Picture` object you created to count the occurrences of each grayscale shade in the image.

### Channels

There are various ways to represent and store images. Color images usually have data for 3 _layers_ or _channels_, one each for **RED**, **GREEN**, and **BLUE**. Each pixel (the smallest data element of an image) contains 3 values (aka RGB). In Java, the class `java.awt.Color` represents the color value of one pixel. Each of the three channels have values in the range [0, 255]. Here is code from `java.awt.Color` class to illustrate this:
```java
    private static void testColorValueRange(int r, int g, int b, int a) {
        boolean rangeError = false;
        String badComponentString = "";

        if ( a < 0 || a > 255) {
            rangeError = true;
            badComponentString = badComponentString + " Alpha";
        }
        if ( r < 0 || r > 255) {
            rangeError = true;
            badComponentString = badComponentString + " Red";
        }
        if ( g < 0 || g > 255) {
            rangeError = true;
            badComponentString = badComponentString + " Green";
        }
        if ( b < 0 || b > 255) {
            rangeError = true;
            badComponentString = badComponentString + " Blue";
        }
        if ( rangeError == true ) {
        throw new IllegalArgumentException("Color parameter outside of expected range:"
                                           + badComponentString);
        }
    }
```
_Note: If you are wondering what `a` is, this is _alpha_, which represents the level of transparency._
A value in the range [0, 255] fits in 1 byte (8 bits), so storing it in an `int` is extremely wasteful. Instead, `Color` stores the alpha, red, green, and blue values (aka **ARGB**) packed in a single `int`, as follows:
```
 |--------|--------|--------|--------|
 | alpha  |  red   | green  |  blue  |
 |--------|--------|--------|--------|
31       23       15        7        0  - bits
```
Here is the code for the `Color` constructor, showing how it uses _bitwise_ operators to pack the 4 values into an `int`:
```java
    public Color(int r, int g, int b, int a) {
        value = ((a & 0xFF) << 24) |
                ((r & 0xFF) << 16) |
                ((g & 0xFF) << 8)  |
                ((b & 0xFF) << 0);
        testColorValueRange(r,g,b,a);
    }
```
The `<<` operator is the _bitwise left-shift_ operator and causes the bits in a word (32-bit value) to be shifted to the left. The left-hand operand is the value, and the right-hand operand is the number of bits to shift it. The `&` is the _bitwise and_ operator and is used to apply a mask (here all-ones) to the original value. The `|` is a bitwise or operator and is needed to pack the 4 values together into the private `value` field of `Color`. Graphically, the first line of the expression for `value` above does the following:
```
 |--------|--------|--------|--------|
 |00000000|00000000|00000000| alpha  |
 |--------|--------|--------|--------|
31       23       15        7        0  - bits for a

 |--------|--------|--------|--------|
 |11111111|11111111|11111111|11111111|
 |--------|--------|--------|--------|
31       23       15        7        0  - bits for mask 0xFF

 |--------|--------|--------|--------|
 | alpha  |00000000|00000000|00000000|
 |--------|--------|--------|--------|
31       23       15        7        0  - bits for (a & 0xFF) << 24 (left shift fills with zeros)
```
The top-level operation of the full expression, which achieves the final packing, works as follows:
```
 |--------|--------|--------|--------|
 | alpha  |00000000|00000000|00000000|
 |--------|--------|--------|--------|
31       23       15        7        0  - bits for (a & 0xFF) << 24

 |--------|--------|--------|--------|
 |00000000|  red   |00000000|00000000|
 |--------|--------|--------|--------|
31       23       15        7        0  - bits for (r & 0xFF) << 16

 |--------|--------|--------|--------|
 |00000000|00000000| green  |00000000|
 |--------|--------|--------|--------|
31       23       15        7        0  - bits for (g & 0xFF) << 8

 |--------|--------|--------|--------|
 |00000000|00000000|00000000|  blue  |
 |--------|--------|--------|--------|
31       23       15        7        0  - bits for (b & 0xFF) (no shift necessary)

 |--------|--------|--------|--------|
 | alpha  |  red   | green  |  blue  |
 |--------|--------|--------|--------|
31       23       15        7        0  - after top-level bitwise or
```

When a pixel represented by a `Color` object is converted to _grayscale_, the luminance equation converts the 3 color values to a single monochrome luminance (aka [luma](https://en.wikipedia.org/wiki/Luma_(video))) value. The `Color` object packs the same value into all 3 RGB positions. While this might look like a waste of memory, and it might appear that a sigle `byte` is enough to store the value, [_memory alignment_](https://www.ibm.com/developerworks/library/pa-dalign/) will require it to be converted to a 32-bit value anyway.
