package com.example.eidopdrachtnovi.service;


import com.example.eidopdrachtnovi.dtos.ProjectDto;
import com.example.eidopdrachtnovi.dtos.ProjectInputDto;
import com.example.eidopdrachtnovi.models.Project;
import com.example.eidopdrachtnovi.repositories.ProjectRepository;
import com.example.eidopdrachtnovi.services.ProjectService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import java.util.ArrayList;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ProjectServiceTest {

    @Mock
    ProjectRepository repos;

    @InjectMocks
    ProjectService service;

    @Mock
    private Project project;

    @Mock
    private ProjectDto projectDto;

    @Test
    void shouldgetAllProjects() {

        List<Project> list = new ArrayList<>();
        Project p = new Project("Name", "01-02-23", "Milene", "Anouk");
        Project p2 = new Project("Name2", "02-02-23", "Milene", "Anouk");
        list.add(p);
        list.add(p2);

        when(repos.findAll()).thenReturn(list);

        List<ProjectDto> projectDtoList = service.getAllProjects();

        assertEquals(2, projectDtoList.size());
        assertEquals("Name", projectDtoList.get(0).getName());
        assertEquals("Name2", projectDtoList.get(1).getName());
    }


    @Test
    void shouldGetAllProjectsByStudioMember() {

        List<Project> list = new ArrayList<>();
        String studiomember = "Anouk";
        Project p = new Project("Name", "01-02-23", "Milene", studiomember);
        Project p2 = new Project("Name2", "02-02-23", "Milene", studiomember);
        list.add(p);
        list.add(p2);

        when(repos.findAllByStudioMember(studiomember)).thenReturn(list);

        List<ProjectDto> result = service.getAllProjectsByStudioMember(studiomember);

        assertEquals(2, result.size());
        assertEquals("Name", result.get(0).getName());
        assertEquals(studiomember, result.get(0).getStudioMember());
        assertEquals("Name2", result.get(1).getName());
        assertEquals(studiomember, result.get(1).getStudioMember());
    }


    @Test
    void shouldGetProjectById() {

        // Arrange

        String studiomember = "Anouk";
        Project p = new Project("Name", "01-02-23", "Milene", studiomember);
        p.setId(2L);
        Long projectId = p.getId();
        Optional<Project> projectOptional = Optional.of(p);

        when(repos.findById(projectId)).thenReturn(projectOptional);

        // Act
        ProjectDto result = service.getProjectById(projectId);

        // Assert
        assertEquals("Name", result.getName());
        assertEquals("Anouk", result.getStudioMember());
        assertEquals(projectId, result.getId());
    }


    @Test
    void shouldAddProject() {

        ProjectInputDto inputDto = new ProjectInputDto("Name", "01-02-23", "Milene", "Anouk");

        Project project = new Project("Name", "01-02-23", "Milene", "Anouk");
        when(repos.save(any())).thenReturn(project);

        // Act
        ProjectDto result = service.addProject(inputDto);

        // Assert
        verify(repos, times(1)).save(any());
        assertNotNull(result);
        assertEquals(project.getName(), result.getName());
        assertEquals(project.getDate(), result.getDate());
        assertEquals(project.getProjectManager(), result.getProjectManager());
        assertEquals(project.getStudioMember(), result.getStudioMember());
    }


    @Test
    public void shouldDeleteProject() {
        // Arrange
        Long projectId = 1L;

        // Act
        service.deleteProject(projectId);

        // Assert
        verify(repos, times(1)).deleteById(projectId);
    }

    @Test
    public void shouldUpdateProject() {
        // Arrange
        Long projectId = 1L;
        ProjectInputDto inputDto = new ProjectInputDto("New Name", "01-02-24", "New Manager", "New Member");

        Project project = new Project("Old Name", "01-02-23", "Milene", "Anouk");
        project.setId(projectId);
        when(repos.save(any())).thenReturn(project);
        when(repos.findById(projectId)).thenReturn(Optional.of(project));

        // Act
        ProjectDto result = service.updateProject(projectId, inputDto);

        // Assert
        assertEquals(inputDto.getName(), result.getName());
        assertEquals(inputDto.getDate(), result.getDate());
        assertEquals(inputDto.getProjectManager(), result.getProjectManager());
        assertEquals(inputDto.getStudioMember(), result.getStudioMember());
    }

    @Test
    public void shouldTransferToProject() {

        ProjectInputDto inputDto = new ProjectInputDto("Project 1", "2022-05-30", "Milene", "Anouk");

        Project project = service.transferToProject(inputDto);

        assertEquals("Project 1", project.getName());
        assertEquals("2022-05-30", project.getDate());
        assertEquals("Milene", project.getProjectManager());
        assertEquals("Anouk", project.getStudioMember());
    }

    @Test
    public void testTransferToDto() {
        // Maak een dummy Project object
        Project project = new Project("Project 1", "2022-05-30", "Milene", "Anouk");

        // Roep de transferToDto() methode aan op de projectService met het dummy Project object
        ProjectDto projectDto = service.transferToDto(project);

        // Controleer of de eigenschappen van het geretourneerde ProjectDto object overeenkomen met de verwachte waarden
        assertEquals("Project 1", projectDto.getName());
        assertEquals("2022-05-30", projectDto.getDate());
        assertEquals("Milene", projectDto.getProjectManager());
        assertEquals("Anouk", projectDto.getStudioMember());
    }


}



