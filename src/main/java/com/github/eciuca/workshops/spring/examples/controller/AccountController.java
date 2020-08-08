package com.github.eciuca.workshops.spring.examples.controller;

import com.github.eciuca.workshops.spring.examples.model.Account;
import com.github.eciuca.workshops.spring.examples.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.Optional;
import java.util.Scanner;

@Controller
public class AccountController {

    @Autowired
    private AccountService service;

    public void start() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            displayMenu();
            int option = readOption(scanner);

            switch (option) {
                case 1:
                    newAccountOption(scanner);
                    break;
                case 2:
                    displayAccountsOption();
                    break;
                case 3:
                    searchAccountsOption(scanner);
                    break;
                case 4:
                    accountsStatement(scanner);
                    break;
                case 0:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Please choose one of the valid options!");
            }
        }
    }

    private void displayAccountsOption() {
        System.out.println("This is the list of available accounts");
        service.displayAllAccountHolders();
    }

    private void newAccountOption(Scanner scanner) {
        System.out.println("Please provide the new account details:");
        int ibanNumber = (int) (Math.random() * 1_000_000);
        String iban = "RO" + ibanNumber;

        System.out.print("Holder: ");
        String accountHolder = scanner.nextLine();

        System.out.print("Initial balance: ");
        double accountBalance = scanner.nextDouble();

        service.newAccount(iban, accountHolder, accountBalance);
    }

    private void searchAccountsOption(Scanner scanner) {
        System.out.println("Please provide an iban:");
        String iban = scanner.nextLine();

        Optional<Account> accountOptional = service.searchByIban(iban);

        if (accountOptional.isPresent()) {
            Account account = accountOptional.get();
            System.out.println(account);
        } else {
            System.out.println("There is no account with iban " + iban);
        }

    }

    private void accountsStatement(Scanner scanner) {
        System.out.println("Please provide the name of the account(s) holder:");
        String holder = scanner.nextLine();

        Double totalBalance = service.totalAccountsBalanceByHolder(holder);
        System.out.println("The total balance of all your accounts is " + totalBalance);
    }

    private int readOption(Scanner scanner) {
        int option = scanner.nextInt();
        scanner.nextLine();

        return option;
    }

    private void displayMenu() {
        System.out.println("");
        System.out.println("1. New account");
        System.out.println("2. Display accounts");
        System.out.println("3. Search accounts");
        System.out.println("4. Account statement for holder");
        System.out.println("");
        System.out.println("0. Exit");
    }

//    @PostConstruct
    private void init() {
        service.newAccount("RO123", "Emanuel", 100);
    }
}
