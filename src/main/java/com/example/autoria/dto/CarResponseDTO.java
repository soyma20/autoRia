package com.example.autoria.dto;

import com.example.autoria.models.CarModel;
import com.example.autoria.models.Currency;
import com.example.autoria.models.ImagePath;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarResponseDTO {
    private int car_id;
    private String description;
    private int year;
    private int price;
    @Enumerated(value = EnumType.STRING)
    private Currency currency;
    private List<ImagePath> imagesPath; //name of file

    public CarResponseDTO(CarModel carModel){
        this.car_id= carModel.getId();
        this.description = carModel.getDescription();
        this.year = carModel.getYear();
        this.price = carModel.getPrice();
        this.imagesPath = carModel.getImagesPath();
    }
}
