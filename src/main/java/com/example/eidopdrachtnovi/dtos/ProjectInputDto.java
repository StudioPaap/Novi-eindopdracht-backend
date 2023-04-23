package com.example.eidopdrachtnovi.dtos;


import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;

public class ProjectInputDto {

    @NotNull(message = "Name is required")
    // Type moet ingevuld verplicht worden in je JSON, je krijgt een message als je dit niet doet.
    private String name;
    @NotNull(message = "Date is required")
    private String date;
    private String projectManager;
    private String studioMember;

    private String brandguide;



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

    public String getBranduide() {
        return brandguide;
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

    public void setBranduide(String branduide) {
        this.brandguide = branduide;
    }
}

