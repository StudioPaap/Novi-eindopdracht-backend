package com.example.eidopdrachtnovi.services;


import com.example.eidopdrachtnovi.dtos.BrandguideDto;
import com.example.eidopdrachtnovi.exceptions.RecordNotFoundException;
import com.example.eidopdrachtnovi.models.Brandguide;
import com.example.eidopdrachtnovi.models.Project;
import com.example.eidopdrachtnovi.repositories.BrandguideRepository;
import com.example.eidopdrachtnovi.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Objects;
import java.util.Optional;

@Service
public class BrandguideService {
    private final Path fileStoragePath;
    private final String fileStorageLocation;
    private final BrandguideRepository brandguideRepository;
    private final ProjectRepository projectRepository;

    public BrandguideService(@Value("upload") String fileStorageLocation, BrandguideRepository brandguideRepository, ProjectRepository projectRepository) {
        fileStoragePath = Paths.get(fileStorageLocation).toAbsolutePath().normalize();
        this.fileStorageLocation = fileStorageLocation;
        this.brandguideRepository = brandguideRepository;
        this.projectRepository = projectRepository;

        try {
            Files.createDirectories(fileStoragePath);
        } catch (IOException e) {
            throw new RuntimeException("Issue in creating file directory");
        }

    }

    public BrandguideDto storeFile(MultipartFile file, String uri, Long projectId) {

        String brandguidePath = StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename()));

        Path filePath = Paths.get(fileStoragePath + "/" + brandguidePath);
        Optional<Project> pj = projectRepository.findById(projectId);
        if (pj.isPresent()) {
            Project pop = pj.get();
            try {
                Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException e) {
                throw new RuntimeException("Issue in storing the file", e);
            }
            Brandguide temp = new Brandguide(brandguidePath, file.getContentType(), uri);
            temp.setProject(pop);
            Brandguide brandguide = brandguideRepository.save(temp);

            return tranfserToDto(brandguide);
        } else {
            throw new RecordNotFoundException("geen Project gevonden");
        }
    }


    public Resource downLoadFile(String brandguide) {

        Path path = Paths.get(fileStorageLocation).toAbsolutePath().resolve(brandguide);

        Resource resource;

        try {
            resource = new UrlResource(path.toUri());
        } catch (MalformedURLException e) {
            throw new RuntimeException("Issue in reading the file", e);
        }

        if (resource.exists() && resource.isReadable()) {
            return resource;
        } else {
            throw new RuntimeException("the file doesn't exist or not readable");
        }
    }


    public BrandguideDto tranfserToDto(Brandguide bg) {
        BrandguideDto dto = new BrandguideDto();
        dto.setBrandguide(bg.getBrandguide());
        dto.setContentType(bg.getContentType());
        dto.setUri(bg.getUri());
        dto.setProject(bg.getProject().getId());
        return dto;
    }

}

