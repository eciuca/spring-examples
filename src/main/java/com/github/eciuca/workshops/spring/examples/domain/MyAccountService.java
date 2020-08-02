package com.github.eciuca.workshops.spring.examples.domain;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MyAccountService implements AccountService {

    private List<Account> accountList = new ArrayList<>();

    public Account newAccount(String iban, String holder, double balance) {
        Account account = new Account();

        account.setIban(iban);
        account.setHolder(holder);
        account.setBalance(balance);

        accountList.add(account);

        return account;
    }

    public void displayAccounts() {
        for (Account account : accountList) {
            System.out.println(account);
        }

//        accountList.forEach(System.out::println);
    }
}
