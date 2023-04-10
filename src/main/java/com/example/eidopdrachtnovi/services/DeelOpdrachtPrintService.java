package com.example.eidopdrachtnovi.services;

import com.example.eidopdrachtnovi.dtos.*;
import com.example.eidopdrachtnovi.exceptions.RecordNotFoundException;
import com.example.eidopdrachtnovi.models.DeelOpdrachtPrint;
import com.example.eidopdrachtnovi.models.Status;
import com.example.eidopdrachtnovi.repositories.DeelOpdrachtPrintRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class DeelOpdrachtPrintService {

    private static DeelOpdrachtPrintRepository deelOpdrachtPrintRepository;

    public DeelOpdrachtPrintService(DeelOpdrachtPrintRepository deelOpdrachtPrintRepository) {
        this.deelOpdrachtPrintRepository = deelOpdrachtPrintRepository;
    }


    public List<DeelOpdrachtPrintDto> getAllDeelopdrachtenPrint() {
        List<DeelOpdrachtPrint> dopList = deelOpdrachtPrintRepository.findAll();
        List<DeelOpdrachtPrintDto> dopDtoList = new ArrayList<>();

        for (DeelOpdrachtPrint dop : dopList) {
            DeelOpdrachtPrintDto dto = transferToDto(dop);
            dopDtoList.add(dto);
        }
        return dopDtoList;
    }

    public List<DeelOpdrachtPrintDto> getAllDeelOpdrachtPrintByStatus(Status status) {
        List<DeelOpdrachtPrint> dopList = deelOpdrachtPrintRepository.getAllDeelOpdrachtByStatus(status);
        List<DeelOpdrachtPrintDto> dopDtoList = new ArrayList<>();

        for (DeelOpdrachtPrint dop : dopList) {
            DeelOpdrachtPrintDto dto = transferToDto(dop);
            dopDtoList.add(dto);
        }
        return dopDtoList;
    }

//    public DeelOpdrachtPrintDto getDeelOpdrachtPrintById(Long id) {
//        Optional<DeelOpdrachtPrint> deelOpdrachtPrintOptional = deelOpdrachtPrintRepository.findById(id);
//        if (deelOpdrachtPrintOptional.isPresent()) {
//            DeelOpdrachtPrint dop = deelOpdrachtPrintOptional.get();
//            return transferToDto(dop);
//        } else {
//            throw new RecordNotFoundException("geen deelopdracht gevonden");
//        }
//    }


    public DeelOpdrachtPrintDto addDeelOpdrachtPrint(DeelOpdrachtPrintInputDto dto) {

        DeelOpdrachtPrint dop = transferToDeelopdrachtPrint(dto);
        deelOpdrachtPrintRepository.save(dop);

        return transferToDto(dop);
    }

//    public static void deleteDeelOpdrachtPrint(@RequestBody Long id) {
//
//        deelOpdrachtPrintRepository.deleteById(id);
//
//    }

//    public DeelOpdrachtPrintDto updateDeelOpdrachtPrint(Long id, DeelOpdrachtPrintInputDto newDeelopdrachtPrint) {
//
//        Optional<DeelOpdrachtPrint> DeelOpdrachtPrintOptional = deelOpdrachtPrintRepository.findById(id);
//        if (DeelOpdrachtPrintOptional.isPresent()) {
//
//            DeelOpdrachtPrint deelOpdrachtPrint1 = DeelOpdrachtPrintOptional.get();
// deelOpdrachtPrint1.setName(newDeelopdrachtPrint.getName());
// deelOpdrachtPrint1.setKopij(newDeelopdrachtPrint.getKopij());
// deelOpdrachtPrint1.setDeadlineFirstVersion(newDeelopdrachtPrint.getDeadlineFirstVersion());
// deelOpdrachtPrint1.setDeadlineSecVersion(newDeelopdrachtPrint.getDeadlineSecVersion());
// deelOpdrachtPrint1.setDeadlineDef(newDeelopdrachtPrint.getDeadlineDef());
// deelOpdrachtPrint1.setFeedback(newDeelopdrachtPrint.getFeedback());
// deelOpdrachtPrint1.setSizePX(newDeelopdrachtPrint.getSizePX());
// deelOpdrachtPrint1.setFileFormat(newDeelopdrachtPrint.getFileFormat());
// deelOpdrachtPrint1.setAnimation(newDeelopdrachtPrint.isAnimation());
// ;
//
// DeelOpdrachtPrint returnDeelopdrachtPrint = deelOpdrachtPrintRepository.save(deelOpdrachtPrint1);
//
// return transferToDto(returnDeelopdrachtPrint);
//
// } else {
//
// throw new RecordNotFoundException("geen Deelopdracht gevonden");
//
// }
//
// }

    // Dit is de vertaal methode van DeelOpdrachtPrintInputDto naar DeelOpdrachtPrint.
    public DeelOpdrachtPrint transferToDeelopdrachtPrint(DeelOpdrachtPrintInputDto dto) {
        var deelOpdrachtPrint = new DeelOpdrachtPrint();

        deelOpdrachtPrint.setName(dto.getName());
        deelOpdrachtPrint.setKopij(dto.getKopij());
        deelOpdrachtPrint.setDeadlineFirstVersion(dto.getDeadlineFirstVersion());
        deelOpdrachtPrint.setDeadlineSecVersion(dto.getDeadlineSecVersion());
        deelOpdrachtPrint.setDeadlineDef(dto.getDeadlineDef());
        deelOpdrachtPrint.setFeedback(dto.getFeedback());
        deelOpdrachtPrint.setSizeWidthMM(dto.getSizeWidthMM());
        deelOpdrachtPrint.setSizeLengthMM(dto.getSizeLengthMM());
        deelOpdrachtPrint.setBleed(dto.getBleed());
        deelOpdrachtPrint.setCutLines(dto.isCutLines());
        deelOpdrachtPrint.setPrinter(dto.getPrinter());



        return deelOpdrachtPrint;
    }

    // Dit is de vertaal methode van DeelOpdrachtPrint naar DeelOpdrachtPrintDto
    public DeelOpdrachtPrintDto transferToDto(DeelOpdrachtPrint deelOpdrachtPrint) {
        DeelOpdrachtPrintDto dto = new DeelOpdrachtPrintDto();

        dto.setName(dto.getName());
        dto.setKopij(dto.getKopij());
        dto.setDeadlineFirstVersion(dto.getDeadlineFirstVersion());
        dto.setDeadlineSecVersion(dto.getDeadlineSecVersion());
        dto.setDeadlineDef(dto.getDeadlineDef());
        dto.setFeedback(dto.getFeedback());
        dto.setSizeWidthMM(dto.getSizeWidthMM());
        dto.setSizeLengthMM(dto.getSizeLengthMM());
        dto.setBleed(dto.getBleed());
        dto.setCutLines(dto.isCutLines());
        dto.setPrinter(dto.getPrinter());
        return dto;
    }
}