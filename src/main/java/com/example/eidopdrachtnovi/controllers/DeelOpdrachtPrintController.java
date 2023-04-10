package com.example.eidopdrachtnovi.controllers;

import com.example.eidopdrachtnovi.dtos.DeelOpdrachtPrintDto;
import com.example.eidopdrachtnovi.dtos.DeelOpdrachtPrintInputDto;
import com.example.eidopdrachtnovi.services.DeelOpdrachtPrintService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class DeelOpdrachtPrintController {


    private final DeelOpdrachtPrintService deelOpdrachtPrintService;



    public DeelOpdrachtPrintController(DeelOpdrachtPrintService deelOpdrachtPrintService) {
        this.deelOpdrachtPrintService = deelOpdrachtPrintService;
    }

    @GetMapping("/projects/{id}/deelopdrachtprint")
    public ResponseEntity<List<DeelOpdrachtPrintDto>> getAllDeelopdrachtenPrint() {

        List<DeelOpdrachtPrintDto> dtos;

        dtos = deelOpdrachtPrintService.getAllDeelopdrachtenPrint();

        return ResponseEntity.ok().body(dtos);
    }

//    // De return waarde is ook hier een TelevisionDto in plaats van een Television
//    @GetMapping("/projects/{id}")
//    public ResponseEntity<ProjectDto> getProject(@PathVariable("id")Long id) {
//
//        ProjectDto project = deelOpdrachtPrintService.getProjectById(id);
//
//        return ResponseEntity.ok().body(project);
//
//    }


    @PostMapping("/deelopdrachtprint")
    public ResponseEntity<DeelOpdrachtPrintDto> addDeelOpdracht(@Valid @RequestBody DeelOpdrachtPrintInputDto deelOpdrachtPrintInputDto) {

        DeelOpdrachtPrintDto dto = deelOpdrachtPrintService.addDeelOpdrachtPrint(deelOpdrachtPrintInputDto);

        return ResponseEntity.created(null).body(dto);

    }


//    @DeleteMapping("/projects/{id}/deelopdracht/{id}")
//    public ResponseEntity<Object> deleteDeelOpdrachtPrint(@PathVariable Long id) {
//
//        DeelOpdrachtPrintService.deleteDeelOpdrachtPrint(id);
//
//        return ResponseEntity.noContent().build();
//
//    }

//
//    @PutMapping("/projects/{id}/deelopdracht/{id}")
//    public ResponseEntity<DeelOpdrachtPrintDto> updateDeelOpdrachtPrint(@PathVariable Long id, @Valid @RequestBody DeelOpdrachtPrintInputDto newDeelOpdrachtPrint) {
//        DeelOpdrachtPrintDto dto = deelOpdrachtPrintService.updateDeelOpdrachtPrint(id, newDeelOpdrachtPrint);
//
//        return ResponseEntity.ok().body(dto);
//    }

}