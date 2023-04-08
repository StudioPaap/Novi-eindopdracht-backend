package com.example.eidopdrachtnovi.repositories;

import com.example.eidopdrachtnovi.models.Project;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjectRepository extends JpaRepository<Project, Long> {
    List<Project> getAllProjectsByStudioMemberEqualsIgnoreCase(String studioMember);
}
