package com.example.eidopdrachtnovi.models;


import jakarta.persistence.*;

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

    @OneToOne (mappedBy = "project")
    Brandguide brandguide;

    // Een default constructor
    public Project() {
    }

    //    // Een constructor met alle gevraagde variable
    public Project(String name, String date, String projectManager,
                   String studioMember, byte[]brandguideFile) {
        this.name = name;
        this.date = date;
        this.projectManager = projectManager;
        this.studioMember = studioMember;

    }

// getters en setters


    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDate() {
        return date;
    }

    public String getProjectManager() {
        return projectManager;
    }

    public String getStudioMember() {
        return studioMember;
    }

    public Brandguide getBrandguide() {
        return brandguide;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setProjectManager(String projectManager) {
        this.projectManager = projectManager;
    }

    public void setStudioMember(String studioMember) {
        this.studioMember = studioMember;
    }

    public void setBrandguide(Brandguide brandguide) {
        this.brandguide = brandguide;
    }
}
