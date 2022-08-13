package com.example.autoria.dao;

import com.example.autoria.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDAO extends JpaRepository<UserModel, Integer> {
}
