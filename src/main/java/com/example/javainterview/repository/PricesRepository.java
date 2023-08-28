package com.example.javainterview.repository;

import com.example.javainterview.entity.Prices;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface PricesRepository extends JpaRepository<Prices, Long> {

    @Query("FROM Prices p\n" +
            "WHERE :applicationDate BETWEEN start_date AND end_date\n" +
            "AND p.product_id=:productId\n" +
            "AND p.brand.id=:brandId")
    List<Optional<Prices>> findAllWithoutPriorityCheck(@Param("applicationDate") Date applicationDate,
                                                       @Param("productId") int productId,
                                                       @Param("brandId") Long brandId);
}
