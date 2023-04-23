package com.example.eidopdrachtnovi.models;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class BrandguideUploadResponse {
    @Id
    private String brandguide;
    private String contentType;
    private String uri;


    public BrandguideUploadResponse() {

    }

    public BrandguideUploadResponse(String brandguide, String contentType, String uri) {
        this.brandguide = brandguide;
        this.contentType = contentType;
        this.uri = uri;
    }

    public String getProjectBrandguide() {
        return brandguide;
    }

    public String getContentype() {
        return contentType;
    }

    public String getUri() {
        return uri;
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
}
