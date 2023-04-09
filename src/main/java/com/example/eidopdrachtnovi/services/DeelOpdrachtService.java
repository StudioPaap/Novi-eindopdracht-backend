package com.example.eidopdrachtnovi.services;

import com.example.eidopdrachtnovi.dtos.DeelOpdrachtDto;
import com.example.eidopdrachtnovi.dtos.ProjectDto;
import com.example.eidopdrachtnovi.dtos.ProjectInputDto;
import com.example.eidopdrachtnovi.exceptions.RecordNotFoundException;
import com.example.eidopdrachtnovi.models.DeelOpdracht;
import com.example.eidopdrachtnovi.models.Project;
import com.example.eidopdrachtnovi.models.Status;
import com.example.eidopdrachtnovi.repositories.DeelOpdrachtRepository;
import com.example.eidopdrachtnovi.repositories.ProjectRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class DeelOpdrachtService {

    private static DeelOpdrachtRepository deelOpdrachtRepository;

    public DeelOpdrachtService(DeelOpdrachtRepository deelOpdrachtRepository){
        this.deelOpdrachtRepository = deelOpdrachtRepository;
    }


    public List<DeelOpdrachtDto> getAllDeelopdrachten() {
        List<DeelOpdracht> doList = deelOpdrachtRepository.findAll();
        List<DeelOpdrachtDto> doDtoList = new ArrayList<>();

        for(DeelOpdracht do : doList) {
            DeelOpdrachtDto dto = transferToDto(do);
            doDtoList.add(dto);
        }
        return doDtoList;
    }

    public List<DeelOpdrachtDto> getAllDeelOpdrachtByStatus(Status status) {
        List<DeelOpdracht> doList = DeelOpdrachtRepository.getAllDeelOpdrachtByStatus(status);
        List<DeelOpdrachtDto> doDtoList = new ArrayList<>();

        for(DeelOpdracht do : doList) {
            DeelOpdrachtDto dto = transferToDto(do);
            doDtoList.add(dto);
        }
        return doDtoList;
    }

    public DeelOpdrachtDto getProjectById(Long id) {
        Optional<DeelOpdracht> deelOpdrachtOptional = DeelOpdrachtRepository.findById(id);
        if (deelOpdrachtOptional.isPresent()){
            DeelOpdracht do = deelOpdrachtOptional.get();
            return transferToDto(do);
        } else {
            throw new RecordNotFoundException("geen deekopdracht gevonden");
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
        if (projectOptional.isPresent()){

            Project project1 = projectOptional.get();


            project1.setName(newProject.getName());
            project1.setDate(newProject.getDate());
            project1.setProjectManager(newProject.getProjectManager());
            project1.setStudioMember(newProject.getStudioMember());

            Project returnProject = projectRepository.save(project1);

            return transferToDto(returnProject);

        } else {

            throw new  RecordNotFoundException("geen project gevonden");

        }

    }

    // Dit is de vertaal methode van TelevisionInputDto naar Television.
    public Project transferToProject(ProjectInputDto dto){
        var project = new Project();

        project.setName(dto.getName());
        project.setDate(dto.getDate());
        project.setProjectManager(dto.getProjectManager());
        project.setStudioMember(dto.getStudioMember());


        return project;
    }

    // Dit is de vertaal methode van Television naar TelevisionDto
    public ProjectDto transferToDto(Project project){
        ProjectDto dto = new ProjectDto();

        dto.setId(project.getId());
        dto.setName(project.getName());
        dto.setProjectManager(project.getProjectManager());
        dto.setStudioMember(project.getName());

        return dto;
    }
}
