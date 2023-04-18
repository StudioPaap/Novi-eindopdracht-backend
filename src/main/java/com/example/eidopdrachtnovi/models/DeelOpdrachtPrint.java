package com.example.eidopdrachtnovi.models;

import com.example.eidopdrachtnovi.dtos.DeelOpdrachtDto;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "DeelOpdrachtPrint")
public class DeelOpdrachtPrint extends DeelOpdracht {
    private int sizeWidthMM;
    private int sizeLengthMM;
    private int bleed;
    private boolean cutLines;

    @OneToOne
    private Printshop printshop;


    // constructor
    public DeelOpdrachtPrint() {
    }

    //constructor 2

    public DeelOpdrachtPrint(long Id, String name, String kopij, String deadline1, String deadline2, String deadlineDef, String feedback, Status status, Project project, int sizeWidthMM, int sizeLengthMM, int bleed, boolean cutLines, Printshop printshop) {
        super(name, kopij, deadline1, deadline2, deadlineDef, feedback, status, project);
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

    public Printshop getPrintshop() {
        return printshop;
    }

    public void setPrintshop(Printshop printshop) {
        this.printshop = printshop;
    }
}
