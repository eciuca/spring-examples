package com.github.eciuca.workshops.spring.examples;

import com.github.eciuca.workshops.spring.examples.beans.MyBean;
import com.github.eciuca.workshops.spring.examples.config.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        MyBean myBean = context.getBean(MyBean.class);

        System.out.println(myBean.getGreeting());
    }
}
