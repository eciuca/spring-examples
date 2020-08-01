package com.github.eciuca.workshops.spring.examples.config;

import com.github.eciuca.workshops.spring.examples.beans.MyBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public MyBean mybean() {
        MyBean myBean = new MyBean();
        myBean.setName("world");
        return myBean;
    }
}
