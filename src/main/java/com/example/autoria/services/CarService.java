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
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CarService {
    private CarDAO carDAO;

    public List<CarResponseDTO> getAll() {
        return carDAO.findAll().stream().map(CarResponseDTO::new).collect(Collectors.toList());
    }
    public CarResponseDTO getById(Integer id) {
        return carDAO.findById(id).map(CarResponseDTO::new).get();
    }

    public void createCar(String description, Integer year, Integer price, MultipartFile file) throws IOException {
        file.transferTo(new File(System.getProperty("user.home") + File.separator + "newfiles" + File.separator + file.getOriginalFilename()));
        CarModel car = new CarModel(description, year, price, file.getOriginalFilename());
        carDAO.save(car);
    }
    public void updateCar(CarModel carModel){
        carDAO.save(carModel);
    }
    public void deleteCar(Integer id){
        carDAO.deleteById(id);
    }
}
