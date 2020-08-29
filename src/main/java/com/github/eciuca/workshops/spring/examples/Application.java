package com.github.eciuca.workshops.spring.examples;

import com.github.eciuca.workshops.spring.examples.model.User;
import com.github.eciuca.workshops.spring.examples.repository.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationContextInitializedEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.EventListener;
import org.springframework.data.auditing.DateTimeProvider;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAccessor;
import java.util.Optional;

/**
 * Bank Account Management Application
 * <p>
 * Functionalitati:
 * - creare cont
 * - afisare lista conturi
 * - salvare lista conturi (in memorie / pe disk)
 *
 * Utilizator (UI)
 *
 *      PRESENTATION - controller
 *      BUSINESS     - service
 *      PERSISTENCE  - repository (Dao, Spring repositories, Jdbc)
 *      DOMAIN       - model
 *
 * Disk
 */
@EnableJpaAuditing
@SpringBootApplication
public class Application {

    public static final String ANONYMOUS_USER_NAME = "anonymous";

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public AuditorAware<User> myAuditorAware(UserRepository userRepository) {
        return () -> {
            User user = new User();
            user.setId(1L);
            return Optional.of(user);
        };
    }
}
