package com.github.eciuca.workshops.spring.examples.config;

import com.github.eciuca.workshops.spring.examples.beans.MyBean;
import com.github.eciuca.workshops.spring.examples.noioc.GreetingManager;
import com.github.eciuca.workshops.spring.examples.noioc.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;

@Configuration
@Import(AppConfig.class)
@PropertySource("classpath:greetings.properties")
public class GreetingsConfig {

    @Autowired
    Environment environment;

    @Bean
    public GreetingManager greetingManager(@Qualifier("English") GreetingService service,
                                           @Qualifier("Romanian") GreetingService service2) {
        return new GreetingManager(service, service2);
    }

    @Bean
    @Qualifier("English")
    public GreetingService englishGreetingService() {
        return new GreetingService(environment.getProperty("greetings.english"));
    }

    @Bean
    @Qualifier("Romanian")
    public GreetingService romanianGreetingService() {
        return new GreetingService(environment.getProperty("greetings.romanian"));
    }

}
