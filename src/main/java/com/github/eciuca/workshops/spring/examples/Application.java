package com.github.eciuca.workshops.spring.examples;

import com.github.eciuca.workshops.spring.examples.beans.MyBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        MyBean service = (MyBean) context.getBean("myBean");
        System.out.println(service.sayHello());

        service.setName("Spring first application");
        System.out.println(service.sayHello());
    }
}
