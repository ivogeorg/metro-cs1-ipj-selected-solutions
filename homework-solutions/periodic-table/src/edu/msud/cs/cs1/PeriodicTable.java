package edu.msud.cs.cs1;

import java.io.File;
import java.io.FileNotFoundException;
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
    public boolean read(String filename, boolean hasHeader) {
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

        // check header
        if (hasHeader) file.nextLine();
        try {
            while (file.hasNext()) {
                line = file.nextLine();
                Scanner elementData = new Scanner(line).useDelimiter("\\s*,\\s*");

                element = new ChemicalElement(); // element with nonsensical defaults
                table.add(element); // have to add it ahead of time

                // read in data, parsing when necessary, and set the element's fields
                // the following are never missing
                if (elementData.hasNext()) element.setElementS(elementData.next()); else continue;
                if (elementData.hasNext()) element.setNumberB(Byte.parseByte(elementData.next())); else continue;
                if (elementData.hasNext()) element.setSymbolS(elementData.next()); else continue;
                if (elementData.hasNext()) element.setWeightD(Double.parseDouble(elementData.next())); else continue;

                // the following might be missing
                if (elementData.hasNext()) {
                    String data = elementData.next();
                    if (!data.equals(""))
                        element.setBoilD(Double.parseDouble(data));
                    else
                        element.setBoilD(ChemicalElement.MISSING_TEMPERATURE);
                } else continue;

                if (elementData.hasNext()) {
                    String data = elementData.next();
                    if (!data.equals(""))
                        element.setMeltD(Double.parseDouble(data));
                    else
                        element.setMeltD(ChemicalElement.MISSING_TEMPERATURE);
                } else continue;

                if (elementData.hasNext()) {
                    String data = elementData.next();
                    if (!data.equals(""))
                        element.setDensityI(Integer.parseInt(data));
                    else
                        element.setDensityI(ChemicalElement.MISSING_DENSITY);
                } else continue;

                if (elementData.hasNext()) {
                    String data = elementData.next();
                    if (!data.equals(""))
                        element.setVaporD(Double.parseDouble(data));
                    else
                        element.setVaporD(ChemicalElement.MISSING_TEMPERATURE);
                } else continue;

                if (elementData.hasNext()) {
                    String data = elementData.next();
                    if (!data.equals(""))
                        element.setFusionD(Double.parseDouble(data));
                    else
                        element.setFusionD(ChemicalElement.MISSING_TEMPERATURE);
                }
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

    public double molecularWeight(String formula) {
        double weight = 0.0;
        StringBuffer symbol = null;
        ChemicalElement element = null;
        int numAtoms = 1;
        for (int i=0; i<formula.length(); i++) {
            char c = formula.charAt(i);
            if (Character.isAlphabetic(c)) {
                if (Character.isUpperCase(c)) {
                    if (symbol != null) { // previous symbol
                        try {
                            weight += getElement(symbol.toString()).getWeightD() * numAtoms;
                        } catch (UnknownChemicalElement uce) {
                            System.err.println("ERROR: " + uce.getMessage());
                            return 0.0;
                        }
                    }
                    symbol = new StringBuffer().append(c); // StringBuffer(c) interprets c as int for initial capacity
                    numAtoms = 1;
                } else {
                    // assume symbol is not null and there is a capital letter in it already
                    symbol.append(c); // Fun code inspection here :D
                }
            } else if (Character.isDigit(c)) {
                // assume symbol is not null and there is something in it
                try {
                    weight += getElement(symbol.toString()).getWeightD() * (int) c; // Fun code inspection here :D
                } catch (UnknownChemicalElement uce) {
                    System.err.println("ERROR: " + uce.getMessage());
                    return 0.0;
                }
                symbol = null;
                numAtoms = 1;
            } else {
                System.err.println("ERROR: Unexpected character in formula \'"+c+"\'");
                return 0.0;
            }
        }

        return weight;
    }

    public static void main(String[] args) {
        PeriodicTable table = new PeriodicTable();

        if (table.read(args[0], true)) {
            System.out.println("Elements read: " + table.getTable().size());
            for (ChemicalElement element: table.getTable()) System.out.println(element);
        } else {
            System.err.println("Problem reading file \'" + args[0] + "\'");
        }

//        System.out.println("Molecular weight of H2O is " + table.molecularWeight("H2O"));

        // test what next() does with a missing value
//        Scanner test = new Scanner("Boron,5,B,10.81,2303.16,,2340,536.01,22.19,").useDelimiter(",");
//        while (test.hasNext())
//            System.out.println(test.next());
    }
}
