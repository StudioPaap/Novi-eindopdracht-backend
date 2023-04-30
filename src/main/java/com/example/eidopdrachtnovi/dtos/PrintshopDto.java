package com.example.eidopdrachtnovi.dtos;


public class PrintshopDto {

    public Long id;
    public String name;
    public String adress;
    public String email;
    public Long phonenumber;


    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAdress() {
        return adress;
    }

    public String getEmail() {
        return email;
    }

    public Long getPhonenumber() {
        return phonenumber;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhonenumber(Long phonenumber) {
        this.phonenumber = phonenumber;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
