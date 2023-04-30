package com.example.eidopdrachtnovi.controllers;

import com.example.eidopdrachtnovi.dtos.BrandguideDto;
import com.example.eidopdrachtnovi.services.BrandguideService;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;
import java.util.Objects;

@RestController
@CrossOrigin
public class BrandguideController {
    private final BrandguideService brandguideService;


    public BrandguideController(BrandguideService service) {
        this.brandguideService = service;
    }

    @PostMapping("/upload")
    BrandguideDto singleFileUpload(@RequestParam("brandguide") MultipartFile brandguide, @RequestParam("project") Long projectId) {

        String uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/download/").path(Objects.requireNonNull(brandguide.getOriginalFilename())).toUriString();

        String contentType = brandguide.getContentType();

        BrandguideDto brandguide1 = brandguideService.storeFile(brandguide, uri, projectId);

        return brandguide1;
    }


    @GetMapping("/download/{brandguide}")
    ResponseEntity<Resource> downLoadSingleFile(@PathVariable String brandguide, HttpServletRequest request) {

        Resource resource = brandguideService.downLoadFile(brandguide);
        String mimeType;

        try {
            mimeType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
        } catch (IOException e) {
            mimeType = MediaType.APPLICATION_OCTET_STREAM_VALUE;
        }
        return ResponseEntity.ok().contentType(MediaType.parseMediaType(mimeType)).header(HttpHeaders.CONTENT_DISPOSITION, "inline;brandguide=" + resource.getFilename()).body(resource);
    }


}
