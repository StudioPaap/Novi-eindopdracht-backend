package com.example.eidopdrachtnovi.controllers;

import com.example.eidopdrachtnovi.dtos.DeelOpdrachtDigitalDto;
import com.example.eidopdrachtnovi.dtos.DeelOpdrachtDigitalInputDto;
import com.example.eidopdrachtnovi.models.DeelOpdrachtDigital;
import com.example.eidopdrachtnovi.models.Status;
import com.example.eidopdrachtnovi.services.DeelOpdrachtDigitalService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/deelopdrachtdigital")
    public class DeelOpdrachtDigitalController {


        private final DeelOpdrachtDigitalService deelOpdrachtDigitalService;



        public DeelOpdrachtDigitalController(DeelOpdrachtDigitalService deelOpdrachtDigitalService) {
            this.deelOpdrachtDigitalService = deelOpdrachtDigitalService;
        }

    @GetMapping()
        public ResponseEntity<List<DeelOpdrachtDigitalDto>> getAllDeelopdrachtenDigital() {

            List<DeelOpdrachtDigitalDto> dtos;

                dtos = deelOpdrachtDigitalService.getAllDeelopdrachtenDigital();

        return ResponseEntity.ok().body(dtos);
        }


        @GetMapping("/{id}")
        public ResponseEntity<DeelOpdrachtDigitalDto> getDeelOpdrachtDigitalById(@PathVariable("id")Long id) {

            DeelOpdrachtDigitalDto deelOpdrachtDigital = deelOpdrachtDigitalService.getDeelOpdrachtDigitalById(id);

            return ResponseEntity.ok().body(deelOpdrachtDigital);

        }

    @GetMapping("/{status}")
    public ResponseEntity<DeelOpdrachtDigitalDto> getDeelOpdrachtDigitalByStatus(@PathVariable("status") Status status) {
        DeelOpdrachtDigitalDto deelOpdrachtDigital = (DeelOpdrachtDigitalDto) deelOpdrachtDigitalService.getDeelOpdrachtDigitalByStatus(status);
        return ResponseEntity.ok().body(deelOpdrachtDigital);
    }


        @PostMapping()
        public ResponseEntity<DeelOpdrachtDigitalDto> addDeelOpdrachtDigital(@Valid @RequestBody DeelOpdrachtDigitalInputDto deelOpdrachtDigitalInputDto) {

            DeelOpdrachtDigitalDto dto = deelOpdrachtDigitalService.addDeelOpdrachtDigital(deelOpdrachtDigitalInputDto);

            return ResponseEntity.created(null).body(dto);

        }


        @DeleteMapping("/{id}")
        public ResponseEntity<Object> deleteDeelOpdrachtDigital(@PathVariable Long id) {

            deelOpdrachtDigitalService.deleteDeelOpdrachtDigital(id);

            return ResponseEntity.noContent().build();

        }


        @PutMapping("/{id}")
        public ResponseEntity<DeelOpdrachtDigitalDto> updateDeelOpdrachtDigital(@PathVariable Long id, @Valid @RequestBody DeelOpdrachtDigitalInputDto newDeelOpdrachtDigital) {
            DeelOpdrachtDigitalDto dto = deelOpdrachtDigitalService.updateDeelOpdrachtDigital(id, newDeelOpdrachtDigital);

            return ResponseEntity.ok().body(dto);
        }

    @PutMapping("/{id}/status")
    public ResponseEntity<DeelOpdrachtDigitalDto> updateDeelOpdrachtDigitalStatus(@PathVariable Long id, @Valid @RequestBody DeelOpdrachtDigitalInputDto newDeelOpdrachtDigital) {
        DeelOpdrachtDigitalDto dto = deelOpdrachtDigitalService.updateDeelOpdrachtDigitalStatus(id, newDeelOpdrachtDigital);

        return ResponseEntity.ok().body(dto);
    }


}


