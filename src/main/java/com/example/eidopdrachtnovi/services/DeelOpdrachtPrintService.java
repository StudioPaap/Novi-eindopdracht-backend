package com.example.eidopdrachtnovi.services;

import com.example.eidopdrachtnovi.dtos.*;
import com.example.eidopdrachtnovi.exceptions.RecordNotFoundException;
import com.example.eidopdrachtnovi.models.*;
import com.example.eidopdrachtnovi.repositories.DeelOpdrachtPrintRepository;
import com.example.eidopdrachtnovi.repositories.PrintshopRepository;
import com.example.eidopdrachtnovi.repositories.ProjectRepository;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class DeelOpdrachtPrintService {

    private static DeelOpdrachtPrintRepository deelOpdrachtPrintRepository;
    private final ProjectRepository projectRepository;
    private PrintshopRepository printshopRepository;

    public DeelOpdrachtPrintService(DeelOpdrachtPrintRepository deelOpdrachtPrintRepository, ProjectRepository projectRepository, PrintshopRepository printshopRepository) {
        this.deelOpdrachtPrintRepository = deelOpdrachtPrintRepository;
        this.printshopRepository = printshopRepository;
        this.projectRepository = projectRepository;
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

//    public List<DeelOpdrachtPrintDto> getAllDeelOpdrachtPrintByStatus(Status status) {
//        List<DeelOpdrachtPrint> dopList = deelOpdrachtPrintRepository.getAllDeelOpdrachtByStatus(status);
//        List<DeelOpdrachtPrintDto> dopDtoList = new ArrayList<>();
//
//        for (DeelOpdrachtPrint dop : dopList) {
//            DeelOpdrachtPrintDto dto = transferToDto(dop);
//            dopDtoList.add(dto);
//        }
//        return dopDtoList;
//    }

    public DeelOpdrachtPrintDto getDeelOpdrachtPrintById(Long id) {
        Optional<DeelOpdrachtPrint> deelOpdrachtPrintOptional = deelOpdrachtPrintRepository.findById(id);
        if (deelOpdrachtPrintOptional.isPresent()) {
            DeelOpdrachtPrint dop = deelOpdrachtPrintOptional.get();
            return transferToDto(dop);
        } else {
            throw new RecordNotFoundException("geen deelopdracht gevonden");
        }
    }




    public DeelOpdrachtPrintDto addDeelOpdrachtPrint(DeelOpdrachtPrintInputDto dto) {

        DeelOpdrachtPrint dop = transferToDeelopdrachtPrint(dto);
        deelOpdrachtPrintRepository.save(dop);

        return transferToDto(dop);
    }

    public static void deleteDeelOpdrachtPrint(@RequestBody Long id) {

        deelOpdrachtPrintRepository.deleteById(id);

    }

    public DeelOpdrachtPrintDto updateDeelOpdrachtPrint(Long id, DeelOpdrachtPrintInputDto newDeelopdrachtPrint) {

        Optional<DeelOpdrachtPrint> DeelOpdrachtPrintOptional = deelOpdrachtPrintRepository.findById(id);
        if (DeelOpdrachtPrintOptional.isPresent()) {

            DeelOpdrachtPrint deelOpdrachtPrint1 = DeelOpdrachtPrintOptional.get();
            deelOpdrachtPrint1.setName(newDeelopdrachtPrint.getName());
            deelOpdrachtPrint1.setKopij(newDeelopdrachtPrint.getKopij());
            deelOpdrachtPrint1.setDeadlineFirstVersion(newDeelopdrachtPrint.getDeadlineFirstVersion());
            deelOpdrachtPrint1.setDeadlineSecVersion(newDeelopdrachtPrint.getDeadlineSecVersion());
            deelOpdrachtPrint1.setDeadlineDef(newDeelopdrachtPrint.getDeadlineDef());
            deelOpdrachtPrint1.setFeedback(newDeelopdrachtPrint.getFeedback());
            deelOpdrachtPrint1.setSizeWidthMM(newDeelopdrachtPrint.getSizeWidthMM());
            deelOpdrachtPrint1.setSizeLengthMM(newDeelopdrachtPrint.getSizeLengthMM());
            deelOpdrachtPrint1.setBleed(newDeelopdrachtPrint.getBleed());
            deelOpdrachtPrint1.setCutLines(newDeelopdrachtPrint.isCutLines());


            DeelOpdrachtPrint returnDeelopdrachtPrint = deelOpdrachtPrintRepository.save(deelOpdrachtPrint1);

            return transferToDto(returnDeelopdrachtPrint);

        } else {

            throw new RecordNotFoundException("geen Deelopdracht gevonden");

        }

    }

    public DeelOpdrachtPrint transferToDeelopdrachtPrint(DeelOpdrachtPrintInputDto dto) {
        var deelOpdrachtPrint = new DeelOpdrachtPrint();

        deelOpdrachtPrint.setName(dto.getName());
        deelOpdrachtPrint.setKopij(dto.getKopij());
        deelOpdrachtPrint.setDeadlineFirstVersion(dto.getDeadlineFirstVersion());
        deelOpdrachtPrint.setDeadlineSecVersion(dto.getDeadlineSecVersion());
        deelOpdrachtPrint.setDeadlineDef(dto.getDeadlineDef());
        deelOpdrachtPrint.setFeedback(dto.getFeedback());
        deelOpdrachtPrint.setStatus(dto.getStatus());
        deelOpdrachtPrint.setSizeWidthMM(dto.getSizeWidthMM());
        deelOpdrachtPrint.setSizeLengthMM(dto.getSizeLengthMM());
        deelOpdrachtPrint.setBleed(dto.getBleed());
        deelOpdrachtPrint.setCutLines(dto.isCutLines());
        Project project = projectRepository.findById(dto.projectId).get();
        deelOpdrachtPrint.setProject(project);
        Printshop printshop = printshopRepository.findById(dto.printshop).get();
        deelOpdrachtPrint.setPrintshop(printshop);



        return deelOpdrachtPrint;
    }

    // Dit is de vertaal methode van DeelOpdrachtPrint naar DeelOpdrachtPrintDto
    public DeelOpdrachtPrintDto transferToDto(DeelOpdrachtPrint deelOpdrachtPrint) {
        DeelOpdrachtPrintDto dto = new DeelOpdrachtPrintDto();
        dto.setId(deelOpdrachtPrint.getId());
        dto.setName(deelOpdrachtPrint.getName());
        dto.setKopij(deelOpdrachtPrint.getKopij());
        dto.setDeadlineFirstVersion(deelOpdrachtPrint.getDeadlineFirstVersion());
        dto.setDeadlineSecVersion(deelOpdrachtPrint.getDeadlineSecVersion());
        dto.setDeadlineDef(deelOpdrachtPrint.getDeadlineDef());
        dto.setFeedback(deelOpdrachtPrint.getFeedback());
        dto.setStatus((deelOpdrachtPrint.getStatus()));
        dto.setSizeWidthMM(deelOpdrachtPrint.getSizeWidthMM());
        dto.setSizeLengthMM(deelOpdrachtPrint.getSizeLengthMM());
        dto.setBleed(deelOpdrachtPrint.getBleed());
        dto.setCutLines(deelOpdrachtPrint.isCutLines());
        dto.setPrintshop(deelOpdrachtPrint.getPrintshop().getId());
        dto.setProjectId(deelOpdrachtPrint.getProject().getId());
        return dto;
    }
}