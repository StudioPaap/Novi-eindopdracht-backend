package com.example.eidopdrachtnovi.dtos;

import com.example.eidopdrachtnovi.models.Status;

public class DeelOpdrachtDto {
    private Long id;
    private String name;
    private String kopij;
    private String deadlineFirstVersion ;
    private String deadlineSecVersion;
    private String deadlineDef;
    private String feedback;
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
        this.feedback = feedback;
        this.status = status;
        this.projectId = projectId;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getKopij() {
        return kopij;
    }

    public String getDeadlineFirstVersion() {
        return deadlineFirstVersion;
    }

    public String getDeadlineSecVersion() {
        return deadlineSecVersion;
    }

    public String getDeadlineDef() {
        return deadlineDef;
    }

    public String getFeedback() {
        return feedback;
    }

    public Status getStatus() {
        return status;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setKopij(String kopij) {
        this.kopij = kopij;
    }

    public void setDeadlineFirstVersion(String deadlineFirstVersion) {
        this.deadlineFirstVersion = deadlineFirstVersion;
    }

    public void setDeadlineSecVersion(String deadlineSecVersion) {
        this.deadlineSecVersion = deadlineSecVersion;
    }

    public void setDeadlineDef(String deadlineDef) {
        this.deadlineDef = deadlineDef;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }
}
