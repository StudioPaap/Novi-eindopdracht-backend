package com.example.eidopdrachtnovi.controllers;

import com.example.eidopdrachtnovi.dtos.DeelOpdrachtPrintDto;
import com.example.eidopdrachtnovi.dtos.DeelOpdrachtPrintInputDto;
import com.example.eidopdrachtnovi.services.DeelOpdrachtPrintService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/deelopdrachtprint")
@RestController
public class DeelOpdrachtPrintController {


    private final DeelOpdrachtPrintService deelOpdrachtPrintService;



    public DeelOpdrachtPrintController(DeelOpdrachtPrintService deelOpdrachtPrintService) {
        this.deelOpdrachtPrintService = deelOpdrachtPrintService;
    }

    @GetMapping()
    public ResponseEntity<List<DeelOpdrachtPrintDto>> getAllDeelopdrachtenPrint() {

        List<DeelOpdrachtPrintDto> dtos;

        dtos = deelOpdrachtPrintService.getAllDeelopdrachtenPrint();

        return ResponseEntity.ok().body(dtos);
    }


    @GetMapping("/id")
    public ResponseEntity<DeelOpdrachtPrintDto> getDeelOpdrachtPrintById(@PathVariable("id")Long id) {

        DeelOpdrachtPrintDto deelOpdrachtPrintDto = deelOpdrachtPrintService.getDeelOpdrachtPrintById(id);

        return ResponseEntity.ok().body(deelOpdrachtPrintDto);

    }


    @PostMapping()
    public ResponseEntity<DeelOpdrachtPrintDto> addDeelOpdrachtPrint(@Valid @RequestBody DeelOpdrachtPrintInputDto deelOpdrachtPrintInputDto) {

        DeelOpdrachtPrintDto dto = deelOpdrachtPrintService.addDeelOpdrachtPrint(deelOpdrachtPrintInputDto);

        return ResponseEntity.created(null).body(dto);

    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteDeelOpdrachtPrint(@PathVariable Long id) {

        DeelOpdrachtPrintService.deleteDeelOpdrachtPrint(id);

        return ResponseEntity.noContent().build();

    }


    @PutMapping("/{id}")
    public ResponseEntity<DeelOpdrachtPrintDto> updateDeelOpdrachtPrint(@PathVariable Long id, @Valid @RequestBody DeelOpdrachtPrintInputDto newDeelOpdrachtPrint) {
        DeelOpdrachtPrintDto dto = deelOpdrachtPrintService.updateDeelOpdrachtPrint(id, newDeelOpdrachtPrint);

        return ResponseEntity.ok().body(dto);
    }

}