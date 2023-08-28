package com.example.javainterview.repository;

import com.example.javainterview.entity.Prices;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@DataJpaTest
public class PricesRepositoryTests {

    private final PricesRepository pricesRepository;

    @Autowired
    public PricesRepositoryTests(PricesRepository pricesRepository) {
        this.pricesRepository = pricesRepository;
    }

    @Test
    public void givenPricesFilter_whenFindAllWithoutPiorityCheck_thenReturnAllMatchValues() {
        // given the params
        LocalDateTime applicationLocalTimeDate = LocalDateTime.parse("2020-06-14T16:00:00");
        Date applicationDate = Date.from(applicationLocalTimeDate.atZone(ZoneId.systemDefault()).toInstant());
        int productId = 35455;
        Long brandId = 1L;

        // find
        List<Prices> allWithoutPriorityCheck =
                pricesRepository.findAllWithoutPriorityCheck(applicationDate, productId, brandId);

        // then
        assertThat(allWithoutPriorityCheck).isNotNull();
        assertThat(!allWithoutPriorityCheck.isEmpty());
    }
}
