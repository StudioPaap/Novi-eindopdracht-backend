package com.example.eidopdrachtnovi.dtos;

import com.example.eidopdrachtnovi.models.Printshop;
import com.example.eidopdrachtnovi.models.Status;

public class DeelOpdrachtPrintDto extends DeelOpdrachtDto{
    private int sizeWidthMM;
    private int sizeLengthMM;
    private int bleed;
    private boolean cutLines;
    private Long printshop;


    // constructor
    public DeelOpdrachtPrintDto() {
    }

    //constructor 2

    public DeelOpdrachtPrintDto(long Id, String name, String kopij, String deadline1, String deadline2, String deadlineDef, String feedback, Long projectId, Status status, int sizeWidthMM, int sizeLengthMM, int bleed, boolean cutLines, Long printShop) {
        super(name, kopij, deadline1, deadline2, deadlineDef, feedback, status, projectId);
        this.sizeWidthMM = sizeWidthMM;
        this.sizeLengthMM = sizeLengthMM;
        this.bleed = bleed;
        this.cutLines = cutLines;
        this.printshop = printshop;
    }
    //getters en setters


    public int getSizeWidthMM() {
        return sizeWidthMM;
    }

    public int getSizeLengthMM() {
        return sizeLengthMM;
    }

    public int getBleed() {
        return bleed;
    }

    public boolean isCutLines() {
        return cutLines;
    }

    public Long getPrintshop() {
        return printshop;
    }

    public void setSizeWidthMM(int sizeWidthMM) {
        this.sizeWidthMM = sizeWidthMM;
    }

    public void setSizeLengthMM(int sizeLengthMM) {
        this.sizeLengthMM = sizeLengthMM;
    }

    public void setBleed(int bleed) {
        this.bleed = bleed;
    }

    public void setCutLines(boolean cutLines) {
        this.cutLines = cutLines;
    }

    public void setPrintshop(Long printshop) {
        this.printshop = printshop;
    }
}
