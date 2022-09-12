package com.example.autoria.dao;

import com.example.autoria.models.CarModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarDAO extends JpaRepository<CarModel, Integer> {
}
