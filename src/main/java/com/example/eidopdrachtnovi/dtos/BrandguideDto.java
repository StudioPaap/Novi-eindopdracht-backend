package com.example.eidopdrachtnovi.dtos;

public class BrandguideDto {
    private String brandguide;
    private String contentType;
    private String uri;
    private Long projectId;

    public BrandguideDto() {
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

    public Long getProject() {
        return projectId;
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

    public void setProject(Long projectId) {
        this.projectId = projectId;
    }
}