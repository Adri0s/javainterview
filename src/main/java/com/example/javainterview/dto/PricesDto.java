package com.example.javainterview.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PricesDto {

    private long brand_id;
    private Date start_date;
    private Date end_date;
    private long price_list;
    private long product_id;
    private BigDecimal price;
}
