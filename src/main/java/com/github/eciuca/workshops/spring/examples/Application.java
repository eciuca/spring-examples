package com.github.eciuca.workshops.spring.examples;

import com.github.eciuca.workshops.spring.examples.config.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Bank Account Management Application
 *
 * Functionalitati:
 *  - creare cont
 *  - afisare lista conturi
 *  - salvare lista conturi (in memorie / pe disk)
 *
 *
 *
 */
public class Application {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);


    }
}
