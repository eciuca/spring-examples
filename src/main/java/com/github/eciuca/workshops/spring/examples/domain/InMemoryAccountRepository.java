package com.github.eciuca.workshops.spring.examples.domain;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@Qualifier("in-memory")
public class InMemoryAccountRepository implements AccountRepository {

    private List<Account> accountList = new ArrayList<>();

    @Override
    public Account save(Account account) {
        accountList.add(account);

        return account;
    }

    @Override
    public List<Account> findAll() {
        return accountList;
    }
}
