package com.example.laptopmanagement.service;

import com.example.laptopmanagement.dto.LaptopRequestDTO;
import com.example.laptopmanagement.dto.LaptopResponseDTO;
import com.example.laptopmanagement.entity.Laptop;
import com.example.laptopmanagement.exceptions.DuplicateResourceException;
import com.example.laptopmanagement.exceptions.ResourceNotFoundException;
import com.example.laptopmanagement.repository.LaptopRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class LaptopService {
    private final LaptopRepository laptopRepository;

    public LaptopService(LaptopRepository laptopRepository) {
        this.laptopRepository = laptopRepository;
    }

    // CREATE
    @Transactional
    public LaptopResponseDTO createLaptop(LaptopRequestDTO requestDTO) {
        // prevent duplicate laptops - check the serial number
        if (laptopRepository.existsBySerialNumber(requestDTO.serialNumber())) {
            throw new DuplicateResourceException("A laptop with that serial number already exists");
        }

        Laptop laptop = new Laptop();
        laptop.setBrand(requestDTO.brand());
        laptop.setModel(requestDTO.model());
        laptop.setSerialNumber(requestDTO.serialNumber());
        laptop.setLocation(requestDTO.location());
        laptop.setPurchaseDate(requestDTO.purchaseDate());
        laptop.setPurchasePrice(requestDTO.purchasePrice());
        laptop.setStatus(requestDTO.status());

        Laptop savedLaptop = laptopRepository.save(laptop);
        return new LaptopResponseDTO(
                savedLaptop.getId(),
                savedLaptop.getBrand(),
                savedLaptop.getModel(),
                savedLaptop.getSerialNumber(),
                savedLaptop.getLocation(),
                savedLaptop.getPurchaseDate(),
                savedLaptop.getPurchasePrice(),
                savedLaptop.getStatus()
        );
    }

        // READ ALL
        @Transactional(readOnly = true)
        public List <LaptopResponseDTO> getAllLaptops () {
            return laptopRepository.findAll().stream().map( laptop -> new LaptopResponseDTO(
                    laptop.getId(),
                    laptop.getBrand(),
                    laptop.getModel(),
                    laptop.getSerialNumber(),
                    laptop.getLocation(),
                    laptop.getPurchaseDate(),
                    laptop.getPurchasePrice(),
                    laptop.getStatus()
            )).toList();

        }

        // READ ONE
    @Transactional (readOnly = true)
    public LaptopResponseDTO getById (Long id){
        Laptop laptop = findLaptopOrThrowId(id);
        return new LaptopResponseDTO(
                laptop.getId(),
                laptop.getBrand(),
                laptop.getModel(),
                laptop.getSerialNumber(),
                laptop.getLocation(),
                laptop.getPurchaseDate(),
                laptop.getPurchasePrice(),
                laptop.getStatus()
        );

    }

    private Laptop findLaptopOrThrowId (Long id) {
        return laptopRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("This id already exists for a laptop"));
    }

    //UPDATE LAPTOP RECORD

    }


