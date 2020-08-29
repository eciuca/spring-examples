package com.github.eciuca.workshops.spring.examples.repository;

import com.github.eciuca.workshops.spring.examples.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    Optional<User> findByName(String name);
}
