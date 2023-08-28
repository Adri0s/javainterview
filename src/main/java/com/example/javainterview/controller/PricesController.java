package com.example.javainterview.controller;

import com.example.javainterview.dto.PricesDto;
import com.example.javainterview.search.PricesFilter;
import com.example.javainterview.service.PricesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("prices")
public class PricesController {

    private final PricesService pricesService;

    @Autowired
    public PricesController(PricesService pricesService) {
        this.pricesService = pricesService;
    }

    @PostMapping("result")
    public ResponseEntity<PricesDto> getResult(@RequestBody PricesFilter filter) {
        return new ResponseEntity<>(pricesService.getMatchResult(filter), HttpStatus.OK);
    }
}
