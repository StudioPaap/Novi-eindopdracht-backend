package com.example.eidopdrachtnovi.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name="Deelopdracht")

public abstract class DeelOpdracht {

@Id
@GeneratedValue
Long id;

  //  variable declaraties

  private String name;
  private String kopij;
  private String deadlineFirstVersion ;
  private String deadlineSecVersion;
  private String deadlineDef;
  private String Feedback;
  public Status status;


  // Een default constructor
  public DeelOpdracht() {
  }

  // Een uitgebreide constructor

  public DeelOpdracht(String name, String kopij, String deadline1, String deadline2, String deadlineDef, String feedback, Status status){
    this.name = name;
    this.kopij = kopij;
    this.deadlineFirstVersion=deadline1;
    this.deadlineSecVersion=deadline2;
    this.deadlineDef=deadlineDef;
    this.Feedback = feedback;
    this.status = status;
  }


  // getters en setters


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
}
