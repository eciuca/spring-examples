package com.github.eciuca.workshops.spring.examples.service;

import com.github.eciuca.workshops.spring.examples.model.Account;

/**
 * Functionalitati:
 *  - creare cont
 *  - afisare lista conturi
 */
public interface AccountService {

    Account newAccount(String iban, String holder, double balance);

    void displayAccounts();
}
