package com.example.eidopdrachtnovi.controllers;

import com.example.eidopdrachtnovi.dtos.DeelOpdrachtDigitalDto;
import com.example.eidopdrachtnovi.dtos.DeelOpdrachtDigitalInputDto;
import com.example.eidopdrachtnovi.services.DeelOpdrachtDigitalService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/deelopdracht")
    public class DeelOpdrachtDigitalController {


        private final DeelOpdrachtDigitalService deelOpdrachtDigitalService;



        public DeelOpdrachtDigitalController(DeelOpdrachtDigitalService deelOpdrachtDigitalService) {
            this.deelOpdrachtDigitalService = deelOpdrachtDigitalService;
        }

    @GetMapping("/")
        public ResponseEntity<List<DeelOpdrachtDigitalDto>> getAllDeelopdrachtenDigital() {

            List<DeelOpdrachtDigitalDto> dtos;

                dtos = deelOpdrachtDigitalService.getAllDeelopdrachtenDigital();

        return ResponseEntity.ok().body(dtos);
        }

//        // De return waarde is ook hier een TelevisionDto in plaats van een Television
//        @GetMapping("/projects/{id}")
//        public ResponseEntity<ProjectDto> getProject(@PathVariable("id")Long id) {
//
//            ProjectDto project = deelOpdrachtDigitalService.getProjectById(id);
//
//            return ResponseEntity.ok().body(project);
//
//        }


        @PostMapping()
        public ResponseEntity<DeelOpdrachtDigitalDto> addDeelOpdracht(@Valid @RequestBody DeelOpdrachtDigitalInputDto deelOpdrachtDigitalInputDto) {

            DeelOpdrachtDigitalDto dto = deelOpdrachtDigitalService.addDeelOpdrachtDigital(deelOpdrachtDigitalInputDto);

            return ResponseEntity.created(null).body(dto);

        }


//        @DeleteMapping("/projects/{id}/deelopdracht/{id}")
//        public ResponseEntity<Object> deleteDeelOpdrachtDigital(@PathVariable Long id) {
//
//            DeelOpdrachtDigitalService.deleteDeelOpdrachtDigital(id);
//
//            return ResponseEntity.noContent().build();
//
//        }

//
//        @PutMapping("/projects/{id}/deelopdracht/{id}")
//        public ResponseEntity<DeelOpdrachtDigitalDto> updateDeelOpdrachtDigital(@PathVariable Long id, @Valid @RequestBody DeelOpdrachtDigitalInputDto newDeelOpdrachtDigital) {
//            DeelOpdrachtDigitalDto dto = deelOpdrachtDigitalService.updateDeelOpdrachtDigital(id, newDeelOpdrachtDigital);
//
//            return ResponseEntity.ok().body(dto);
//        }

    }


