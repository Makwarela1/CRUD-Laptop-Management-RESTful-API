package com.example.laptopmanagement.dto;


import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;
import java.time.LocalDate;

public record LaptopRequestDTO(

        @NotBlank (message = " Laptop brand can not be empty")
        @Size (max = 255, message = "Laptop brand must not exceed 255 characters")
        String brand,

        @NotBlank (message = " Laptop model can not be empty")
        @Size (max = 255, message = "Laptop model must not exceed 255 characters")
        String model,

        @NotBlank (message = " Serial number can not be empty")
        @Size (max = 255, message = "Serial number must not exceed 255 characters")
        String serialNumber,

        @NotBlank (message = " Location can not be empty")
        @Size (max = 255, message = "Location must not exceed 255 characters")
        String location,

        @NotBlank (message = " Purchase date can not be empty")
        LocalDate purchaseDate,

        @Positive
        @NotBlank (message = " Price of laptop can not be empty")
        BigDecimal purchasePrice,

        @NotBlank (message = " Laptop brand can not be empty")
        @Size (max = 255, message = "Status of the laptop must not exceed 255 characters")
        String status

) {
}
