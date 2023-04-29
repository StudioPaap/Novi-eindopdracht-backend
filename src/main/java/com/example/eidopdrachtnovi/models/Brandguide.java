package com.example.eidopdrachtnovi.models;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Brandguide {
    @Id
    @GeneratedValue
    Long id;
    private String brandguide;
    private String contentType;
    private String uri;

    @OneToOne
    private Project project;


    public Brandguide() {

    }

    public Brandguide(String brandguide, String contentType, String uri) {
        this.brandguide = brandguide;
        this.contentType = contentType;
        this.uri = uri;
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

    public void setProjectBrandguide(String projectBrandguide) {
        brandguide = projectBrandguide;
    }

    public void setContentype(String contentype) {
        this.contentType = contentype;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public void setProject(Project project) {
        this.project = project;
    }
}
