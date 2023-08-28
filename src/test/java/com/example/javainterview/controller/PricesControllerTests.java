package com.example.javainterview.controller;

import com.example.javainterview.JavainterviewApplication;
import com.example.javainterview.search.PricesFilter;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.MOCK,
        classes = JavainterviewApplication.class
)
@AutoConfigureMockMvc
public class PricesControllerTests {

    @Autowired
    private MockMvc mvc;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testCase1() throws Exception {
        // precondition
        LocalDateTime applicationLocalTimeDate = LocalDateTime.parse("2020-06-14T10:00:00");
        Date applicationDate = Date.from(applicationLocalTimeDate.atZone(ZoneId.systemDefault()).toInstant());
        int productId = 35455;
        Long brandId = 1L;

        PricesFilter filter = PricesFilter.builder()
                .applicationDate(applicationDate)
                .brandId(brandId)
                .productId(productId)
                .build();
        // action
        ResultActions response = mvc.perform(post("/prices/result")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(filter)));

        //then - verify response
        response.andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$.brand_id", is(1)))
                .andExpect(jsonPath("$.product_id", is(35455)));
    }

    @Test
    public void testCase2() throws Exception {
        // precondition
        LocalDateTime applicationLocalTimeDate = LocalDateTime.parse("2020-06-14T16:00:00");
        Date applicationDate = Date.from(applicationLocalTimeDate.atZone(ZoneId.systemDefault()).toInstant());
        int productId = 35455;
        Long brandId = 1L;

        PricesFilter filter = PricesFilter.builder()
                .applicationDate(applicationDate)
                .brandId(brandId)
                .productId(productId)
                .build();
        // action
        ResultActions response = mvc.perform(post("/prices/result")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(filter)));

        //then - verify response
        response.andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$.brand_id", is(1)))
                .andExpect(jsonPath("$.product_id", is(35455)));
    }

    @Test
    public void testCase3() throws Exception {
        // precondition
        LocalDateTime applicationLocalTimeDate = LocalDateTime.parse("2020-06-14T21:00:00");
        Date applicationDate = Date.from(applicationLocalTimeDate.atZone(ZoneId.systemDefault()).toInstant());
        int productId = 35455;
        Long brandId = 1L;

        PricesFilter filter = PricesFilter.builder()
                .applicationDate(applicationDate)
                .brandId(brandId)
                .productId(productId)
                .build();
        // action
        ResultActions response = mvc.perform(post("/prices/result")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(filter)));

        //then - verify response
        response.andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$.brand_id", is(1)))
                .andExpect(jsonPath("$.product_id", is(35455)));
    }

    @Test
    public void testCase4() throws Exception {
        // precondition
        LocalDateTime applicationLocalTimeDate = LocalDateTime.parse("2020-06-15T10:00:00");
        Date applicationDate = Date.from(applicationLocalTimeDate.atZone(ZoneId.systemDefault()).toInstant());
        int productId = 35455;
        Long brandId = 1L;

        PricesFilter filter = PricesFilter.builder()
                .applicationDate(applicationDate)
                .brandId(brandId)
                .productId(productId)
                .build();
        // action
        ResultActions response = mvc.perform(post("/prices/result")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(filter)));

        //then - verify response
        response.andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$.brand_id", is(1)))
                .andExpect(jsonPath("$.product_id", is(35455)));
    }

    @Test
    public void testCase5() throws Exception {
        // precondition
        LocalDateTime applicationLocalTimeDate = LocalDateTime.parse("2020-06-16T21:00:00");
        Date applicationDate = Date.from(applicationLocalTimeDate.atZone(ZoneId.systemDefault()).toInstant());
        int productId = 35455;
        Long brandId = 1L;

        PricesFilter filter = PricesFilter.builder()
                .applicationDate(applicationDate)
                .brandId(brandId)
                .productId(productId)
                .build();
        // action
        ResultActions response = mvc.perform(post("/prices/result")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(filter)));

        //then - verify response
        response.andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$.brand_id", is(1)))
                .andExpect(jsonPath("$.product_id", is(35455)));
    }
}
