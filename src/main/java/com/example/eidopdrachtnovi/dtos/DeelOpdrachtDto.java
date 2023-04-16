package com.example.eidopdrachtnovi.dtos;

import com.example.eidopdrachtnovi.models.Status;

public class DeelOpdrachtDto {

    private String name;
    private String kopij;
    private String deadlineFirstVersion ;
    private String deadlineSecVersion;
    private String deadlineDef;
    private String Feedback;
    public Status status;
    public Long projectId;

    // Een default constructor
    public DeelOpdrachtDto() {
    }

    // Een uitgebreide constructor

    public DeelOpdrachtDto(String name, String kopij, String deadline1, String deadline2, String deadlineDef, String feedback, Status status, Long projectId ){
        this.name = name;
        this.kopij = kopij;
        this.deadlineFirstVersion=deadline1;
        this.deadlineSecVersion=deadline2;
        this.deadlineDef=deadlineDef;
        this.Feedback = feedback;
        this.status = status;
        this.projectId = projectId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKopij() {
        return kopij;
    }

    public void setKopij(String kopij) {
        this.kopij = kopij;
    }

    public String getDeadlineFirstVersion() {
        return deadlineFirstVersion;
    }

    public void setDeadlineFirstVersion(String deadlineFirstVersion) {
        this.deadlineFirstVersion = deadlineFirstVersion;
    }

    public String getDeadlineSecVersion() {
        return deadlineSecVersion;
    }

    public void setDeadlineSecVersion(String deadlineSecVersion) {
        this.deadlineSecVersion = deadlineSecVersion;
    }

    public String getDeadlineDef() {
        return deadlineDef;
    }

    public void setDeadlineDef(String deadlineDef) {
        this.deadlineDef = deadlineDef;
    }

    public String getFeedback() {
        return Feedback;
    }

    public void setFeedback(String feedback) {
        Feedback = feedback;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
