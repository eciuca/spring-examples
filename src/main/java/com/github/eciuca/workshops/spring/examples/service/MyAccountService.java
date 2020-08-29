package com.github.eciuca.workshops.spring.examples.service;

import com.github.eciuca.workshops.spring.examples.model.Account;
import com.github.eciuca.workshops.spring.examples.model.AccountHolderOnly;
import com.github.eciuca.workshops.spring.examples.model.AccountUpdatedEvent;
import com.github.eciuca.workshops.spring.examples.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class MyAccountService implements AccountService {

    @Autowired
    private AccountRepository repository;
    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    @Override
    public List<Account> getAllAccounts() {
        return repository.findAll(Sort.unsorted());
    }

    public Account newAccount(String iban, String holder, double balance) {
        Account account = new Account();

        account.setIban(iban);
        account.setHolder(holder);
        account.setBalance(balance);

        repository.save(account);

        return account;
    }

    @Override
    public Account newAccount(Account account) { //DRY - Dont Repeat Yourself
        int ibanNumber = (int) (Math.random() * 1_000_000);
        String iban = "RO" + ibanNumber;

        return newAccount(iban, account.getHolder(), account.getBalance());
    }

    @Override
    public Account updateAccount(Account account) {
        Account accountFromDB = repository.findById(account.getId())
                .orElseThrow(() -> new RuntimeException("Account not found"));

        accountFromDB.setHolder(account.getHolder());
        accountFromDB.setBalance(account.getBalance());
        accountFromDB.setIban(account.getIban());

        applicationEventPublisher.publishEvent(new AccountUpdatedEvent(accountFromDB));

        return accountFromDB;
    }

    @Override
    @Transactional
    public Account deposit(Long accountId, Double amount) {
        Account account = repository.findById(accountId).orElseThrow(() -> new RuntimeException("Account not found"));
        account.deposit(amount);

        return account;
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
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
