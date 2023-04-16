package com.example.eidopdrachtnovi.services;

import com.example.eidopdrachtnovi.dtos.*;
import com.example.eidopdrachtnovi.models.DeelOpdrachtDigital;
import com.example.eidopdrachtnovi.models.Project;
import com.example.eidopdrachtnovi.models.Status;
import com.example.eidopdrachtnovi.repositories.DeelOpdrachtDigitalRepository;
import com.example.eidopdrachtnovi.repositories.ProjectRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class DeelOpdrachtDigitalService {

    private final DeelOpdrachtDigitalRepository deelOpdrachtDigitalRepository;
    private final ProjectRepository projectRepository;

    public DeelOpdrachtDigitalService(DeelOpdrachtDigitalRepository deelOpdrachtDigitalRepository, ProjectRepository projectRepository) {
        this.deelOpdrachtDigitalRepository = deelOpdrachtDigitalRepository;
        this.projectRepository = projectRepository;
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
        Project project = projectRepository.findById(dto.projectId).get();
        deelOpdrachtDigital.setProject(project);


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
