package com.example.eidopdrachtnovi.dtos;

import com.example.eidopdrachtnovi.models.Status;

public class DeelOpdrachtDto {

    private String name;
    private String kopij;
    private String deadlineFirstVersion ;
    private String deadlineSecVersion;
    private String deadlineDef;
    private String Feedback;
    public Status status;


    // Een default constructor
    public DeelOpdrachtDto() {
    }

    // Een uitgebreide constructor

    public DeelOpdrachtDto(String name, String kopij, String deadline1, String deadline2, String deadlineDef, String feedback, Status status){
        this.name = name;
        this.kopij = kopij;
        this.deadlineFirstVersion=deadline1;
        this.deadlineSecVersion=deadline2;
        this.deadlineDef=deadlineDef;
        this.Feedback = feedback;
        this.status = status;
    }
}
