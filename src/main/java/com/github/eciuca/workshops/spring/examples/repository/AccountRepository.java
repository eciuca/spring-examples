package com.github.eciuca.workshops.spring.examples.repository;

import com.github.eciuca.workshops.spring.examples.model.Account;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<Account, Long> {

}
