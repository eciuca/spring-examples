package com.github.eciuca.workshops.spring.examples;

import com.github.eciuca.workshops.spring.examples.noioc.GreetingManager;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class GreetingsWithSpring {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("greetings-applicationContext.xml");

        GreetingManager manager = (GreetingManager) context.getBean("myGreetingManager");

        manager.sayHello("en");
        manager.sayHello("ro");

    }
}
