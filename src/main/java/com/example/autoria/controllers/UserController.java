package com.example.autoria.controllers;


import com.example.autoria.dao.UserDAO;
import com.example.autoria.models.UserModel;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {
    private UserDAO userDAO;

    @GetMapping
    public List<UserModel> getAll() {
        return userDAO.findAll();
    }

    @PostMapping
    public UserModel create(@RequestBody UserModel user) {
        return userDAO.save(user);
    }
}
