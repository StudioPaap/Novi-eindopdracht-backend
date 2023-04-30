package com.example.eidopdrachtnovi.models;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "deelOpdrachtDigital")
public class DeelOpdrachtDigital extends DeelOpdracht {
    private String sizePX;
    private boolean animation;
    private String fileFormat;


    // constructor
    public DeelOpdrachtDigital() {
    }

    //constructor 2

    public DeelOpdrachtDigital(long Id, String name, String kopij, String deadline1, String deadline2, String deadlineDef, String feedback, Status status, Project project, String sixePX, boolean animation, String fileFormat) {
        super(name, kopij, deadline1, deadline2, deadlineDef, feedback, status, project);
        this.sizePX = sixePX;
        this.animation = animation;
        this.fileFormat = fileFormat;
    }

    public DeelOpdrachtDigital(String sizePX, boolean animation, String fileFormat) {
        this.sizePX = sizePX;
        this.animation = animation;
        this.fileFormat = fileFormat;
    }

    public DeelOpdrachtDigital(String name, String kopij, String deadline1, String deadline2, String deadlineDef, String feedback, Status status, Project project, String sizePX, boolean animation, String fileFormat) {
        super(name, kopij, deadline1, deadline2, deadlineDef, feedback, status, project);
        this.sizePX = sizePX;
        this.animation = animation;
        this.fileFormat = fileFormat;
    }

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
