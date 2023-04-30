package com.example.eidopdrachtnovi.loader;

import com.example.eidopdrachtnovi.models.DeelOpdrachtPrint;
import com.example.eidopdrachtnovi.models.Printshop;
import com.example.eidopdrachtnovi.models.Project;
import com.example.eidopdrachtnovi.repositories.DeelOpdrachtPrintRepository;
import com.example.eidopdrachtnovi.repositories.PrintshopRepository;
import com.example.eidopdrachtnovi.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static com.example.eidopdrachtnovi.models.Status.IN_PRODUCTION;

@Component
public class DataLoaderDeelOpdrachtPrint implements CommandLineRunner {


    private final DeelOpdrachtPrintRepository deelOpdrachtPrintRepos;
    private final ProjectRepository projectRepository;
    private final PrintshopRepository printshopRepository;

    @Autowired
    public DataLoaderDeelOpdrachtPrint(DeelOpdrachtPrintRepository deelOpdrachtPrintRepos, ProjectRepository projectRepository, PrintshopRepository printshopRepository) {
        this.deelOpdrachtPrintRepos = deelOpdrachtPrintRepos;
        this.projectRepository = projectRepository;
        this.printshopRepository = printshopRepository;
    }

    @Override
    public void run(String... args) throws Exception {


        Project project = projectRepository.findById(2L).orElse(null);
        if (project == null) {
            // Maak een nieuw project aan als het niet bestaat
            project = new Project("AAG", "01-10-2023", "Lilian", "Beau");
            projectRepository.save(project);
        }

        Printshop printshop = printshopRepository.findById(2L).orElse(null);
        if (printshop == null) {
            // Maak een nieuw project aan als het niet bestaat
            printshop = new Printshop("PeterPrint", "Akerkstraat 100, 2992CM Groningen", "peter@Peterprint.nl", 12345L);
            printshopRepository.save(printshop);


            List<DeelOpdrachtPrint> deelOpdrachtPrints = new ArrayList<>();
            DeelOpdrachtPrint d1 = new DeelOpdrachtPrint("1.3 PosterCatering", "BUFFET AAG + Logo", "10-08-2023", "15-08-2023", "19-08-2023", "Nog geen feedback", IN_PRODUCTION, project, 297, 420, 10, false, printshop);
            deelOpdrachtPrints.add(d1);


            for (DeelOpdrachtPrint deelOpdrachtPrint : deelOpdrachtPrints) {
                deelOpdrachtPrintRepos.save(deelOpdrachtPrint);
            }
        }
    }
    }