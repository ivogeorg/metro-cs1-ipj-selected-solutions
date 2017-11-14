package edu.msud.cs.cs1;

public class UnknownChemicalElement extends Exception {
    UnknownChemicalElement(String symbol) {
        super("Unknown chemical element symbol \'" + symbol + "\'");
    }
}
