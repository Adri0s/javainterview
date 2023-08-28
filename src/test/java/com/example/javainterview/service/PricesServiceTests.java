package com.example.javainterview.service;

import com.example.javainterview.dto.PricesDto;
import com.example.javainterview.entity.Brand;
import com.example.javainterview.entity.Prices;
import com.example.javainterview.repository.PricesRepository;
import com.example.javainterview.search.PricesFilter;
import com.example.javainterview.service.impl.PricesServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Currency;
import java.util.Date;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
public class PricesServiceTests {

    @Mock
    private PricesRepository pricesRepository;
    @InjectMocks
    private PricesServiceImpl pricesService;

    @Test
    public void givenPricesFilter_whenGetMatchResult_thenReturnHighestPriorityResult() {
        // precondition
        LocalDateTime applicationLocalTimeDate = LocalDateTime.parse("2020-06-14T16:00:00");
        Date applicationDate = Date.from(applicationLocalTimeDate.atZone(ZoneId.systemDefault()).toInstant());
        int productId = 35455;
        Long brandId = 1L;

        Brand brand = Brand.builder()
                .id(brandId)
                .name("ZARA")
                .description("Corresponding to ZARA store")
                .build();

        Prices prices1 = Prices.builder()
                .id(1L)
                .brand(brand)
                .start_date(Date.from(LocalDateTime.parse("2020-06-14T00:00:00").atZone(ZoneId.systemDefault()).toInstant()))
                .end_date(Date.from(LocalDateTime.parse("2020-12-31T23:59:59").atZone(ZoneId.systemDefault()).toInstant()))
                .price_list(1)
                .product_id(productId)
                .priority(0)
                .price(BigDecimal.valueOf(35.50))
                .curr(Currency.getInstance("EUR"))
                .build();

        Prices prices2 = Prices.builder()
                .id(1L)
                .brand(brand)
                .start_date(Date.from(LocalDateTime.parse("2020-06-14T15:00:00").atZone(ZoneId.systemDefault()).toInstant()))
                .end_date(Date.from(LocalDateTime.parse("2020-06-14T18:30:00").atZone(ZoneId.systemDefault()).toInstant()))
                .price_list(2)
                .product_id(productId)
                .priority(1)
                .price(BigDecimal.valueOf(25.45))
                .curr(Currency.getInstance("EUR"))
                .build();

        given(pricesRepository.findAllWithoutPriorityCheck(applicationDate, productId, brandId)).willReturn(
                List.of(prices1, prices2)
        );

        PricesFilter filter = PricesFilter.builder()
                .applicationDate(applicationDate)
                .brandId(brandId)
                .productId(productId)
                .build();

        // perform the operation
        PricesDto pricesDto = pricesService.getMatchResult(filter);

        assertThat(pricesDto).isNotNull();
        assertThat(pricesDto.getPrice()).isEqualTo(BigDecimal.valueOf(25.45));
    }
}
