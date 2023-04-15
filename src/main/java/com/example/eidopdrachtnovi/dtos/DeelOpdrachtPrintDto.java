package com.example.eidopdrachtnovi.dtos;

import com.example.eidopdrachtnovi.models.Status;

public class DeelOpdrachtPrintDto extends DeelOpdrachtDto{
    private int sizeWidthMM;
    private int sizeLengthMM;
    private int bleed;
    private boolean cutLines;
    private String printer;


    // constructor
    public DeelOpdrachtPrintDto() {
    }

    //constructor 2

    public DeelOpdrachtPrintDto(long Id, String name, String kopij, String deadline1, String deadline2, String deadlineDef, String feedback, Long projectId, Status status, int sizeWidthMM, int sizeLengthMM, int bleed, boolean cutLines, String printer) {
        super(name, kopij, deadline1, deadline2, deadlineDef, feedback, status, projectId);
        this.sizeWidthMM = sizeWidthMM;
        this.sizeLengthMM = sizeLengthMM;
        this.bleed = bleed;
        this.cutLines = cutLines;
        this.printer = printer;
    }
    //getters en setters


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
