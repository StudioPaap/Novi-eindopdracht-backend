
package com.example.eidopdrachtnovi.controllers;

import com.example.eidopdrachtnovi.dtos.PrintshopDto;
import com.example.eidopdrachtnovi.models.Printshop;
import com.example.eidopdrachtnovi.services.PrintshopService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/Printshop")
public class PrintshopController {

    private final PrintshopService printshopService;

    public PrintshopController(PrintshopService printshopService) {
        this.printshopService = printshopService;
    }

    @PostMapping
    public ResponseEntity<PrintshopDto> createPrinter(@RequestBody PrintshopDto pdto){
        Printshop id = printshopService.createPrintshop(pdto);
        pdto.id = id;
        URI uri = URI.create(ServletUriComponentsBuilder
                .fromCurrentRequest().path("/"+ id).toUriString());

        return ResponseEntity.created(uri).body(pdto);

    }

    @GetMapping("/{id}")
    public ResponseEntity<Printshop> getPrintshopById(@PathVariable("id") Long id) {

        Printshop printshop = printshopService.getPrintshopById(id);

        return ResponseEntity.ok().body(printshop);

    }
    @GetMapping()
    public ResponseEntity<List<PrintshopDto>> getAllPrintshops() {
        List<PrintshopDto> printshops = printshopService.getAllPrintshops();

        return ResponseEntity.ok().body(printshops);
    }

    @PutMapping("{id}")
    public ResponseEntity<Printshop> changePrintshop(@PathVariable Long id, @RequestBody PrintshopDto dto) {
        Printshop printshop = printshopService.changePrintshop(id, dto);
        return ResponseEntity.ok().body(printshop);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePrintshop(@PathVariable Long id) {
        printshopService.deletePrintshop(id);
        return ResponseEntity.noContent().build();
    }
}
