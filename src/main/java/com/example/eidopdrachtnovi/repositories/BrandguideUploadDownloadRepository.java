package com.example.eidopdrachtnovi.repositories;

import com.example.eidopdrachtnovi.models.BrandguideUploadResponse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BrandguideUploadDownloadRepository extends JpaRepository<BrandguideUploadResponse, String> {

}
