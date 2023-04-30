package com.example.eidopdrachtnovi.services;

import com.example.eidopdrachtnovi.dtos.PrintshopDto;

import com.example.eidopdrachtnovi.dtos.PrintshopInputDto;
import com.example.eidopdrachtnovi.exceptions.RecordNotFoundException;
import com.example.eidopdrachtnovi.models.Printshop;
import com.example.eidopdrachtnovi.repositories.PrintshopRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class PrintshopService {

    private final PrintshopRepository printshopRepository;


    public PrintshopService(PrintshopRepository printshopRepository) {
        this.printshopRepository = printshopRepository;
    }


    public List<PrintshopDto> getAllprintshops() {
        List<Printshop> dopList = printshopRepository.findAll();
        List<PrintshopDto> dopDtoList = new ArrayList<>();

        for (Printshop dop : dopList) {
            PrintshopDto dto = transferToDto(dop);
            dopDtoList.add(dto);
        }
        return dopDtoList;
    }


    public PrintshopDto getPrintshopById(Long id) {
        Optional<Printshop> printshopOptional = printshopRepository.findById(id);
        if (printshopOptional.isPresent()) {
            Printshop dop = printshopOptional.get();
            return transferToDto(dop);
        } else {
            throw new RecordNotFoundException("geen printshop gevonden");
        }
    }


    public PrintshopDto addPrintshop(PrintshopInputDto dto) {

        Printshop dop = transferToPrintshop(dto);
        printshopRepository.save(dop);

        return transferToDto(dop);
    }

    public void deletePrintshop(@RequestBody Long id) {

        printshopRepository.deleteById(id);

    }

    public PrintshopDto updatePrintshop(Long id, PrintshopInputDto newPrinsthop) {

        Optional<Printshop> PrintshopOptional = printshopRepository.findById(id);
        if (PrintshopOptional.isPresent()) {

            Printshop printshop1 = PrintshopOptional.get();
            printshop1.setName(newPrinsthop.getName());
            printshop1.setAdress(newPrinsthop.getAdress());
            printshop1.setEmail(newPrinsthop.getEmail());
            printshop1.setPhonenumber(newPrinsthop.getPhonenumber());


            Printshop returnPrintshop = printshopRepository.save(printshop1);

            return transferToDto(returnPrintshop);

        } else {

            throw new RecordNotFoundException("geen Printshop gevonden");

        }

    }

    public Printshop transferToPrintshop(PrintshopInputDto dto) {
        var printshop = new Printshop();

        printshop.setName(dto.getName());
        printshop.setAdress(dto.getAdress());
        printshop.setEmail(dto.getEmail());
        printshop.setPhonenumber(dto.getPhonenumber());

        return printshop;
    }

    public PrintshopDto transferToDto(Printshop printshop) {
        PrintshopDto dto = new PrintshopDto();
        dto.setId(printshop.getId());
        dto.setName(printshop.getName());
        dto.setAdress(printshop.getAdress());
        dto.setEmail(printshop.getEmail());
        dto.setPhonenumber(printshop.getPhonenumber());
        return dto;
    }
}

