package com.luciaricciuti.greencure.api.config;

import com.luciaricciuti.greencure.api.model.Plant;
import com.luciaricciuti.greencure.api.repository.PlantRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(PlantRepository repository) {
        return args -> {
            log.info("Preloading " + repository.save(new Plant("Lavander")));
            log.info("Preloading " + repository.save(new Plant("Rosemary")));
        };
    }
}
