package com.example.autoria.services;

import com.example.autoria.dao.CarDAO;
import com.example.autoria.dto.CarResponseDTO;
import com.example.autoria.models.CarModel;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class CarService {
    private CarDAO carDAO;

    public List<CarResponseDTO> getAll() {

        List<CarModel> cars = carDAO.findAll();
        List<CarResponseDTO> newCars = new ArrayList<>();
        for (CarModel car : cars) {
            CarResponseDTO dto = new CarResponseDTO(car);
            newCars.add(dto);
        }
        return newCars;
    }

    public void createCar(String description, Integer year, Integer price, MultipartFile file) throws IOException {
        String filename = file.getOriginalFilename();
        String userHome = System.getProperty("user.home");
        File dest = new File(userHome + File.separator + "newfiles" + File.separator + filename);
        file.transferTo(dest);
        CarModel car = new CarModel(description, year, price, filename);
        carDAO.save(car);
    }
}
