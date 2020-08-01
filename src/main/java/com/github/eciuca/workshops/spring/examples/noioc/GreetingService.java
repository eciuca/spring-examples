package com.github.eciuca.workshops.spring.examples.noioc;

public class GreetingService {

    private final String greeting;

    public GreetingService(String greeting) {
        this.greeting = greeting;
    }

    public void sayHello() {
        System.out.println(greeting);
    }
}
