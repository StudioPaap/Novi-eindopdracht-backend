package com.example.eidopdrachtnovi.models;


import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="Projects")
public class Project {

    @Id
    @GeneratedValue
    Long id;

    //  variable declaraties
    private String name;
    private String date;
    private String projectManager;
    private String studioMember;

    @OneToMany(mappedBy = "project")
    private List<DeelOpdracht> deelopdrachtenNamen;


    // Een default constructor
    public Project() {
    }

    //    // Een constructor met alle gevraagde variable
    public Project(String name, String date, String projectManager,
                   String studioMember) {
        this.name = name;
        this.date = date;
        this.projectManager = projectManager;
        this.studioMember = studioMember;
    }

// getters en setters


    public String getStudioMember() {
        return studioMember;
    }

    public void setStudioMember(String studioMember) {
        this.studioMember = studioMember;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getProjectManager() {
        return projectManager;
    }

    public void setProjectManager(String projectManager) {
        this.projectManager = projectManager;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<DeelOpdracht> getDeelopdrachtenNamen() {
        return deelopdrachtenNamen;
    }

    public void setDeelopdrachtenNamen(List<DeelOpdracht> deelopdrachtenNamen) {
        this.deelopdrachtenNamen = deelopdrachtenNamen;
    }
}
