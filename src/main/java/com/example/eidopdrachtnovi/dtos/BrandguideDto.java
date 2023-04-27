package com.example.eidopdrachtnovi.dtos;

import com.example.eidopdrachtnovi.models.Project;

public class BrandguideDto {
    private String brandguide;
    private String contentType;
    private String uri;
    private Project project;

    public BrandguideDto() {
    }

    public BrandguideDto(String brandguide, String contentType, String uri, Project project) {
        this.brandguide = brandguide;
        this.contentType = contentType;
        this.uri = uri;
        this.project = project;
    }

    public String getBrandguide() {
        return brandguide;
    }

    public String getContentType() {
        return contentType;
    }

    public String getUri() {
        return uri;
    }

    public Project getProject() {
        return project;
    }

    public void setBrandguide(String brandguide) {
        this.brandguide = brandguide;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public void setProject(Project project) {
        this.project = project;
    }
}