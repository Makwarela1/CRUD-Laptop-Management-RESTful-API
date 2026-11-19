package com.example.laptopmanagement.controller;

import com.example.laptopmanagement.entity.Laptop;
import com.example.laptopmanagement.service.LaptopService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/students")

public class LaptopController {

    private final LaptopService laptopService;

    public LaptopController (LaptopService laptopService){
        this.laptopService = laptopService;
    }

    //CREATE
    @PostMapping
    public

    //READ
    @GetMapping


    //UPDATE
    @PutMapping

    //DELETE
    @DeleteMapping

}
