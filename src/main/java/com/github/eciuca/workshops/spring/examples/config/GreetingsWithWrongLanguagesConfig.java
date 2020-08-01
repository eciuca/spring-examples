package com.github.eciuca.workshops.spring.examples.config;

import com.github.eciuca.workshops.spring.examples.noioc.GreetingManager;
import com.github.eciuca.workshops.spring.examples.noioc.GreetingService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;

@Configuration
@Import(AppConfig.class)
@Profile("wrong")
public class GreetingsWithWrongLanguagesConfig {

    @Bean
    public GreetingManager greetingManager(@Qualifier("English") GreetingService service,
                                           @Qualifier("Romanian") GreetingService service2) {
        return new GreetingManager(service, service2);
    }

    @Bean
    @Qualifier("English")
    public GreetingService englishGreetingService() {
        return new GreetingService("Hallo");
    }

    @Bean
    @Qualifier("Romanian")
    public GreetingService romanianGreetingService() {
        return new GreetingService("Ohayou");
    }

}
