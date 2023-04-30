package com.example.eidopdrachtnovi.controllers;


import com.example.eidopdrachtnovi.dtos.ProjectDto;
import com.example.eidopdrachtnovi.dtos.ProjectInputDto;
import com.example.eidopdrachtnovi.services.ProjectService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RequestMapping("/project")
@RestController
public class ProjectController {

    private final ProjectService projectService;
    private final BrandguideController brandguideController;


    public ProjectController(ProjectService projectService, BrandguideController brandguideController) {
        this.projectService = projectService;
        this.brandguideController = brandguideController;
    }


    @GetMapping()
    public ResponseEntity<List<ProjectDto>> getAllProjects() {

        List<ProjectDto> dtos;

        dtos = projectService.getAllProjects();


        return ResponseEntity.ok().body(dtos);

    }


    @GetMapping("/studio/{studioMember}")
    public ResponseEntity<List<ProjectDto>> getAllProjectsByStudioMember(@PathVariable("studioMember") String studioMember) {
        List<ProjectDto> pds;

        pds = projectService.getAllProjectsByStudioMember(studioMember);
        return ResponseEntity.ok().body(pds);
    }


    @GetMapping("/{id}")
    public ResponseEntity<ProjectDto> getProject(@PathVariable("id") Long id) {

        ProjectDto project = projectService.getProjectById(id);

        return ResponseEntity.ok().body(project);

    }


    @PostMapping()
    public ResponseEntity<ProjectDto> addProject(@Valid @RequestBody ProjectInputDto projectInputDto) {

        ProjectDto dto = projectService.addProject(projectInputDto);

        return ResponseEntity.created(null).body(dto);

    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteProject(@PathVariable Long id) {

        ProjectService.deleteProject(id);

        return ResponseEntity.noContent().build();

    }


    @PutMapping("/{id}")
    public ResponseEntity<ProjectDto> updateProject(@PathVariable Long id, @Valid @RequestBody ProjectInputDto newProject) {
        ProjectDto dto = projectService.updateProject(id, newProject);

        return ResponseEntity.ok().body(dto);
    }


}
