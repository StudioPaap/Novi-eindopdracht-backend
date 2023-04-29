package com.example.eidopdrachtnovi.repositories;


import com.example.eidopdrachtnovi.models.DeelOpdrachtDigital;
import com.example.eidopdrachtnovi.models.Project;
import com.example.eidopdrachtnovi.models.Status;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DeelOpdrachtDigitalRepository extends JpaRepository<DeelOpdrachtDigital, Long> {

    List<DeelOpdrachtDigital> findDeelOpdrachtDigitalByStatus(Status status);
    List<DeelOpdrachtDigital>findDeelOpdrachtDigitalByName(String name);

    List<DeelOpdrachtDigital>findDeelOpdrachtDigitalByProject(Optional<Project> project);

}

