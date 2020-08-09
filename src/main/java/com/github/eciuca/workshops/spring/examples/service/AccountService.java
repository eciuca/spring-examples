package com.github.eciuca.workshops.spring.examples.service;

import com.github.eciuca.workshops.spring.examples.model.Account;
import com.github.eciuca.workshops.spring.examples.model.AccountHolderOnly;

import java.util.List;
import java.util.Optional;

/**
 * Functionalitati:
 *  - creare cont
 *  - afisare lista conturi
 */
public interface AccountService {

    Account newAccount(String iban, String holder, double balance);

    Account newAccount(Account account);

    void deleteById(Long id);

    void displayAccounts();

    Optional<Account> searchByIban(String iban);

    Double totalAccountsBalanceByHolder(String holder);

    List<Account> getAllAccountsByBalanceDescending();

    List<AccountHolderOnly> displayAllAccountHolders();
}
