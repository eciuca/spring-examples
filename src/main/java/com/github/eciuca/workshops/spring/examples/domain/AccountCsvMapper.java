package com.github.eciuca.workshops.spring.examples.domain;

import org.springframework.stereotype.Component;

@Component
public class AccountCsvMapper {

    public String accountToCsvLine(Account account) {
        return String.format("%s,%s,%f", account.getIban(), account.getHolder(), account.getBalance());
    }

    public Account csvLineToAccount(String line) {
        String[] accountProperties = line.split(",");

        Account account = new Account();
        account.setIban(accountProperties[0]);
        account.setHolder(accountProperties[1]);
        account.setBalance(Double.parseDouble(accountProperties[2]));

        return account;
    }
}
