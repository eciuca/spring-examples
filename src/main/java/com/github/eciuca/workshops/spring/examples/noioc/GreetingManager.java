package com.github.eciuca.workshops.spring.examples.noioc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GreetingManager {

    private final EnglishGreetingService enGreetingService;
    private final RomanianGreetingService roGreetingService;
    private GreetingService frGreetingService;

    @Autowired
    public GreetingManager(EnglishGreetingService enGreetingService, RomanianGreetingService roGreetingService) {
        this.enGreetingService = enGreetingService;
        this.roGreetingService = roGreetingService;
    }


    public void sayHello(String language) {
        if (language.equals("en")) {
            System.out.print("greeting in english: ");
            enGreetingService.sayHello();
        } else {
            System.out.print("greeting in romanian: ");
            roGreetingService.sayHello();
        }
    }

    public void setFrGreetingService(GreetingService frGreetingService) {
        this.frGreetingService = frGreetingService;
    }
}
