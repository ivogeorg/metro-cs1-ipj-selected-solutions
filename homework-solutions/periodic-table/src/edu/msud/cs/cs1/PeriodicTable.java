package edu.msud.cs.cs1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.*;

public class PeriodicTable {
    public static final byte NUMBER_OF_CHEMICAL_ELEMENTS = 118; // https://en.wikipedia.org/wiki/Chemical_element
    private static final String SIMPLE_CHEM_FORMULA_PATTERN = "(([A-Z][a-z]?)([1-9]?))+?";

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

    public ChemicalElement getElement(String symbol) throws UnknownChemicalElementException {
        ChemicalElement element = null;
        for (ChemicalElement ce: table) {
            if (ce.getSymbolS().equals(symbol)) {
                element = ce;
                break;
            }
        }
        if (element == null) throw new UnknownChemicalElementException(symbol);
        return element;
    }

    public double molecularWeight(String formula) {
        double weight = 0.0;
        Pattern p = Pattern.compile(SIMPLE_CHEM_FORMULA_PATTERN); // notice the reluctant "one or more" qualifier +?
        Matcher m = p.matcher(formula);
        while (m.find()) {
            String symbol = m.group(2);
            String numAtomStr = m.group(3);
            int numAtoms = (numAtomStr.equals("")) ? 1 : Integer.parseInt(numAtomStr);
            try {
                weight += getElement(symbol).getWeightD() * numAtoms;
            } catch (UnknownChemicalElementException uce) {
                System.err.println("ERROR: " + uce.getMessage());
                return 0.0;
            }
        }

        return weight;
    }

    // for demonstration purposes
    // try in main():
    //        matchFormula("H");
    //        matchFormula("H2");
    //        matchFormula("H2O");
    //        matchFormula("H2O2");
    //        matchFormula("KMnO4");
    //        matchFormula("H2SO4 ");
    private static void matchFormula(String formula) {
        Pattern p = Pattern.compile("(([A-Z][a-z]?)([1-9]?))+?"); // notice the reluctant "one or more" qualifier +?
        Matcher m = p.matcher(formula);
        while (m.find()) {
            System.out.print("Start index: " + m.start());
            System.out.print(" End index: " + m.end() + " ");
            System.out.print(m.group() + " ");
            System.out.print(m.group(2) + " ");
            String numAtoms = m.group(3);
            if (numAtoms.equals(""))
                System.out.println("0");
            else
                System.out.println(numAtoms);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        PeriodicTable table = new PeriodicTable();

        if (table.read(args[0], true)) {
            System.out.println("Elements read: " + table.getTable().size());
//            for (ChemicalElement element: table.getTable()) System.out.println(element);
        } else {
            System.err.println("Problem reading file \'" + args[0] + "\'");
        }

        System.out.println("Molecular weight of H is " + table.molecularWeight("H"));
        System.out.println("Molecular weight of H2 is " + table.molecularWeight("H2"));
        System.out.println("Molecular weight of H2O is " + table.molecularWeight("H2O"));
        System.out.println("Molecular weight of H2O2 is " + table.molecularWeight("H2O2"));
        System.out.println("Molecular weight of CO is " + table.molecularWeight("CO"));
        System.out.println("Molecular weight of CO2 is " + table.molecularWeight("CO2"));
        System.out.println("Molecular weight of H2SO4 is " + table.molecularWeight("H2SO4"));
        System.out.println("Molecular weight of KMnO4 is " + table.molecularWeight("KMnO4"));

        // test what next() does with a missing value
//        Scanner test = new Scanner("Boron,5,B,10.81,2303.16,,2340,536.01,22.19,").useDelimiter(",");
//        while (test.hasNext())
//            System.out.println(test.next());
    }
}
