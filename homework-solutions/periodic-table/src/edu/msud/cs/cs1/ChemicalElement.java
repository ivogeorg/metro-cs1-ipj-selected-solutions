package edu.msud.cs.cs1;

public class ChemicalElement {
    // In every temperature scale, -1000.0 is way "under" absolute zero, so it's nonsensical.
    public static final double MISSING_TEMPERATURE = -1000.0;
    // Negative density is nonsensical.
    public static final int MISSING_DENSITY = -1;

    // Element,Number,Symbol,Weight,Boil,Melt,Density,Vapour,Fusion,
    private String elementS;
    private byte numberB;
    private String symbolS;
    private double weightD;

    // the rest might be missing - need sensible defaults
    private double boilD;
    private double meltD;
    private int densityI;
    private double vaporD;
    private double fusionD;

    // full constructor
    public ChemicalElement(String element,
                           byte number,
                           String symbol,
                           double weight,
                           double boil,
                           double melt,
                           int density,
                           double vapor,
                           double fusion) {
        elementS = element;
        numberB = number;
        symbolS = symbol;
        weightD = weight;
        boilD = boil;
        meltD = melt;
        densityI = density;
        vaporD = vapor;
        fusionD = fusion;
    }

    // default constructor
    public ChemicalElement() {
        elementS = "";
        numberB = 0;
        symbolS = "";
        weightD = 0.0;
        boilD = MISSING_TEMPERATURE;
        meltD = MISSING_TEMPERATURE;
        densityI = MISSING_DENSITY;
        vaporD = MISSING_TEMPERATURE;
        fusionD = MISSING_TEMPERATURE;
    }

    // getters & setters
    public String getElementS() {
        return elementS;
    }

    public void setElementS(String elementS) {
        this.elementS = elementS;
    }

    public byte getNumberB() {
        return numberB;
    }

    public void setNumberB(byte numberB) {
        this.numberB = numberB;
    }

    public String getSymbolS() {
        return symbolS;
    }

    public void setSymbolS(String symbolS) {
        this.symbolS = symbolS;
    }

    public double getWeightD() {
        return weightD;
    }

    public void setWeightD(double weightD) {
        this.weightD = weightD;
    }

    public double getBoilD() {
        return boilD;
    }

    public void setBoilD(double boilD) {
        this.boilD = boilD;
    }

    public double getMeltD() {
        return meltD;
    }

    public void setMeltD(double meltD) {
        this.meltD = meltD;
    }

    public int getDensityI() {
        return densityI;
    }

    public void setDensityI(int densityI) {
        this.densityI = densityI;
    }

    public double getVaporD() {
        return vaporD;
    }

    public void setVaporD(double vaporD) {
        this.vaporD = vaporD;
    }

    public double getFusionD() {
        return fusionD;
    }

    public void setFusionD(double fusionD) {
        this.fusionD = fusionD;
    }

    @Override
    public String toString() {
        // TODO report missing values with 'unknown' or 'n/a' instead of the nonsensical defaults
        return (new StringBuffer())
                .append("Chemical element: ").append(elementS)
                .append(" [").append(numberB).append(" | ").append(symbolS).append("]\n")
                .append(" Weight: ").append(weightD).append('\n')
                .append(" Density: ").append(densityI).append('\n')
                .append(" Temp (b|m|v|f): ")
                .append(boilD).append(", ")
                .append(meltD).append(", ")
                .append(vaporD).append(", ")
                .append(fusionD)
                .toString();
    }
}
