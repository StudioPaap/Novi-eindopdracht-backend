package com.example.eidopdrachtnovi.dtos;

import com.example.eidopdrachtnovi.models.BrandguideUploadResponse;

import java.util.ArrayList;
import java.util.List;

public class ProjectDto {
    private Long id;
    private String name;
    private String projectManager;
    private String studioMember;
    private BrandguideUploadResponse brandguide;

    public ProjectDto() {
    }

    public ProjectDto(Long id, String name, String projectManager, String studioMember) {
        this.id = id;
        this.name = name;
        this.projectManager = projectManager;
        this.studioMember = studioMember;


    }

    public ProjectDto(BrandguideUploadResponse brandguide){
        this.brandguide = brandguide;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

}
