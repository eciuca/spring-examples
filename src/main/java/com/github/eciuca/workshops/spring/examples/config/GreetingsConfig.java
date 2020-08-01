package com.github.eciuca.workshops.spring.examples.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

@Configuration
@Import(AppConfig.class)
@PropertySource("classpath:greetings.properties")
@ComponentScan("com.github.eciuca.workshops.spring.examples.noioc")
public class GreetingsConfig {

}
