package com.example.laptopmanagement.controller;
import com.example.laptopmanagement.dto.LaptopRequestDTO;
import com.example.laptopmanagement.dto.LaptopResponseDTO;
import com.example.laptopmanagement.service.LaptopService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/laptops")
public class LaptopController {

    private final LaptopService laptopService;

    public LaptopController(LaptopService laptopService) {
        this.laptopService = laptopService;
    }

    // CREATE
    @PostMapping
    public ResponseEntity<LaptopResponseDTO> createLaptop(@RequestBody LaptopRequestDTO requestDTO) {
        LaptopResponseDTO created = laptopService.createLaptop(requestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    // READ ALL
    @GetMapping
    public ResponseEntity<List<LaptopResponseDTO>> getAllLaptops() {
        return ResponseEntity.ok(laptopService.getAllLaptops());
    }

    // READ ONE
    @GetMapping("/{id}")
    public ResponseEntity<LaptopResponseDTO> getLaptopById(@PathVariable Long id) {
        return ResponseEntity.ok(laptopService.getById(id));
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<LaptopResponseDTO> updateLaptop(@PathVariable Long id, @RequestBody LaptopRequestDTO requestDTO) {
        return ResponseEntity.ok(laptopService.updateLaptop(id, requestDTO));
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLaptop(@PathVariable Long id) {
        laptopService.deleteLaptop(id);
        return ResponseEntity.noContent().build();
    }
}