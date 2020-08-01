package com.github.eciuca.workshops.spring.examples.noioc;

import org.springframework.stereotype.Service;

@Service
public class RomanianGreetingService extends GreetingService {

    public RomanianGreetingService() {
        super("Salut");
    }
}
