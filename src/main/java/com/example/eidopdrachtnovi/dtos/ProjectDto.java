package com.example.eidopdrachtnovi.dtos;

import com.example.eidopdrachtnovi.models.Brandguide;

public class ProjectDto {
    private Long id;
    private String name;
    private String date;
    private String projectManager;
    private String studioMember;
    private Brandguide brandguide;

    public ProjectDto() {
    }

    public ProjectDto(Long id, String name, String date, String projectManager, String studioMember) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.projectManager = projectManager;
        this.studioMember = studioMember;


    }

    public ProjectDto(Brandguide brandguide){
        this.brandguide = brandguide;
    }

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
