package com.example.eidopdrachtnovi.dtos;

import com.example.eidopdrachtnovi.models.Status;
import jakarta.validation.constraints.NotNull;

public class DeelOpdrachtInputDto {
    private Long id;
    private String name;
    private String kopij;
    private String deadlineFirstVersion;
    private String deadlineSecVersion;
    @NotNull(message = "Deadline is required")
    private String deadlineDef;
    private String feedback;
    public Status status;
    public Long projectId;

    public Long getId() {
        return id;
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
        return feedback;
    }


    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }
}
