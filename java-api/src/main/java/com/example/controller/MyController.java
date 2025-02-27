package com.example.controller;

import com.example.entity.MyEntity;
import com.example.repository.MyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MyController {

    @Autowired
    private MyRepository myRepository;

    @GetMapping("/api/data")
    public List<MyEntity> getData() {
        return myRepository.findAll();
    }
}

