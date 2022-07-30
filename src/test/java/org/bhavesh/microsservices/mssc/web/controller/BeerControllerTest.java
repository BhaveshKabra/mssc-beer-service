package org.bhavesh.microsservices.mssc.web.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.bhavesh.microsservices.mssc.service.BeerService;
import org.bhavesh.microsservices.mssc.web.model.BeerDTO;
import org.bhavesh.microsservices.mssc.web.model.BeerStyleEnum;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyBoolean;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(BeerController.class)
class BeerControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @MockBean
    BeerService beerService;
    @Test
    void getBeerById() throws Exception
    {
        given(beerService.getById(any())).willReturn(getValidBeerDto());
        mockMvc.perform(get("/api/v1/beer/" + UUID.randomUUID())
                        .accept(MediaType.APPLICATION_JSON))
                        .andExpect(status().isOk());
    }

    private BeerDTO getValidBeerDto() {
            return BeerDTO.builder()
                    .beerName("SomeName")
                    .beerStyle(BeerStyleEnum.PALE_ALE)
                    .price(BigDecimal.valueOf(11.76))
                    .upc("0738438463531")
                    .build();

    }

    @Test
    void saveNewBeer() throws Exception
    {
        String beerDTOJson=objectMapper.writeValueAsString(getValidBeerDto());
        mockMvc.perform(post("/api/v1/beer/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(beerDTOJson))
                .andExpect(status().isCreated());
    }
    @Test
    void updateBeer() throws Exception {
        UUID id=UUID.randomUUID();
        mockMvc.perform(patch("/api/v1/beer/"+id)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(getValidBeerDto())))
                .andExpect(status().isNoContent());
    }
    @Test
    void deleteBeer()
    {
    }
}