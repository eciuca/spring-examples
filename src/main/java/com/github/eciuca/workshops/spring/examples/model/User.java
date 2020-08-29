package com.github.eciuca.workshops.spring.examples.model;

import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User extends AbstractPersistable<Long> {

    public void setId(Long id) {
        super.setId(id);
    }

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
