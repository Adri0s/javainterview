package com.example.javainterview.service.impl;

import com.example.javainterview.dto.PricesDto;
import com.example.javainterview.entity.Prices;
import com.example.javainterview.exception.EntityNotFoundException;
import com.example.javainterview.repository.PricesRepository;
import com.example.javainterview.search.PricesFilter;
import com.example.javainterview.service.PricesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class PricesServiceImpl implements PricesService {

    private final PricesRepository pricesRepository;

    @Autowired
    public PricesServiceImpl(PricesRepository pricesRepository) {
        this.pricesRepository = pricesRepository;
    }

    @Override
    public PricesDto getMatchResult(PricesFilter filter) {

        List<Prices> allWithoutPriorityCheck =
                pricesRepository.findAllWithoutPriorityCheck(filter.getApplicationDate(),
                filter.getProductId(), filter.getBrandId());

        if(allWithoutPriorityCheck.isEmpty()) {
            throw new EntityNotFoundException("There is no result for this search criteria.");
        }

        return getResultWithHighestPriority(allWithoutPriorityCheck);
    }

    private PricesDto getResultWithHighestPriority(List<Prices> allWithoutPriorityCheck) {
        // si hay mas de 1 filtrar
        if(allWithoutPriorityCheck.size() == 1) {
            return toDto(allWithoutPriorityCheck.get(0));
        }

        Prices result = allWithoutPriorityCheck
                .stream()
                .max(Comparator.comparing(prices -> prices.getPriority()))
                .get();

        return toDto(result);
    }

    private PricesDto toDto(Prices entity) {
        return PricesDto.builder()
                .brand_id(entity.getBrand().getId())
                .start_date(entity.getStart_date())
                .end_date(entity.getEnd_date())
                .price_list(entity.getPrice_list())
                .product_id(entity.getProduct_id())
                .price(entity.getPrice())
                .build();
    }
}
