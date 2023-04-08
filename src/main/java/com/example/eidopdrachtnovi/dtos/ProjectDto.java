package com.example.eidopdrachtnovi.dtos;

// Deze klasse wordt gebruikt in je Get, Post en Put methodes. Overal waat je een Television als returnwaarde wilt geven.
// Een input DTO behoet geen validatie


public class ProjectDto {
    private Long id;
    private String name;
    private String projectManager;
    private String studioMember;



    // We gebruiken nu geen all-args-constructor, java maakt automatisch al een no-args-constructor. Dus we hoeven geen constructor te maken.
    // Als we wel een all-args-constructor willen gebruiken (bijvoorbeeld in de service.translatetoDto() methode), dan
    // zullen we ook een no-args methode moeten maken, omdat java deze dan niet meer automatisch maakt.

    public ProjectDto() {
    }

    public ProjectDto(Long id, String name, String projectManager, String studioMember) {
        this.id = id;
        this.name = name;
        this.projectManager = projectManager;
        this.studioMember = studioMember;


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
