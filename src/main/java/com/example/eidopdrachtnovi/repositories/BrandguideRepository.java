package com.example.eidopdrachtnovi.repositories;


import com.example.eidopdrachtnovi.models.Brandguide;

import org.springframework.data.jpa.repository.JpaRepository;



public interface BrandguideRepository extends JpaRepository<Brandguide, Long> {


//   BrandguideDto findBrandguideByProject(Optional<Project> project);
}
