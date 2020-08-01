package com.github.eciuca.workshops.spring.examples.noioc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.inject.Inject;

@Component
public class GreetingManager {

    @Inject
    private EnglishGreetingService enGreetingService;
    @Inject
    private RomanianGreetingService roGreetingService;

    private GreetingService frGreetingService;


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
