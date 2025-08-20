package com.example.old_clinic.controllers;

import com.example.old_clinic.mappers.OldClientMapper;
import com.example.old_clinic.mappers.OldNoteMapper;
import com.example.old_clinic.services.OldClientService;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest({OldClientController.class})
@RequiredArgsConstructor
public class OldClientControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private OldClientService oldClientService;

    @MockitoBean
    private OldClientMapper oldClientMapper;

    @MockitoBean
    private OldNoteMapper oldNoteMapper;

    @Test
    public void findAll() throws Exception {
        mockMvc.perform(post("/clients"))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    public void findAllWithNotes() throws Exception {
        String body = """
                {
                    "agency": "",
                    "guid": "",
                    "dateTo": "2025-08-20T21:56:50.8437229",
                    "dateFrom": "2025-08-20T21:56:50.8437229"
                }""";

        mockMvc.perform(post("/notes")
                        .content(body)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @BeforeEach
    public void setup() {

    }
}
