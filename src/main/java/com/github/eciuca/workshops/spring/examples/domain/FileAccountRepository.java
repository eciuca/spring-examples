package com.github.eciuca.workshops.spring.examples.domain;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Repository
@Qualifier("file")
public class FileAccountRepository implements AccountRepository {

    @Value("classpath:accounts.csv")
    private Resource accountsFile;

    @Override
    public Account save(Account account) {
        String accountAsCsvLine = accountToCsvLine(account);

        Path filePath = getResourceAsPath();
        try {
            Files.write(filePath, Arrays.asList(accountAsCsvLine), StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Could not write account to csv", e);
        }

        return account;
    }

    @Override
    public List<Account> findAll() {
        Path filePath = getResourceAsPath();

        try {
            List<Account> accountList = Files.readAllLines(filePath).stream()
                    .map(line -> csvLineToAccount(line))
//                    .map(this::csvLineToAccount)
                    .collect(Collectors.toList());

            return accountList;
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Could not read accounts from csv", e);
        }
    }

    private String accountToCsvLine(Account account) {
        return String.format("%s,%s,%f", account.getIban(), account.getHolder(), account.getBalance());
    }

    private Account csvLineToAccount(String line) {
        String[] accountProperties = line.split(",");

        Account account = new Account();
        account.setIban(accountProperties[0]);
        account.setHolder(accountProperties[1]);
        account.setBalance(Double.parseDouble(accountProperties[2]));

        return account;
    }

    private Path getResourceAsPath() {
        try {
            return accountsFile.getFile().toPath();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("The accounts file is missing", e);
        }
    }
}
