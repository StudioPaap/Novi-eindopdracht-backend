package com.example.eidopdrachtnovi.dtos;

import com.example.eidopdrachtnovi.models.DeelOpdrachtPrint;
import com.example.eidopdrachtnovi.models.Printshop;
import jakarta.validation.constraints.Email;

public class PrintshopDto {

    public Printshop id;
    public String name;
    public String adress;
    public String email;
    public Long phonenumber;
    public DeelOpdrachtPrint deelOpdrachtPrint;

    public Printshop getId() {
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
