package com.github.eciuca.workshops.spring.examples;

import com.github.eciuca.workshops.spring.examples.model.AccountUpdatedEvent;
import com.github.eciuca.workshops.spring.examples.model.User;
import com.github.eciuca.workshops.spring.examples.repository.UserRepository;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.Optional;

import static com.github.eciuca.workshops.spring.examples.Application.ANONYMOUS_USER_NAME;

@Component
public class EventHandler {

    private final UserRepository userRepository;

    public EventHandler(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @EventListener
    public void createAnonymousUserIfMissing(ContextRefreshedEvent event) {
        Optional<User> anonymousUserOptional = userRepository.findByName(ANONYMOUS_USER_NAME);

        if (!anonymousUserOptional.isPresent()) {
            User anonymousUser = new User();
            anonymousUser.setName(ANONYMOUS_USER_NAME);

            userRepository.save(anonymousUser);
        }

    }

    @EventListener
    public void onAccountUpdated(AccountUpdatedEvent event) {
        System.out.println(event.getAccount().getIban() + " was updated!");
    }
}
