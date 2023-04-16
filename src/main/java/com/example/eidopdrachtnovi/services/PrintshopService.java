package com.example.eidopdrachtnovi.services;

import com.example.eidopdrachtnovi.dtos.PrintshopDto;
import com.example.eidopdrachtnovi.dtos.ProjectDto;
import com.example.eidopdrachtnovi.exceptions.RecordNotFoundException;
import com.example.eidopdrachtnovi.models.Printshop;
import com.example.eidopdrachtnovi.models.Project;
import com.example.eidopdrachtnovi.repositories.PrintshopRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PrintshopService {

    private final PrintshopRepository printshopRepository;

    public PrintshopService(PrintshopRepository printshopRepository) {
        this.printshopRepository = printshopRepository;
    }

    public Printshop createPrintshop(PrintshopDto dto) {

        // Check of de dto-waarden niet null zijn voordat ze worden gebruikt
        if(dto.getName() == null || dto.getAdress() == null || dto.getEmail() == null || dto.getPhonenumber() == null) {
            throw new IllegalArgumentException("Niet alle velden zijn ingevuld");
        }

        // Mapping
        Printshop printer1 = new Printshop();
        printer1.setName(dto.getName());
        printer1.setAdress(dto.getAdress());
        printer1.setEmail(dto.getEmail());
        printer1.setPhonenumber(dto.getPhonenumber());
        printer1.setDeelOpdrachtPrint(dto.getDeelOpdrachtPrint());
        printshopRepository.save(printer1);

        return printer1;
    }

    public Printshop getPrintshopById(Long id) {
        Optional<Printshop> printshopOptional = printshopRepository.findById(id);
        if (printshopOptional.isPresent()) {
            Printshop ps = printshopOptional.get();
            return ps;
        } else {
            throw new RecordNotFoundException("geen Printshop gevonden");
        }
    }

    public List<PrintshopDto> getAllPrintshops() {
        List<Printshop> printshops = printshopRepository.findAll();
        List<PrintshopDto> printshopDtos = new ArrayList<>();

        for (Printshop printshop : printshops) {
            PrintshopDto printshopDto = new PrintshopDto();
            printshopDto.setName(printshop.getName());
            printshopDto.setAdress(printshop.getAdress());
            printshopDto.setEmail(printshop.getEmail());
            printshopDto.setPhonenumber(printshop.getPhonenumber());
            printshopDto.setDeelOpdrachtPrint(printshop.getDeelOpdrachtPrint());
            printshopDtos.add(printshopDto);
        }

        return printshopDtos;
    }

    public Printshop changePrintshop(Long id, PrintshopDto dto) {
        Optional<Printshop> optionalPrintshop = printshopRepository.findById(id);

        if (!optionalPrintshop.isPresent()) {
            throw new RecordNotFoundException("Printshop with id " + id + " not found.");
        }

        Printshop printshop = optionalPrintshop.get();
        printshop.setName(dto.getName());
        printshop.setAdress(dto.getAdress());
        printshop.setEmail(dto.getEmail());
        printshop.setPhonenumber(dto.getPhonenumber());
        printshop.setDeelOpdrachtPrint(dto.getDeelOpdrachtPrint());

        return printshopRepository.save(printshop);
    }

    public void deletePrintshop(Long id) {
        Optional<Printshop> optionalPrintshop = printshopRepository.findById(id);

        if (!optionalPrintshop.isPresent()) {
            throw new RecordNotFoundException("Printshop with id " + id + " not found.");
        }

        printshopRepository.delete(optionalPrintshop.get());
    }

    }


