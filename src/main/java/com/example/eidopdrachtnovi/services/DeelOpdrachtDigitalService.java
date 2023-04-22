package com.example.eidopdrachtnovi.services;

import com.example.eidopdrachtnovi.dtos.*;
import com.example.eidopdrachtnovi.exceptions.RecordNotFoundException;
import com.example.eidopdrachtnovi.models.DeelOpdrachtDigital;
import com.example.eidopdrachtnovi.models.Project;
import com.example.eidopdrachtnovi.models.Status;
import com.example.eidopdrachtnovi.repositories.DeelOpdrachtDigitalRepository;
import com.example.eidopdrachtnovi.repositories.ProjectRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


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

    public DeelOpdrachtDigitalDto getDeelOpdrachtDigitalById(Long id) {
        Optional<DeelOpdrachtDigital> deelOpdrachtDigitalOptional = deelOpdrachtDigitalRepository.findById(id);
        if (deelOpdrachtDigitalOptional.isPresent()) {
            DeelOpdrachtDigital dod = deelOpdrachtDigitalOptional.get();
            return transferToDto(dod);
        } else {
            throw new RecordNotFoundException("geen deelopdracht gevonden");
        }
    }


    public DeelOpdrachtDigitalDto addDeelOpdrachtDigital(DeelOpdrachtDigitalInputDto dto) {

        DeelOpdrachtDigital dod = transferToDeelopdrachtDigital(dto);
        deelOpdrachtDigitalRepository.save(dod);



        return transferToDto(dod);
    }

    public void deleteDeelOpdrachtDigital(@RequestBody Long id) {

        deelOpdrachtDigitalRepository.deleteById(id);

    }

    public DeelOpdrachtDigitalDto updateDeelOpdrachtDigital(Long id, DeelOpdrachtDigitalInputDto newDeelopdrachtDigital) {

        Optional<DeelOpdrachtDigital> DeelOpdrachtDigitalOptional = deelOpdrachtDigitalRepository.findById(id);
        if (DeelOpdrachtDigitalOptional.isPresent()) {

            DeelOpdrachtDigital deelOpdrachtDigital1 = DeelOpdrachtDigitalOptional.get();


            deelOpdrachtDigital1.setName(newDeelopdrachtDigital.getName());
            deelOpdrachtDigital1.setKopij(newDeelopdrachtDigital.getKopij());
            deelOpdrachtDigital1.setDeadlineFirstVersion(newDeelopdrachtDigital.getDeadlineFirstVersion());
            deelOpdrachtDigital1.setDeadlineSecVersion(newDeelopdrachtDigital.getDeadlineSecVersion());
            deelOpdrachtDigital1.setDeadlineDef(newDeelopdrachtDigital.getDeadlineDef());
            deelOpdrachtDigital1.setFeedback(newDeelopdrachtDigital.getFeedback());
            deelOpdrachtDigital1.setSizePX(newDeelopdrachtDigital.getSizePX());
            deelOpdrachtDigital1.setAnimation(newDeelopdrachtDigital.isAnimation());
            deelOpdrachtDigital1.setFileFormat(newDeelopdrachtDigital.getFileFormat());

            ;

            DeelOpdrachtDigital returnDeelopdrachtDigital = deelOpdrachtDigitalRepository.save(deelOpdrachtDigital1);

            return transferToDto(returnDeelopdrachtDigital);

        } else {

            throw new RecordNotFoundException("geen Deelopdracht gevonden");

        }

    }

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


    public DeelOpdrachtDigitalDto transferToDto(DeelOpdrachtDigital deelOpdrachtDigital) {
        DeelOpdrachtDigitalDto dto = new DeelOpdrachtDigitalDto();

        dto.setName(deelOpdrachtDigital.getName());
        dto.setKopij(deelOpdrachtDigital.getKopij());
        dto.setDeadlineFirstVersion(deelOpdrachtDigital.getDeadlineFirstVersion());
        dto.setDeadlineSecVersion(deelOpdrachtDigital.getDeadlineSecVersion());
        dto.setDeadlineDef(deelOpdrachtDigital.getDeadlineDef());
        dto.setFeedback(deelOpdrachtDigital.getFeedback());
        dto.setSizePX(deelOpdrachtDigital.getSizePX());
        dto.setFileFormat(deelOpdrachtDigital.getFileFormat());
        dto.setAnimation(deelOpdrachtDigital.isAnimation());


        return dto;
    }

}
