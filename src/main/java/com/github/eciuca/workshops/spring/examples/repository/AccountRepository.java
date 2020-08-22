package com.github.eciuca.workshops.spring.examples.repository;

import com.github.eciuca.workshops.spring.examples.model.Account;
import com.github.eciuca.workshops.spring.examples.model.AccountHolderOnly;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;
import java.util.Optional;

public interface AccountRepository extends PagingAndSortingRepository<Account, Long> {

    Optional<Account> findByIban(String iban);

    Optional<Account> findByIbanAndHolder(String iban, String holder);

    List<Account> findAllByBalanceGreaterThan(Double minimumBalance);

    @Query("Select sum(a.balance) from Account a where a.holder = :holder")
    Double getTotalForAllAccountsByHolder(String holder);

    List<Account> findAll(Sort sort);

    List<AccountHolderOnly> findAllByOrderByHolder();
}
