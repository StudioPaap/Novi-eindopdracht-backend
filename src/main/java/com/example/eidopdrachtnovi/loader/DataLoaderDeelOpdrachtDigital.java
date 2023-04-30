package com.example.eidopdrachtnovi.loader;

import com.example.eidopdrachtnovi.models.DeelOpdrachtDigital;
import com.example.eidopdrachtnovi.models.Project;
import com.example.eidopdrachtnovi.repositories.DeelOpdrachtDigitalRepository;
import com.example.eidopdrachtnovi.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.example.eidopdrachtnovi.models.Status.IN_PRODUCTION;

@Component
public class DataLoaderDeelOpdrachtDigital implements CommandLineRunner {


    private final DeelOpdrachtDigitalRepository deelOpdrachtDigitalRepos;
    private final ProjectRepository projectRepository;

    @Autowired
    public DataLoaderDeelOpdrachtDigital(DeelOpdrachtDigitalRepository deelOpdrachtDigitalRepos, ProjectRepository projectRepository) {
        this.deelOpdrachtDigitalRepos = deelOpdrachtDigitalRepos;
        this.projectRepository = projectRepository;
    }

    @Override
    public void run(String... args) throws Exception {

            // Controleer of er een project met ID 1 bestaat voordat je deze ophaalt
            Project project = projectRepository.findById(1L).orElse(null);
            if (project == null) {
                // Maak een nieuw project aan als het niet bestaat
                project = new Project("ACS", "01-09-2023", "Bloeme", "Anouk");
                projectRepository.save(project);
            }


            List<DeelOpdrachtDigital> deelOpdrachtDigitals = new ArrayList<>();
        DeelOpdrachtDigital d1 = new DeelOpdrachtDigital("1.1PosterParkeren", "Logo en P plus pijl naar rechts", "01-05-2023", "08-05-2023", "15-05-2023", "Nog geen feedback", IN_PRODUCTION, project , "1920x1080px", false, "PNG");
        deelOpdrachtDigitals.add(d1);





        for (DeelOpdrachtDigital deelOpdrachtDigital : deelOpdrachtDigitals) {
            deelOpdrachtDigitalRepos.save(deelOpdrachtDigital);
        }
    }
}