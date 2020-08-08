package com.github.eciuca.workshops.spring.examples.service;

import com.github.eciuca.workshops.spring.examples.model.Account;
import com.github.eciuca.workshops.spring.examples.model.AccountHolderOnly;
import com.github.eciuca.workshops.spring.examples.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MyAccountService implements AccountService {

    @Autowired
    private AccountRepository repository;

    public Account newAccount(String iban, String holder, double balance) {
        Account account = new Account();

        account.setIban(iban);
        account.setHolder(holder);
        account.setBalance(balance);

        repository.save(account);

        return account;
    }

    public void displayAccounts() {
        Iterable<Account> accountList = repository.findAll();

        Long totalNoOfAccounts = repository.count();

        System.out.println("Total no of accounts : " + totalNoOfAccounts);
        for (Account account : accountList) {
            System.out.println(account);
        }

//        accountList.forEach(System.out::println);
    }

    @Override
    public Optional<Account> searchByIban(String iban) {
        if (iban == null || iban.isEmpty()) {
            throw new IllegalArgumentException("Please provide a non empty iban");
        }

        return repository.findByIban(iban);
    }

    @Override
    public Double totalAccountsBalanceByHolder(String holder) {
        return repository.getTotalForAllAccountsByHolder(holder);
    }

    @Override
    public List<Account> getAllAccountsByBalanceDescending() {
        Sort sortByHolderAscending = Sort.TypedSort.sort(Account.class).by(Account::getHolder).ascending();
        Sort sortByBalanceDescending = Sort.TypedSort
                .sort(Account.class)
                .by(Account::getBalance)
                .descending();

        Sort sort = sortByHolderAscending.and(sortByBalanceDescending);

        List<Account> all = repository.findAll(sort);
        all.forEach(System.out::println);

        return all;
    }

    @Override
    public List<AccountHolderOnly> displayAllAccountHolders() {
        List<AccountHolderOnly> allHolders = repository.findAllByOrderByHolder();

        for (AccountHolderOnly holder : allHolders) {
            System.out.println(holder.getHolder());
        }

        return allHolders;
    }
}
