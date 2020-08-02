package com.github.eciuca.workshops.spring.examples.domain;

/**
 * Functionalitati:
 *  - creare cont
 *  - afisare lista conturi
 */
public interface AccountService {

    Account newAccount(String iban, String holder, double balance);

    void displayAccounts();
}
