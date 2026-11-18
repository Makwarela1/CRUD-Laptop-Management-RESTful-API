package com.example.laptopmanagement.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public record LaptopResponseDTO(
        Long id,
        String brand,
        String model,
        String serialNumber,
        String location,
        LocalDate purchaseDate,
        BigDecimal purchasePrice,
        String status
) {

}
