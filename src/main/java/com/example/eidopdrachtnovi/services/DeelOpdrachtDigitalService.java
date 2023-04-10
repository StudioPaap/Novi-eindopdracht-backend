package com.example.eidopdrachtnovi.services;

import com.example.eidopdrachtnovi.dtos.*;
import com.example.eidopdrachtnovi.exceptions.RecordNotFoundException;
import com.example.eidopdrachtnovi.models.DeelOpdrachtDigital;
import com.example.eidopdrachtnovi.models.Status;
import com.example.eidopdrachtnovi.repositories.DeelOpdrachtDigitalRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class DeelOpdrachtDigitalService {

    private static DeelOpdrachtDigitalRepository deelOpdrachtDigitalRepository;

    public DeelOpdrachtDigitalService(DeelOpdrachtDigitalRepository deelOpdrachtDigitalRepository) {
        this.deelOpdrachtDigitalRepository = deelOpdrachtDigitalRepository;
    }


    public List<DeelOpdrachtDigitalDto> getAllDeelopdrachtenDigital() {
        List<DeelOpdrachtDigital> dodList = deelOpdrachtDigitalRepository.findAll();
        List<DeelOpdrachtDigitalDto> dodDtoList = new ArrayList<>();

        for (DeelOpdrachtDigital dod : dodList) {
            DeelOpdrachtDigitalDto dto = transferToDto(dod);
            dodDtoList.add(dto);
        }
        return dodDtoList;
    }

    public List<DeelOpdrachtDigitalDto> getAllDeelOpdrachtDigitalByStatus(Status status) {
        List<DeelOpdrachtDigital> dodList = deelOpdrachtDigitalRepository.getAllDeelOpdrachtByStatus(status);
        List<DeelOpdrachtDigitalDto> dodDtoList = new ArrayList<>();

        for (DeelOpdrachtDigital dod : dodList) {
            DeelOpdrachtDigitalDto dto = transferToDto(dod);
            dodDtoList.add(dto);
        }
        return dodDtoList;
    }

//    public DeelOpdrachtDigitalDto getDeelOpdrachtDigitalById(Long id) {
//        Optional<DeelOpdrachtDigital> deelOpdrachtDigitalOptional = deelOpdrachtDigitalRepository.findById(id);
//        if (deelOpdrachtDigitalOptional.isPresent()) {
//            DeelOpdrachtDigital dod = deelOpdrachtDigitalOptional.get();
//            return transferToDto(dod);
//        } else {
//            throw new RecordNotFoundException("geen deelopdracht gevonden");
//        }
//    }


    public DeelOpdrachtDigitalDto addDeelOpdrachtDigital(DeelOpdrachtDigitalInputDto dto) {

        DeelOpdrachtDigital dod = transferToDeelopdrachtDigital(dto);
        deelOpdrachtDigitalRepository.save(dod);

        return transferToDto(dod);
    }

//    public static void deleteDeelOpdrachtDigital(@RequestBody Long id) {
//
//        deelOpdrachtDigitalRepository.deleteById(id);
//
//    }

//    public DeelOpdrachtDigitalDto updateDeelOpdrachtDigital(Long id, DeelOpdrachtDigitalInputDto newDeelopdrachtDigital) {
//
//        Optional<DeelOpdrachtDigital> DeelOpdrachtDigitalOptional = deelOpdrachtDigitalRepository.findById(id);
//        if (DeelOpdrachtDigitalOptional.isPresent()) {
//
//            DeelOpdrachtDigital deelOpdrachtDigital1 = DeelOpdrachtDigitalOptional.get();
//
//
//            deelOpdrachtDigital1.setName(newDeelopdrachtDigital.getName());
//            deelOpdrachtDigital1.setKopij(newDeelopdrachtDigital.getKopij());
//            deelOpdrachtDigital1.setDeadlineFirstVersion(newDeelopdrachtDigital.getDeadlineFirstVersion());
//            deelOpdrachtDigital1.setDeadlineSecVersion(newDeelopdrachtDigital.getDeadlineSecVersion());
//            deelOpdrachtDigital1.setDeadlineDef(newDeelopdrachtDigital.getDeadlineDef());
//            deelOpdrachtDigital1.setFeedback(newDeelopdrachtDigital.getFeedback());
//            deelOpdrachtDigital1.setSizePX(newDeelopdrachtDigital.getSizePX());
//            deelOpdrachtDigital1.setFileFormat(newDeelopdrachtDigital.getFileFormat());
//            deelOpdrachtDigital1.setAnimation(newDeelopdrachtDigital.isAnimation());
//            ;
//
//            DeelOpdrachtDigital returnDeelopdrachtDigital = deelOpdrachtDigitalRepository.save(deelOpdrachtDigital1);
//
//            return transferToDto(returnDeelopdrachtDigital);
//
//        } else {
//
//            throw new RecordNotFoundException("geen Deelopdracht gevonden");
//
//        }
//
//    }

    // Dit is de vertaal methode van DeelOpdrachtDigitalInputDto naar DeelopdrachtDigital.
    public DeelOpdrachtDigital transferToDeelopdrachtDigital(DeelOpdrachtDigitalInputDto dto) {
        var deelOpdrachtDigital = new DeelOpdrachtDigital();

        deelOpdrachtDigital.setName(dto.getName());
        deelOpdrachtDigital.setKopij(dto.getKopij());
        deelOpdrachtDigital.setDeadlineFirstVersion(dto.getDeadlineFirstVersion());
        deelOpdrachtDigital.setDeadlineSecVersion(dto.getDeadlineSecVersion());
        deelOpdrachtDigital.setDeadlineDef(dto.getDeadlineDef());
        deelOpdrachtDigital.setFeedback(dto.getFeedback());
        deelOpdrachtDigital.setSizePX(dto.getSizePX());
        deelOpdrachtDigital.setFileFormat(dto.getFileFormat());
        deelOpdrachtDigital.setAnimation(dto.isAnimation());


        return deelOpdrachtDigital;
    }

    // Dit is de vertaal methode van DeelOpdrachtDigital naar DeelOpdrachtDigitalDto
    public DeelOpdrachtDigitalDto transferToDto(DeelOpdrachtDigital deelOpdrachtDigital) {
        DeelOpdrachtDigitalDto dto = new DeelOpdrachtDigitalDto();

        dto.setName(dto.getName());
        dto.setKopij(dto.getKopij());
        dto.setDeadlineFirstVersion(dto.getDeadlineFirstVersion());
        dto.setDeadlineSecVersion(dto.getDeadlineSecVersion());
        dto.setDeadlineDef(dto.getDeadlineDef());
        dto.setFeedback(dto.getFeedback());
        dto.setSizePX(dto.getSizePX());
        dto.setFileFormat(dto.getFileFormat());
        dto.setAnimation(dto.isAnimation());

        return dto;
    }
}
