package com.example.eidopdrachtnovi.service;


import com.example.eidopdrachtnovi.dtos.PrintshopDto;
import com.example.eidopdrachtnovi.dtos.PrintshopInputDto;
import com.example.eidopdrachtnovi.models.Printshop;

import com.example.eidopdrachtnovi.repositories.PrintshopRepository;
import com.example.eidopdrachtnovi.services.PrintshopService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PrintshopServiceTest {

    @Mock
    PrintshopRepository repos;

    @InjectMocks
    PrintshopService service;


    @Test
    void shouldGetAllPrintshops() {
        Long tel = 123L;
        List<Printshop> list = new ArrayList<>();
        Printshop p = new Printshop("Printshop", "Adres", "emails", tel);
        Printshop p2 = new Printshop("Printshop2", "Adres2", "emails2", tel);
        list.add(p);
        list.add(p2);

        when(repos.findAll()).thenReturn(list);

        List<PrintshopDto> printshopDtoList = service.getAllprintshops();

        assertEquals(2, printshopDtoList.size());
        assertEquals("Printshop", printshopDtoList.get(0).getName());
        assertEquals("Printshop2", printshopDtoList.get(1).getName());

    }


    @Test
    void shouldAddPrintshop() {
        PrintshopInputDto inputDto = new PrintshopInputDto("Printshop", "Adres", "emails", 123L);

        Printshop p = new Printshop("Printshop", "Adres", "emails", 123L);
        when(repos.save(any())).thenReturn(p);

        // Act
        PrintshopDto result = service.addPrintshop(inputDto);

        // Assert
        verify(repos, times(1)).save(any());
        assertNotNull(result);
        assertEquals(p.getName(), result.getName());
        assertEquals(p.getAdress(), result.getAdress());
        assertEquals(p.getEmail(), result.getEmail());
        assertEquals(p.getPhonenumber(), result.getPhonenumber());
    }

    @Test
    public void shouldDeletePrintshop() {
        // Arrange
        Long printshopId = 1L;

        // Act
        service.deletePrintshop(printshopId);

        // Assert
        verify(repos, times(1)).deleteById(printshopId);
    }

    @Test
    public void testUpdatePrintshop() {
        Long printshopId = 1L;
        PrintshopInputDto inputDto = new PrintshopInputDto("new Printshop", "new Adres", "new emails", 123L);

        Printshop p = new Printshop("Printshop", "Adres", "emails", 123L);
        p.setId(printshopId);
        when(repos.save(any())).thenReturn(p);
        when(repos.findById(printshopId)).thenReturn(Optional.of(p));

        PrintshopDto result = service.updatePrintshop(printshopId, inputDto);


        assertEquals(p.getName(), result.getName());
        assertEquals(p.getAdress(), result.getAdress());
        assertEquals(p.getEmail(), result.getEmail());
        assertEquals(p.getPhonenumber(), result.getPhonenumber());

    }


    @Test
    public void testTransferToPrintshop() {

        PrintshopInputDto inputDto = new PrintshopInputDto("Printshop 1", "2022-05-30", "Milene", 123L);

        Printshop p = service.transferToPrintshop(inputDto);

        assertEquals("Printshop 1", p.getName());
        assertEquals("2022-05-30", p.getAdress());
        assertEquals("Milene", p.getEmail());
        assertEquals(123L, p.getPhonenumber());
    }

    @Test
    public void shouldTransferToDto() {
        Printshop p= new Printshop("Printshop 1", "adres", "@Milene", 123L);

        PrintshopDto projectDto = service.transferToDto(p);

        assertEquals("Printshop 1", projectDto.getName());
        assertEquals("adres", projectDto.getAdress());
        assertEquals("@Milene", projectDto.getEmail());
        assertEquals(123L, projectDto.getPhonenumber());
    }

}

