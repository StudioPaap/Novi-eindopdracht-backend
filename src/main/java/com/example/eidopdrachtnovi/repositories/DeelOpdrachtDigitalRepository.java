package com.example.eidopdrachtnovi.repositories;


import com.example.eidopdrachtnovi.models.DeelOpdrachtDigital;
import com.example.eidopdrachtnovi.models.Status;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DeelOpdrachtDigitalRepository extends JpaRepository<DeelOpdrachtDigital, Status> {

    List<DeelOpdrachtDigital> getAllDeelOpdrachtByStatus(Status status);
}

