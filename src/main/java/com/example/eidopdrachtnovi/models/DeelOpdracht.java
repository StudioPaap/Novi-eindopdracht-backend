package com.example.eidopdrachtnovi.models;

import com.example.eidopdrachtnovi.dtos.DeelOpdrachtDto;
import jakarta.persistence.*;


@Entity
@Table(name="Deelopdracht")

public abstract class DeelOpdracht {

  @Id
  @GeneratedValue
  Long id;

  //  variable declaraties

  private String name;
  private String kopij;
  private String deadlineFirstVersion;
  private String deadlineSecVersion;
  private String deadlineDef;
  private String feedback;
  public Status status;


  @ManyToOne
  @JoinColumn(name = "project_id")
  private Project project;


  // Een default constructor
  public DeelOpdracht() {
  }

  // Een uitgebreide constructor

  public DeelOpdracht(String name, String kopij, String deadline1, String deadline2, String deadlineDef, String feedback, Status status, Project project) {
    this.name = name;
    this.kopij = kopij;
    this.deadlineFirstVersion = deadline1;
    this.deadlineSecVersion = deadline2;
    this.deadlineDef = deadlineDef;
    this.feedback = feedback;
    this.status = status;
    this.project = project;

  }


  // getters en setters

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

  public Project getProject() {
    return project;
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

  public void setProject(Project project) {
    this.project = project;
  }
}