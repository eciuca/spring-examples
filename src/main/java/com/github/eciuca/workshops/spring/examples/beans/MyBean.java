package com.github.eciuca.workshops.spring.examples.beans;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class MyBean {

    private String name;

    public void setName(String name){
        this.name = name;
    }

    public String getGreeting(){
        return "Hello, " + name;
    }

    @PostConstruct
    public void defaultIfEmpty() {
        System.out.println("Initializing bean...");
        this.name = "world!";
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Destroying bean...");
    }
}
