package com.github.eciuca.workshops.spring.examples.repository;

import com.github.eciuca.workshops.spring.examples.model.Account;
import org.springframework.stereotype.Component;

@Component
public class AccountCsvMapper {

    public String accountToCsvLine(Account account) {
        return String.format("%s,%s,%f", account.getIban(), account.getHolder(), account.getAccountBalance());
    }

    public Account csvLineToAccount(String line) {
        String[] accountProperties = line.split(",");

        Account account = new Account();
        account.setIban(accountProperties[0]);
        account.setHolder(accountProperties[1]);
        account.setAccountBalance(Double.parseDouble(accountProperties[2]));

        return account;
    }
}
