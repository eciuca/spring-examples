package com.github.eciuca.workshops.spring.examples;

import com.github.eciuca.workshops.spring.examples.controller.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
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
public class Application implements CommandLineRunner {

    @Value("${environment}")
    private String environment;

    @Autowired
    private AccountController controller;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);

    }

    @Override
    public void run(String... args) throws Exception {
        boolean isATest = environment.equals("test");

        if (isATest) {
            System.out.println("This is a test, controller.start() will not be called!");
        } else {
            controller.start();
        }
    }
}
