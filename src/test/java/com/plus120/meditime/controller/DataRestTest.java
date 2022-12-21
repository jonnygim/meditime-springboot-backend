package com.plus120.meditime.controller;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import javax.transaction.Transactional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.head;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@DisplayName("Data REST - API 테스트")
@Transactional
@AutoConfigureMockMvc
@SpringBootTest
public class DataRestTest {

    private final MockMvc mvc;

    public DataRestTest(@Autowired MockMvc mvc) {
        this.mvc = mvc;
    }

    @DisplayName("[api] 약 정보 리스트 조회")
    @Test
    void givenNothing_whenRequestingMedicines_thenReturnsMedicinesJsonResponse() throws Exception {
        // Given

        // When & Then
        mvc.perform(get("/api/medicines"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.valueOf("application/hal+json")));
    }

    @DisplayName("[api] 약 정보 단건 조회")
    @Test
    void givenNoting_whenRequestingMedicine_thenReturnMedicineJsonResponse() throws Exception {
        // Given

        // When & Then
        mvc.perform(get("/api/medicines/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.valueOf("application/hal+json")));
    }

    @DisplayName("[api] 유저 -> 약 정보 리스트 조회")
    @Test
    void givenNoting_whenRequestingMedicineBoxFromUser_thenReturnMedicinesJsonResponse() throws Exception {
        // Given

        // When & Then
        mvc.perform(get("/api/users/1/medicineBox"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.valueOf("application/hal+json")));
    }

}
