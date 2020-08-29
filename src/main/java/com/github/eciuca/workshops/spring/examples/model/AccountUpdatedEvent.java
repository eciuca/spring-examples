package com.github.eciuca.workshops.spring.examples.model;

public class AccountUpdatedEvent {
    private final Account account;

    public AccountUpdatedEvent(Account account) {
        this.account = account;
    }

    public Account getAccount() {
        return account;
    }
}
