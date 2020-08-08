package com.github.eciuca.workshops.spring.examples.service;

import com.github.eciuca.workshops.spring.examples.model.Account;
import com.github.eciuca.workshops.spring.examples.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyAccountService implements AccountService {

    @Autowired
    private AccountRepository repository;

    public Account newAccount(String iban, String holder, double balance) {
        Account account = new Account();

        account.setIban(iban);
        account.setHolder(holder);
        account.setAccountBalance(balance);

        repository.save(account);

        return account;
    }

    public void displayAccounts() {
        Iterable<Account> accountList = repository.findAll();

        for (Account account : accountList) {
            System.out.println(account);
        }

//        accountList.forEach(System.out::println);
    }
}
