package com.example.eidopdrachtnovi.dtos;

import com.example.eidopdrachtnovi.models.DeelOpdrachtPrint;
import jakarta.validation.constraints.Email;

public class PrintshopDto {

    public Long id;
    public String name;
    public String adress;
    public Email email;
    public Long phonenumber;
    public DeelOpdrachtPrint deelOpdrachtPrint;

}
