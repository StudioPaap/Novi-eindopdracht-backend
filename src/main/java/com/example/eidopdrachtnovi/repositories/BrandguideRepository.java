package com.example.eidopdrachtnovi.repositories;

import com.example.eidopdrachtnovi.models.Brandguide;
import com.example.eidopdrachtnovi.models.Printshop;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BrandguideRepository extends JpaRepository<Brandguide, Long> {
    
}
