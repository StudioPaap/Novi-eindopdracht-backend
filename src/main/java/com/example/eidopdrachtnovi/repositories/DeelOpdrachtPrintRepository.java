package com.example.eidopdrachtnovi.repositories;


import com.example.eidopdrachtnovi.models.DeelOpdrachtPrint;
import com.example.eidopdrachtnovi.models.Project;
import com.example.eidopdrachtnovi.models.Status;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DeelOpdrachtPrintRepository extends JpaRepository<DeelOpdrachtPrint, Long> {

    List<DeelOpdrachtPrint> findDeelOpdrachtPrintByStatus(Status status);

    List<DeelOpdrachtPrint> findDeelOpdrachtPrintByProject(Optional<Project> project);
}

