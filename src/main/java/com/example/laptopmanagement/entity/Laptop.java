package com.example.laptopmanagement.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table (name = "laptops")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Laptop {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    @Column (name = "brand", nullable = false)
    private String brand;
    @Column (name = "model", nullable = false)
    private String model;
    @Column (name = "serialNumber", nullable = false)
    private String serialNumber;
    @Column (name = "location", nullable = false)
    private String location;
    @Column (name = "purchaseDate", nullable = false)
    private LocalDate purchaseDate;
    @Column (name = "purchasePrice", nullable = false)
    private BigDecimal purchasePrice;
    @Column (name = "status", nullable = false)
    private String status;
}