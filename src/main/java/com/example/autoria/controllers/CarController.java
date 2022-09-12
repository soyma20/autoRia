package com.example.autoria.controllers;

import com.example.autoria.dao.CarDAO;
import com.example.autoria.dto.CarResponseDTO;
import com.example.autoria.models.CarModel;
import com.example.autoria.models.Currency;
import com.example.autoria.models.Roles;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/cars")
public class CarController {
    private CarDAO carDAO;

    @GetMapping
    public ResponseEntity<List<CarResponseDTO>> getAll() {
        List<CarModel> cars = carDAO.findAll();
        List<CarResponseDTO> newCars = new ArrayList<>();
        for (CarModel car : cars) {
            CarResponseDTO dto = new CarResponseDTO(car);
            newCars.add(dto);
        }
        return new ResponseEntity<>(newCars, HttpStatus.OK);
    }

    @PostMapping
    public void create(@RequestParam String description,
                       @RequestParam Integer year,
                       @RequestParam Integer price,
                       @RequestParam MultipartFile file) throws IOException {
        String filename = file.getOriginalFilename();
        String userHome = System.getProperty("user.home");
        File dest = new File(userHome + File.separator + "newfiles" + File.separator + filename);
        file.transferTo(dest);
        CarModel car = new CarModel(description, year, price, filename);
        carDAO.save(car);
    }

}