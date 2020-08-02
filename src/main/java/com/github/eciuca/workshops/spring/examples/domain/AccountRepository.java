package com.github.eciuca.workshops.spring.examples.domain;

import java.util.List;

public interface AccountRepository {

    Account save(Account account);

    List<Account> findAll();
}
