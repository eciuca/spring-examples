package com.github.eciuca.workshops.spring.examples.noioc;

public class GreetingManager {

    private final GreetingService enGreetingService;
    private final GreetingService roGreetingService;
    private GreetingService frGreetingService;

    public GreetingManager(GreetingService enGreetingService, GreetingService roGreetingService) {
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
