package com.example.eidopdrachtnovi.dtos;

import jakarta.validation.constraints.NotNull;

public class DeelOpdrachtPrintInputDto extends DeelOpdrachtInputDto{
    @NotNull(message = "Size is requiered")
    private int sizeWidthMM;
    @NotNull(message = "Size is requiered")
    private int sizeLengthMM;
    @NotNull(message = "Bleed is requiered")
    private int bleed;
    private boolean cutLines;
    private String printer;

    public int getSizeWidthMM() {
        return sizeWidthMM;
    }

    public void setSizeWidthMM(int sizeWidthMM) {
        this.sizeWidthMM = sizeWidthMM;
    }

    public int getSizeLengthMM() {
        return sizeLengthMM;
    }

    public void setSizeLengthMM(int sizeLengthMM) {
        this.sizeLengthMM = sizeLengthMM;
    }

    public int getBleed() {
        return bleed;
    }

    public void setBleed(int bleed) {
        this.bleed = bleed;
    }

    public boolean isCutLines() {
        return cutLines;
    }

    public void setCutLines(boolean cutLines) {
        this.cutLines = cutLines;
    }

    public String getPrinter() {
        return printer;
    }

    public void setPrinter(String printer) {
        this.printer = printer;
    }
}
