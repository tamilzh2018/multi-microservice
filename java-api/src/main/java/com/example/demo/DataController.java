package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/data")
public class DataController {

    @Autowired
    private DataRepository dataRepository;

    @GetMapping
    public List<DataEntity> getAllData() {
        return dataRepository.findAll();
    }

    @PostMapping
    public DataEntity createData(@RequestBody DataEntity dataEntity) {
        return dataRepository.save(dataEntity);
    }

    @GetMapping("/{id}")
    public DataEntity getDataById(@PathVariable Long id) {
        return dataRepository.findById(id).orElseThrow(() -> new RuntimeException("Data not found"));
    }
}

