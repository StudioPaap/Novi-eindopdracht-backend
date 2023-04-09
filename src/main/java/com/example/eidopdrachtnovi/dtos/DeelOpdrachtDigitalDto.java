package com.example.eidopdrachtnovi.dtos;

import com.example.eidopdrachtnovi.models.Status;

public class DeelOpdrachtDigitalDto extends DeelOpdrachtDto {
    private String sizePX;
    private boolean animation;
    private String fileFormat;


    // constructor
    public DeelOpdrachtDigitalDto(){}

    //constructor 2

    public DeelOpdrachtDigitalDto(long Id, String name, String kopij, String deadline1, String deadline2, String deadlineDef, String feedback, Status status, String sixePX, boolean animation, String fileFormat){
        super(name, kopij, deadline1, deadline2, deadlineDef, feedback, status);
        this.sizePX = sixePX;
        this.animation= animation;
        this.fileFormat= fileFormat;
    }
    //getters en setters


    public String getSizePX() {
        return sizePX;
    }

    public void setSizePX(String sizePX) {
        this.sizePX = sizePX;
    }

    public boolean isAnimation() {
        return animation;
    }

    public void setAnimation(boolean animation) {
        this.animation = animation;
    }

    public String getFileFormat() {
        return fileFormat;
    }

    public void setFileFormat(String fileFormat) {
        this.fileFormat = fileFormat;
    }


}
