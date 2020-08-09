package com.github.eciuca.workshops.spring.examples;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Bank Account Management Application
 * <p>
 * Functionalitati:
 * - creare cont
 * - afisare lista conturi
 * - salvare lista conturi (in memorie / pe disk)
 *
 * Utilizator (UI)
 *
 *      PRESENTATION - controller
 *      BUSINESS     - service
 *      PERSISTENCE  - repository (Dao, Spring repositories, Jdbc)
 *      DOMAIN       - model
 *
 * Disk
 */
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
