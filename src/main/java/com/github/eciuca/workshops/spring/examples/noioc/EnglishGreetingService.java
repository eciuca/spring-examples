package com.github.eciuca.workshops.spring.examples.noioc;

import org.springframework.stereotype.Service;

@Service
public class EnglishGreetingService extends GreetingService {

    public EnglishGreetingService() {
        super("Hello");
    }
}
