package com.example.eidopdrachtnovi.controller;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8;

@SpringBootTest
@AutoConfigureMockMvc(addFilters = false)
@ActiveProfiles("test")

public class ProjectControllerIntegrationTest {
    @Autowired
    MockMvc mockMvc;

    @Test
    void shouldAddProject() throws Exception {

        String requestJson = """
                {
                    "name" : "Narim",
                    "date": "12 juni 2022",
                    "projectManager":"Milene",
                    "studioMember": "Beau"
                }
                """;

        this.mockMvc
                .perform(MockMvcRequestBuilders.post("/project")
                        .contentType(APPLICATION_JSON_UTF8)
                        .content(requestJson))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isCreated());
    }

}



