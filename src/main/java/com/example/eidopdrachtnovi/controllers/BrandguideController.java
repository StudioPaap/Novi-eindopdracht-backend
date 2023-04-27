package com.example.eidopdrachtnovi.controllers;

import com.example.eidopdrachtnovi.models.Brandguide;
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

    //    post for single upload
    @PostMapping("/upload")
    Brandguide singleFileUpload(@RequestParam("brandguide") MultipartFile brandguide, @RequestParam("project")Long projectId){

        // next line makes url. example "http://localhost:8080/download/naam.jpg"
        String uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/download/").path(Objects.requireNonNull(brandguide.getOriginalFilename())).toUriString();

        String contentType = brandguide.getContentType();

        String brandguide1 = brandguideService.storeFile(brandguide, uri);

        return new Brandguide(brandguide1, contentType, uri );
    }

    //    get for single download
    @GetMapping("/download/{brandguide}")
    ResponseEntity<Resource> downLoadSingleFile(@PathVariable String brandguide, HttpServletRequest request) {

        Resource resource = brandguideService.downLoadFile(brandguide);

//        this mediaType decides witch type you accept if you only accept 1 type
//        MediaType contentType = MediaType.IMAGE_JPEG;
//        this is going to accept multiple types
        String mimeType;

        try{
            mimeType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
        } catch (IOException e) {
            mimeType = MediaType.APPLICATION_OCTET_STREAM_VALUE;
        }

//        for download attachment use next line
//        return ResponseEntity.ok().contentType(contentType).header(HttpHeaders.CONTENT_DISPOSITION, "attachment;fileName=" + resource.getFilename()).body(resource);
//        for showing image in browser
        return ResponseEntity.ok().contentType(MediaType.parseMediaType(mimeType)).header(HttpHeaders.CONTENT_DISPOSITION, "inline;brandguide=" + resource.getFilename()).body(resource);
    }



}
