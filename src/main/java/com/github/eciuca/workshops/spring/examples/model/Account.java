package com.github.eciuca.workshops.spring.examples.model;

public class Account {

    private String iban;
    private String holder;
    private double balance;

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public String getHolder() {
        return holder;
    }

    public void setHolder(String holder) {
        this.holder = holder;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "iban='" + iban + '\'' +
                ", holder='" + holder + '\'' +
                ", balance=" + balance +
                '}';
    }
}
