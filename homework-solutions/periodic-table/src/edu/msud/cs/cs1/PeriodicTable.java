package edu.msud.cs.cs1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class PeriodicTable {
    public static final byte NUMBER_OF_CHEMICAL_ELEMENTS = 118; // https://en.wikipedia.org/wiki/Chemical_element

    private ArrayList<ChemicalElement> table;

    public PeriodicTable() {
        table = new ArrayList<>(NUMBER_OF_CHEMICAL_ELEMENTS); // allocate initial capacity
    }

    public boolean read(String filename) {
        boolean success = false;
        Scanner file = null;

        // try to open the file
        try {
            file = new Scanner(new File(filename));
            success = true;
        } catch (FileNotFoundException fnf) { // we might expect this one
            System.err.println("Error: no file named \'" + filename + "\'");
        } catch (Exception e) { // if it's something else
            System.err.println("Error: " + e.getMessage());
        }

        if (!success) return success;

        try {
            while (file.hasNext()) {
                String line = file.nextLine();
                Scanner elementData = new Scanner(line).useDelimiter("\\s*,\\s*");
                ChemicalElement element = new ChemicalElement(); // element with nonsensical defaults
                // read in data, parsing when necessary
                if (elementData.hasNext()) element.setElementS(elementData.next()); else continue;
                if (elementData.hasNext()) element.setNumberB(Byte.parseByte(elementData.next())); else continue;
                if (elementData.hasNext()) element.setSymbolS(elementData.next()); else continue;
                if (elementData.hasNext()) element.setWeightD(Double.parseDouble(elementData.next()));


            }

        } catch (NumberFormatException nfe) {
            System.err.println("Error: cannot parse invalid number");
            success = false;
        }

        return success;
    }
}
