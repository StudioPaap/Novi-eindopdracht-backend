package com.example.eidopdrachtnovi.repositories;

import com.example.eidopdrachtnovi.models.DeelOpdracht;
import com.example.eidopdrachtnovi.models.DeelOpdrachtDigital;
import com.example.eidopdrachtnovi.models.DeelOpdrachtPrint;
import com.example.eidopdrachtnovi.models.Status;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;



public interface DeelOpdrachtRepository extends JpaRepository<DeelOpdracht, Status> {

        List<DeelOpdracht> getAllDeelOpdrachtByStatus(Status status);
    }


