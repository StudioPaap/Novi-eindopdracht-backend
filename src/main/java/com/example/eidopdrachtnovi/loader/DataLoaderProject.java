package com.example.eidopdrachtnovi.loader;

import com.example.eidopdrachtnovi.models.Project;
import com.example.eidopdrachtnovi.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataLoaderProject implements CommandLineRunner {


    private final ProjectRepository projectRepos;

    @Autowired
    public DataLoaderProject(ProjectRepository projectRepos) {
        this.projectRepos = projectRepos;
    }

    @Override
    public void run(String... args) throws Exception {
        List<Project> projects = new ArrayList<>();
        Project p1 = new Project("Lely event", "01-08-2023","Milene","Anouk" );
        projects.add(p1);

        Project p2 = new Project("Eurofiber", "22-07-2023","Maaike","Beau" );
        projects.add(p2);


        for (Project project : projects) {
            projectRepos.save(project);
        }
    }
}
