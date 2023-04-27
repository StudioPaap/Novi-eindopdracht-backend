public class BrandguideInputDto {
    private String brandguide;
    private String contentType;
    private String uri;
    private Long projectId;

    public BrandguideInputDto() {
    }

    public BrandguideInputDto(String brandguide, String contentType, String uri, Long projectId) {
        this.brandguide = brandguide;
        this.contentType = contentType;
        this.uri = uri;
        this.projectId = projectId;
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

    public Long getProjectId() {
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

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }
}