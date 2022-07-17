package org.bhavesh.microsservices.mssc.web.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.bhavesh.microsservices.mssc.web.model.BeerDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import java.util.UUID;

import static org.springframework.http.RequestEntity.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@WebMvcTest
class BeerControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    void getBeerById() throws Exception
    {
        mockMvc.perform(get("/api/v1/beer/"+UUID.randomUUID().toString()).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void saveNewBeer() throws Exception
    {
        BeerDTO beerDTO= BeerDTO.builder().build();
        String beerDTOJson=objectMapper.writeValueAsString(beerDTO);

        mockMvc.perform(post("/api/v1/beer/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(beerDTOJson))
                .andExpect(status().isCreated());
    }
    @Test
    void updateBeer() throws Exception {
        BeerDTO beerDTO= BeerDTO.builder().build();
        String beerDTOJson=objectMapper.writeValueAsString(beerDTO);

        mockMvc.perform(put("/api/v1/beer/"+UUID.randomUUID().toString())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(beerDTOJson))
                .andExpect(status().isNoContent());
    }
    @Test
    void deleteBeer()
    {
    }

}