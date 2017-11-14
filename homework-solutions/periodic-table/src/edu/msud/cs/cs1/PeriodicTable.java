package edu.msud.cs.cs1;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.annotation.ElementType;
import java.util.ArrayList;
import java.util.Scanner;

public class PeriodicTable {
    public static final byte NUMBER_OF_CHEMICAL_ELEMENTS = 118; // https://en.wikipedia.org/wiki/Chemical_element

    private ArrayList<ChemicalElement> table;

    // default constructor
    public PeriodicTable() {
        table = new ArrayList<>(NUMBER_OF_CHEMICAL_ELEMENTS); // allocate initial capacity
    }

    // getters & setters
    public ArrayList<ChemicalElement> getTable() {
        return table;
    }

    // instance methods
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

        // declare and initialize variables that might be useful for handling exceptions (see catch block)
        String line = "";
        ChemicalElement element = null;
        try {
            while (file.hasNext()) {
                line = file.nextLine();
                Scanner elementData = new Scanner(line).useDelimiter("\\s*,\\s*");

                element = new ChemicalElement(); // element with nonsensical defaults
                table.add(element); // have to add it ahead of time

                // read in data, parsing when necessary, and set the element's fields
                if (elementData.hasNext()) element.setElementS(elementData.next()); else continue;
                if (elementData.hasNext()) element.setNumberB(Byte.parseByte(elementData.next())); else continue;
                if (elementData.hasNext()) element.setSymbolS(elementData.next()); else continue;
                if (elementData.hasNext()) element.setWeightD(Double.parseDouble(elementData.next())); else continue;
                if (elementData.hasNext()) element.setBoilD(Double.parseDouble(elementData.next())); else continue;
                if (elementData.hasNext()) element.setMeltD(Double.parseDouble(elementData.next())); else continue;
                if (elementData.hasNext()) element.setDensityI(Integer.parseInt(elementData.next())); else continue;
                if (elementData.hasNext()) element.setVaporD(Double.parseDouble(elementData.next())); else continue;
                if (elementData.hasNext()) element.setFusionD(Double.parseDouble(elementData.next()));
            }
        } catch (NumberFormatException nfe) {
            System.err.println("Error: cannot parse invalid number on line \'" + line + "\'");
            table.remove(element); // remove element since it might not be well-formed
            success = false;
        }

        // cleanup
        file.close();
        file = null;

        return success;
    }

    public ChemicalElement getElement(String symbol) throws UnknownChemicalElement {
        ChemicalElement element = null;
        for (ChemicalElement ce: table) {
            if (ce.getSymbolS().equals(symbol)) {
                element = ce;
                break;
            }
        }
        if (element == null) throw new UnknownChemicalElement(symbol);
        return element;
    }

    // TODO finish...
    public double molecularWeight(String formula) {
        double weight = 0.0;
        StringBuffer symbol = null;
        ChemicalElement element = null;
        int numAtoms = 1;
        for (int i=0; i<formula.length(); i++) {
            char c = formula.charAt(i);
            if (Character.isAlphabetic(c)) {
                if (Character.isUpperCase(c)) {
                    if (symbol != null) {
//                        weight += table
                    }
                    symbol = new StringBuffer(c);
                }
            } else if (Character.isDigit(c)) {

            } else {
                System.err.println("ERROR: Unexpected character in formula \'"+c+"\'");
                return 0.0;
            }
        }

        return weight;
    }

    public static void main(String[] args) {
        PeriodicTable table = new PeriodicTable();

        if (table.read(args[0])) {
            System.out.println("Elements read: " + table.getTable().size());
            for (ChemicalElement element: table.getTable()) System.out.println(element);
        } else {
            System.err.println("Problem reading file \'" + args[0] + "\'");
        }
    }
}
