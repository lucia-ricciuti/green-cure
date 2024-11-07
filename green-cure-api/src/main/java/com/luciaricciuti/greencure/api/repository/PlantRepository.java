package com.luciaricciuti.greencure.api.repository;

import com.luciaricciuti.greencure.api.model.Plant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlantRepository extends JpaRepository<Plant, Long> {
}
