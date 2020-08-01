package com.github.eciuca.workshops.spring.examples.beans;

public class MyBean {

    private String name;

    public void setName(String name){
        this.name = name;
    }

    public String getGreeting(){
        return "Hello, " + name;
    }

    public void defaultIfEmpty() {
        System.out.println("Initializing bean...");
        this.name = "world!";
    }

    public void destroy() {
        System.out.println("Destroying bean...");
    }
}
