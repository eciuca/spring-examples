package com.github.eciuca.workshops.spring.examples.repository;

import com.github.eciuca.workshops.spring.examples.model.Account;

import java.util.List;

public interface AccountRepository {

    Account save(Account account);

    List<Account> findAll();
}
