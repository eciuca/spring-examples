package com.github.eciuca.workshops.spring.examples.config;

import com.github.eciuca.workshops.spring.examples.beans.MyBean;
import com.github.eciuca.workshops.spring.examples.noioc.GreetingManager;
import com.github.eciuca.workshops.spring.examples.noioc.GreetingService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Scope;

@Configuration
@Import(AppConfig.class)
public class GreetingsConfig {

    @Bean
    public GreetingManager greetingManager() {
        return new GreetingManager(englishGreetingService(), romanianGreetingService());
    }

    @Bean
    public GreetingService englishGreetingService() {
        return new GreetingService("Hello");
    }

    @Bean
    public GreetingService romanianGreetingService() {
        return new GreetingService("Salut");
    }

}
