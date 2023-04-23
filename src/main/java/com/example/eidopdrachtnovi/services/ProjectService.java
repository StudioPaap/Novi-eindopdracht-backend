package com.example.eidopdrachtnovi.services;

import com.example.eidopdrachtnovi.dtos.ProjectDto;
import com.example.eidopdrachtnovi.dtos.ProjectInputDto;
import com.example.eidopdrachtnovi.exceptions.RecordNotFoundException;
import com.example.eidopdrachtnovi.models.BrandguideUploadResponse;
import com.example.eidopdrachtnovi.models.Project;
import com.example.eidopdrachtnovi.repositories.BrandguideUploadDownloadRepository;
import com.example.eidopdrachtnovi.repositories.ProjectRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class ProjectService {


    private static ProjectRepository projectRepository;
    private static BrandguideUploadDownloadRepository brandguideUploadDownloadRepository;

    public ProjectService(ProjectRepository projectRepository, BrandguideUploadDownloadRepository brandguideUploadDownloadRepository) {
        this.brandguideUploadDownloadRepository = brandguideUploadDownloadRepository;
        this.projectRepository = projectRepository;
    }


    public List<ProjectDto> getAllProjects() {
        List<Project> pjList = projectRepository.findAll();
        List<ProjectDto> pjDtoList = new ArrayList<>();

        for (Project pj : pjList) {
            ProjectDto dto = transferToDto(pj);
            pjDtoList.add(dto);
        }
        return pjDtoList;
    }

    public List<ProjectDto> getAllProjectsByStudioMember(String studioMember) {
        List<Project> pjList = projectRepository.getAllProjectsByStudioMemberEqualsIgnoreCase(studioMember);
        List<ProjectDto> pjDtoList = new ArrayList<>();

        for (Project pj : pjList) {
            ProjectDto dto = transferToDto(pj);
            pjDtoList.add(dto);
        }
        return pjDtoList;
    }

    public ProjectDto getProjectById(Long id) {
        Optional<Project> projectOptional = projectRepository.findById(id);
        if (projectOptional.isPresent()) {
            Project pj = projectOptional.get();
            return transferToDto(pj);
        } else {
            throw new RecordNotFoundException("geen Project gevonden");
        }
    }


    public ProjectDto addProject(ProjectInputDto dto) {

        Project pj = transferToProject(dto);
        projectRepository.save(pj);

        return transferToDto(pj);
    }

    public static void deleteProject(@RequestBody Long id) {

        projectRepository.deleteById(id);

    }


    public ProjectDto updateProject(Long id, ProjectInputDto newProject) {

        Optional<Project> projectOptional = projectRepository.findById(id);
        if (projectOptional.isPresent()) {

            Project project1 = projectOptional.get();
            project1.setName(newProject.getName());
            project1.setDate(newProject.getDate());
            project1.setProjectManager(newProject.getProjectManager());
            project1.setStudioMember(newProject.getStudioMember());

            Project returnProject = projectRepository.save(project1);

            return transferToDto(returnProject);

        } else {

            throw new RecordNotFoundException("geen project gevonden");

        }

    }

//    public void assignBrandguideToProject(String brandguide, Long ProjectId) {
//
//        Optional<Project> optionalProject = projectRepository.findById(ProjectId);
//
//        Optional<BrandguideUploadResponse> brandguideUploadResponse = brandguideUploadDownloadRepository.findByByName(brandguide);
//
//        if (optionalProject.isPresent() && brandguideUploadResponse.isPresent()) {
//
//            BrandguideUploadResponse brandguide1 = brandguideUploadResponse.get();
//
//            Project project = optionalProject.get();
//
//            project.setBrandguide(brandguide1);
//
//            projectRepository.save(project);
//
//        }
//    }
        public Project transferToProject (ProjectInputDto dto){
            var project = new Project();

            project.setName(dto.getName());
            project.setDate(dto.getDate());
            project.setProjectManager(dto.getProjectManager());
            project.setStudioMember(dto.getStudioMember());

            return project;
        }


    public ProjectDto transferToDto(Project project) {
        ProjectDto dto = new ProjectDto();

        dto.setId(project.getId());
        dto.setName(project.getName());
        dto.setProjectManager(project.getProjectManager());
        dto.setStudioMember(project.getStudioMember());


        return dto;
    }

}
