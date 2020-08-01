package com.github.eciuca.workshops.spring.examples;

import com.github.eciuca.workshops.spring.examples.config.GreetingsConfig;
import com.github.eciuca.workshops.spring.examples.noioc.GreetingManager;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class GreetingsWithSpring {

    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(GreetingsConfig.class);

        GreetingManager greetingManager = context.getBean(GreetingManager.class);

        greetingManager.sayHello("en");
        greetingManager.sayHello("ro");

    }
}
