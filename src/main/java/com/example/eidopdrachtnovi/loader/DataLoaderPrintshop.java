package com.example.eidopdrachtnovi.loader;

import com.example.eidopdrachtnovi.models.Printshop;
import com.example.eidopdrachtnovi.repositories.PrintshopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataLoaderPrintshop implements CommandLineRunner {


    private final PrintshopRepository printshopRepos;

    @Autowired
    public DataLoaderPrintshop(PrintshopRepository printshopRepos) {
        this.printshopRepos = printshopRepos;
    }

    @Override
    public void run(String... args) throws Exception {
        List<Printshop> printshops = new ArrayList<>();
        Printshop p1 = new Printshop("DrukwerkMotief", "Heescherweg 30 Amsterdam", "Jan@drukwerkmotief.nl", 258900L);
        printshops.add(p1);

        Printshop p2 = new Printshop("Plaatreclame", "V;issestraat 44 Shaaijk", "Peter@plaatreclame.nl", 398850L);
        printshops.add(p2);


        for (Printshop printshop : printshops) {
            printshopRepos.save(printshop);
        }
    }
}