package com.github.eciuca.workshops.spring.examples;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
@TestPropertySource(locations = "classpath:application-test.properties")
public class ApplicationTests {

    @Test
    void contextLoads() {

    }
}
