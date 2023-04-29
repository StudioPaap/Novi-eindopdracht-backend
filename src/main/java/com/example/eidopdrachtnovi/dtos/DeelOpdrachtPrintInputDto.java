package com.example.eidopdrachtnovi.dtos;

import com.example.eidopdrachtnovi.models.Printshop;
import jakarta.validation.constraints.NotNull;

public class DeelOpdrachtPrintInputDto extends DeelOpdrachtInputDto {
    @NotNull(message = "Size is requiered")
    private int sizeWidthMM;
    @NotNull(message = "Size is requiered")
    private int sizeLengthMM;
    private int bleed;
    private boolean cutLines;
    public Long printshop;



    public DeelOpdrachtPrintInputDto(int sizeWidthMM, int sizeLengthMM, int bleed, boolean cutLines) {
        this.sizeWidthMM = sizeWidthMM;
        this.sizeLengthMM = sizeLengthMM;
        this.bleed = bleed;
        this.cutLines = cutLines;
    }

    public DeelOpdrachtPrintInputDto(Long printshop) {
        this.printshop = printshop;
    }

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

    public Long getPrintshop() {

        return printshop;
    }

    public void setPrintshop(Long printshop) {
        this.printshop = printshop;
    }
}


