package com.example.javainterview.service;

import com.example.javainterview.dto.PricesDto;
import com.example.javainterview.search.PricesFilter;

public interface PricesService {

    PricesDto getMatchResult(PricesFilter filter);
}
