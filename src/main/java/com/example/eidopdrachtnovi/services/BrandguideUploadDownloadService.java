package com.example.eidopdrachtnovi.services;


import com.example.eidopdrachtnovi.models.BrandguideUploadResponse;
import com.example.eidopdrachtnovi.repositories.BrandguideUploadDownloadRepository;
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

@Service
public class BrandguideUploadDownloadService {
    private final Path fileStoragePath;
    private final String fileStorageLocation;
    private final BrandguideUploadDownloadRepository repo;

    public BrandguideUploadDownloadService(@Value("upload") String fileStorageLocation, BrandguideUploadDownloadRepository repo) {
        fileStoragePath = Paths.get(fileStorageLocation).toAbsolutePath().normalize();
        this.fileStorageLocation = fileStorageLocation;
        this.repo = repo;

        try {
            Files.createDirectories(fileStoragePath);
        } catch (IOException e) {
            throw new RuntimeException("Issue in creating file directory");
        }

    }

    public String storeFile(MultipartFile file, String uri) {

        String brandguide = StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename()));

        Path filePath = Paths.get(fileStoragePath + "/" + brandguide);

        try {
            Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            throw new RuntimeException("Issue in storing the file", e);
        }

        repo.save(new BrandguideUploadResponse(brandguide, file.getContentType(), uri));

        return brandguide;
    }

    public Resource downLoadFile(String brandguide) {

        Path path = Paths.get(fileStorageLocation).toAbsolutePath().resolve(brandguide);

        Resource resource;

        try {
            resource = new UrlResource(path.toUri());
        } catch (MalformedURLException e) {
            throw new RuntimeException("Issue in reading the file", e);
        }

        if(resource.exists()&& resource.isReadable()) {
            return resource;
        } else {
            throw new RuntimeException("the file doesn't exist or not readable");
        }
    }

}

