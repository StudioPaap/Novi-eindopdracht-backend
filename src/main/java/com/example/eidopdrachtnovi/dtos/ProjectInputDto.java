package com.example.eidopdrachtnovi.dtos;


import jakarta.validation.constraints.NotNull;


public class ProjectInputDto {

    @NotNull(message = "Name is required")
    private String name;
    @NotNull(message = "Date is required")
    private String date;
    private String projectManager;
    private String studioMember;

    private Long BrandguideId;

    public ProjectInputDto(String name, String date, String projectManager, String studioMember) {
        this.name = name;
        this.date = date;
        this.projectManager = projectManager;
        this.studioMember = studioMember;
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

    public Long getBrandguideId() {
        return BrandguideId;
    }

    public String getProjectManager() {
        return projectManager;
    }

    public void setProjectManager(String projectManager) {
        this.projectManager = projectManager;
    }

    public String getStudioMember() {
        return studioMember;
    }

    public void setStudioMember(String studioMember) {
        this.studioMember = studioMember;
    }

    public void setBrandguideID(Long brandguideId) {
        BrandguideId = brandguideId;
    }
}

