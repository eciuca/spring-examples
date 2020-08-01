package com.github.eciuca.workshops.spring.examples;

import com.github.eciuca.workshops.spring.examples.beans.MyBean;
import com.github.eciuca.workshops.spring.examples.noioc.GreetingManager;
import com.github.eciuca.workshops.spring.examples.noioc.GreetingService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class GreetingsWithSpring {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("greetings-applicationContext.xml");

        GreetingManager manager = (GreetingManager) context.getBean("myGreetingManager");
        GreetingManager manager2 = (GreetingManager) context.getBean("myGreetingManager");

        GreetingService englishGreetingServiceBean = (GreetingService) context.getBean("englishGreetingServiceBean");
        GreetingService romanianGreetingServiceBean = (GreetingService) context.getBean("romanianGreetingServiceBean");
        GreetingManager manager3 = new GreetingManager(englishGreetingServiceBean, romanianGreetingServiceBean);

        MyBean myBean1 = (MyBean) context.getBean("mybean");
        MyBean myBean2 = (MyBean) context.getBean("mybean");

        manager.sayHello("en");
        manager.sayHello("ro");

        System.out.println(myBean1.getGreeting());

    }
}
