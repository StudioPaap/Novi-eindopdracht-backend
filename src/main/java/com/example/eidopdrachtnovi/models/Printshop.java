package com.example.eidopdrachtnovi.models;

import jakarta.persistence.*;


@Entity

public class Printshop {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String adress;
    private String email;
    private Long phonenumber;

    @OneToOne (mappedBy = "printshop")
    private DeelOpdrachtPrint deelOpdrachtPrint;

    public Printshop() {
    }

    public Printshop(String name, String adress, String email, Long phonenumber) {
        this.name = name;
        this.adress = adress;
        this.email = email;
        this.phonenumber = phonenumber;
    }




    public Printshop(String name, String adress, String email, Long phonenumber, DeelOpdrachtPrint deelOpdrachtPrint) {
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

    public String getEmail() {
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

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhonenumber(Long phonenumber) {
        this.phonenumber = phonenumber;
    }
}
