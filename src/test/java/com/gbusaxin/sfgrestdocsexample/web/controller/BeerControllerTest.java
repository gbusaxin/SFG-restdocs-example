package com.gbusaxin.sfgrestdocsexample.web.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gbusaxin.sfgrestdocsexample.domain.Beer;
import com.gbusaxin.sfgrestdocsexample.repositories.BeerRepository;
import com.gbusaxin.sfgrestdocsexample.web.model.BeerDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.restdocs.RestDocumentationExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.*;
import static org.springframework.restdocs.request.RequestDocumentation.parameterWithName;
import static org.springframework.restdocs.request.RequestDocumentation.pathParameters;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @created : by GBu on 31. 10. 2022, pondelok
 * @mailto : grigorii.busakhin@software-foundation.sk
 **/
@ExtendWith(RestDocumentationExtension.class)
@WebMvcTest(BeerController.class)
@AutoConfigureRestDocs
@ComponentScan(basePackages = "com.gbusaxin.sfgrestdocsexample.web")
class BeerControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @MockBean
    BeerRepository beerRepository;

//    @BeforeEach
//    void setUp(){
//        mockMvc = MockMvcBuilders.standaloneSetup(BeerController.class).build();
//    }

    @Test
    void getBeerById() throws Exception {
        given(beerRepository.findById(any())).willReturn(Optional.of(Beer.builder().build()));

        mockMvc.perform(get("/api/v1/beer/{beerId}" , UUID.randomUUID()).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(document("v1/beer", pathParameters(
                        parameterWithName("beerId").description("UUID of desired beer to get.")
                )));
    }

    @Test
    void saveNewBeer() throws Exception {
        BeerDto beerDto = getValidBeerDto();
        String beerToJson = objectMapper.writeValueAsString(beerDto);

        mockMvc.perform(post("/api/v1/beer/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(beerToJson))
                .andExpect(status().isCreated());
    }

    @Test
    void updateBeerById() throws Exception {
        BeerDto beerDto = getValidBeerDto();
        String beerToJson = objectMapper.writeValueAsString(beerDto);

        mockMvc.perform(put("/api/v1/beer/" + UUID.randomUUID())
                .contentType(MediaType.APPLICATION_JSON)
                .content(beerToJson))
                .andExpect(status().isNoContent());
    }

    private BeerDto getValidBeerDto(){
        return BeerDto.builder()
                .beerName("Baltika")
                .beerStyle("IPA")
                .price(new BigDecimal("12.12"))
                .upc(13231212L)
                .build();
    }

}