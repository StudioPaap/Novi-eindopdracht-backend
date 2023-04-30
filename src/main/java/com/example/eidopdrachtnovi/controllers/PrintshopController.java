package com.example.eidopdrachtnovi.controllers;

import com.example.eidopdrachtnovi.dtos.PrintshopDto;
import com.example.eidopdrachtnovi.dtos.PrintshopInputDto;
import com.example.eidopdrachtnovi.services.PrintshopService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/printshop")
public class PrintshopController {


    private final PrintshopService printshopService;


    public PrintshopController(PrintshopService printshopService) {
        this.printshopService = printshopService;
    }

    @GetMapping()
    public ResponseEntity<List<PrintshopDto>> getAllprintshops() {

        List<PrintshopDto> dtos;

        dtos = printshopService.getAllprintshops();

        return ResponseEntity.ok().body(dtos);
    }


    @GetMapping("/{id}")
    public ResponseEntity<PrintshopDto> getPrintshopById(@PathVariable("id") Long id) {

        PrintshopDto printshop = printshopService.getPrintshopById(id);

        return ResponseEntity.ok().body(printshop);

    }


    @PostMapping()
    public ResponseEntity<PrintshopDto> addPrintshop(@Valid @RequestBody PrintshopInputDto printshopInputDto) {

        PrintshopDto dto = printshopService.addPrintshop(printshopInputDto);

        return ResponseEntity.created(null).body(dto);

    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletePrintshop(@PathVariable Long id) {

        printshopService.deletePrintshop(id);

        return ResponseEntity.noContent().build();

    }


    @PutMapping("/{id}")
    public ResponseEntity<PrintshopDto> updatePrintshop(@PathVariable Long id, @Valid @RequestBody PrintshopInputDto newPrintshop) {
        PrintshopDto dto = printshopService.updatePrintshop(id, newPrintshop);

        return ResponseEntity.ok().body(dto);
    }


}


