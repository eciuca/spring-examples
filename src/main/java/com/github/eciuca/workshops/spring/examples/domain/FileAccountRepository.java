package com.github.eciuca.workshops.spring.examples.domain;

import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private AccountCsvMapper mapper;

    @Override
    public Account save(Account account) {
        String accountAsCsvLine = mapper.accountToCsvLine(account);

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
                    .map(line -> mapper.csvLineToAccount(line))
//                    .map(mapper::csvLineToAccount)
                    .collect(Collectors.toList());

            return accountList;
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Could not read accounts from csv", e);
        }
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
