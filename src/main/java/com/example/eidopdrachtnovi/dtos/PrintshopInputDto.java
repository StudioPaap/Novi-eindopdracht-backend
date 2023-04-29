package com.example.eidopdrachtnovi.dtos;

import com.example.eidopdrachtnovi.models.DeelOpdrachtPrint;

public class PrintshopInputDto {


    public String name;
    public String adress;
    public String email;
    public Long phonenumber;
    public DeelOpdrachtPrint deelOpdrachtPrint;

    public PrintshopInputDto(String name, String adres, String emails, Long tel) {
   this.name = name;
   this.adress = adres;
   this.email = emails;
   this.phonenumber = tel;


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

    public DeelOpdrachtPrint getDeelOpdrachtPrint() {
        return deelOpdrachtPrint;
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

    public void setDeelOpdrachtPrint(DeelOpdrachtPrint deelOpdrachtPrint) {
        this.deelOpdrachtPrint = deelOpdrachtPrint;
    }
}
