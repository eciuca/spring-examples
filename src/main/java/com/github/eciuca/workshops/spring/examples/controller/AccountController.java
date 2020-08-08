package com.github.eciuca.workshops.spring.examples.controller;

import com.github.eciuca.workshops.spring.examples.model.Account;
import com.github.eciuca.workshops.spring.examples.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

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
        service.displayAccounts();
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

        Account account = service.searchByIban(iban);

        System.out.println(account);
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
        System.out.println("");
        System.out.println("0. Exit");
    }

//    @PostConstruct
    private void init() {
        service.newAccount("RO123", "Emanuel", 100);
    }
}
