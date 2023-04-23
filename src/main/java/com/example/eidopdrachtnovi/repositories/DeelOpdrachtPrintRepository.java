package com.example.eidopdrachtnovi.repositories;


import com.example.eidopdrachtnovi.models.DeelOpdrachtPrint;
import com.example.eidopdrachtnovi.models.Status;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DeelOpdrachtPrintRepository extends JpaRepository<DeelOpdrachtPrint, Long> {

    List<DeelOpdrachtPrint> getAllDeelOpdrachtByStatus(Status status);
}

