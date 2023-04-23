package com.example.eidopdrachtnovi.controllers;

import com.example.eidopdrachtnovi.dtos.ProjectDto;
import com.example.eidopdrachtnovi.dtos.ProjectInputDto;
import com.example.eidopdrachtnovi.models.BrandguideUploadResponse;
import com.example.eidopdrachtnovi.services.ProjectService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@RequestMapping("/project")
@RestController
public class ProjectController {

    private final ProjectService projectService;
    private final BrandguideUploadDownloadController controller;


    public ProjectController(ProjectService projectService, BrandguideUploadDownloadController controller) {
        this.projectService = projectService;
        this.controller = controller;
    }


    @GetMapping()
    public ResponseEntity<List<ProjectDto>> getAllProjects(@RequestParam(value = "studioMember", required = false) Optional<String> studioMember) {

        List<ProjectDto> dtos;

        if (studioMember.isEmpty()) {

            dtos = projectService.getAllProjects();

        } else {
            dtos = projectService.getAllProjectsByStudioMember(studioMember.get());

        }

        return ResponseEntity.ok().body(dtos);

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

//    @PostMapping("/{id}/brandguide")
//
//    public void assignBrandguideToProject(@PathVariable("id") Long projectId,
//                                          @RequestBody MultipartFile file) {
//
//        BrandguideUploadResponse brandguideUploadResponse = controller.singleFileUpload(file);
//
//        projectService.assignBrandguideToProject(brandguideUploadResponse.getBrandguide(), projectId);
//
//    }




    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteProject(@PathVariable Long id) {

        // Hier gebruiken we weer een service methode in plaats van direct de repository aan te spreken.
        ProjectService.deleteProject(id);

        return ResponseEntity.noContent().build();

    }


    @PutMapping("/{id}")
    public ResponseEntity<ProjectDto> updateProject(@PathVariable Long id, @Valid @RequestBody ProjectInputDto newProject) {
        ProjectDto dto = projectService.updateProject(id, newProject);

        return ResponseEntity.ok().body(dto);
    }



}
