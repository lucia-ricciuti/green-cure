package com.luciaricciuti.greencure.api.controller;

import com.luciaricciuti.greencure.api.exception.PlantNotFoundException;
import com.luciaricciuti.greencure.api.model.Plant;
import com.luciaricciuti.greencure.api.repository.PlantRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PlantController {

    private final PlantRepository repository;

    public PlantController(PlantRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/plants")
    public List<Plant> all() {
        return repository.findAll();
    }

    @PostMapping("/plants")
    public Plant create(@RequestBody Plant newPlant) {
        return repository.save(newPlant);
    }

    @GetMapping("/plants/{id}")
    public Plant one(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new PlantNotFoundException(id));
    }

    @PutMapping("/plants/{id}")
    public Plant update(@RequestBody Plant newPlant, @PathVariable  Long id) {
        return repository.findById(id)
                .map(plant -> {
                    plant.setName(newPlant.getName());
                    return repository.save(plant);
                })
                .orElseGet(() -> repository.save(newPlant));
    }

    @DeleteMapping("/plants/{id}")
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }

}
