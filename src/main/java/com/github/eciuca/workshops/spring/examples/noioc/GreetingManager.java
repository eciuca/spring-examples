package com.github.eciuca.workshops.spring.examples.noioc;

public class GreetingManager {

    private final EnglishGreetingService enGreetingService;
    private final RomanianGreetingService roGreetingService;
    private RomanianGreetingService frGreetingService;

    public GreetingManager(EnglishGreetingService enGreetingService, RomanianGreetingService roGreetingService) {
        this.enGreetingService = enGreetingService;
        this.roGreetingService = roGreetingService;
    }


    public void sayHello(String language) {
        if (language.equals("en")) {
            enGreetingService.sayHello();
        } else {
            roGreetingService.sayHello();
        }
    }

    public void setFrGreetingService(RomanianGreetingService frGreetingService) {
        this.frGreetingService = frGreetingService;
    }
}
