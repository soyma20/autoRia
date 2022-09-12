package com.example.autoria.dto;

import com.example.autoria.models.CarModel;
import com.example.autoria.models.Currency;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarResponseDTO {
    private String description;
    private int year;
    private int price;
    @Enumerated(value = EnumType.STRING)
    private Currency currency;
    private String imagePath; //name of file

    public CarResponseDTO(CarModel carModel){
        this.description = carModel.getDescription();
        this.year = carModel.getYear();
        this.price = carModel.getPrice();
        this.imagePath = carModel.getImagePath();
    }
}
