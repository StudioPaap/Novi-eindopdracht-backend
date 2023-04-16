package com.example.eidopdrachtnovi.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;

// variabele
public class Printshop {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String adress;
    private Email email;
    private Long phonenumber;

    @ManyToOne
    @JoinColumn(name = "deelOpdrachtPrint_id")
    private DeelOpdrachtPrint deelOpdrachtPrint;


    // constructor

    public Printshop(){};


    // uitgebreide constructor

    public Printshop(String name, String adress, Email email, Long phonenumber, DeelOpdrachtPrint deelOpdrachtPrint) {
        this.name = name;
        this.adress = adress;
        this.email = email;
        this.phonenumber = phonenumber;
        this.deelOpdrachtPrint = deelOpdrachtPrint;
    }


    // getters

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAdress() {
        return adress;
    }

    public DeelOpdrachtPrint getDeelOpdrachtPrint() {
        return deelOpdrachtPrint;
    }

    public Email getEmail() {
        return email;
    }

    public Long getPhonenumber() {
        return phonenumber;
    }

    //setters

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public void setDeelOpdrachtPrint(DeelOpdrachtPrint deelOpdrachtPrint) {
        this.deelOpdrachtPrint = deelOpdrachtPrint;
    }

    public void setEmail(Email email) {
        this.email = email;
    }

    public void setPhonenumber(Long phonenumber) {
        this.phonenumber = phonenumber;
    }
}