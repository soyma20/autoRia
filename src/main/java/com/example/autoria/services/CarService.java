package com.example.autoria.services;

import com.example.autoria.dao.CarDAO;
import com.example.autoria.dto.CarResponseDTO;
import com.example.autoria.models.CarModel;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class CarService {
    private CarDAO carDAO;

    public List<CarResponseDTO> getAll(){

        List<CarModel> cars = carDAO.findAll();
        List<CarResponseDTO> newCars = new ArrayList<>();
        for (CarModel car : cars) {
            CarResponseDTO dto = new CarResponseDTO(car);
            newCars.add(dto);
        }
        return newCars;
    }
}
