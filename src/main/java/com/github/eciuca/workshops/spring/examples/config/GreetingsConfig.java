package com.github.eciuca.workshops.spring.examples.config;

import com.github.eciuca.workshops.spring.examples.noioc.GreetingManager;
import com.github.eciuca.workshops.spring.examples.noioc.GreetingService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GreetingsConfig {

    @Bean
    public GreetingManager greetingManager(@Qualifier("English") GreetingService service,
                                           @Qualifier("Romanian") GreetingService service2) {
        return new GreetingManager(service, service2);
    }

    @Bean
    @Qualifier("English")
    public GreetingService englishGreetingService() {
        return new GreetingService("Hello");
    }

    @Bean
    @Qualifier("Romanian")
    public GreetingService romanianGreetingService() {
        return new GreetingService("Salut");
    }
}
