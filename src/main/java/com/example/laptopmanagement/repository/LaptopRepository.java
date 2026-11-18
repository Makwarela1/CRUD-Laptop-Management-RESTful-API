package com.example.laptopmanagement.repository;
import com.example.laptopmanagement.entity.Laptop;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface LaptopRepository extends JpaRepository<Laptop, Long> {

    Optional <Laptop> findById (Long id);

    String findByLocation (String location);

    List<Laptop> findByPurchaseDate (LocalDate purchaseDate);

    List<Laptop> findByPurchasePrice (BigDecimal purchasePrice);

}
