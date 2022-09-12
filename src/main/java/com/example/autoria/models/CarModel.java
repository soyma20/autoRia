package com.example.autoria.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class CarModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String description;
    private int year;
    private int price;
    @Enumerated(value = EnumType.STRING)
    private Currency currency;
    private String imagePath; //name of file

    public CarModel(String description, int year, int price,  String imagePath) {
        this.description = description;
        this.year = year;
        this.price = price;

        this.imagePath = imagePath;
    }
}
