package com.github.eciuca.workshops.spring.examples;

import com.github.eciuca.workshops.spring.examples.config.AppConfig;
import com.github.eciuca.workshops.spring.examples.domain.Account;
import com.github.eciuca.workshops.spring.examples.domain.AccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Bank Account Management Application
 * <p>
 * Functionalitati:
 * - creare cont
 * - afisare lista conturi
 * - salvare lista conturi (in memorie / pe disk)
 */
public class Application {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        AccountService accountService = context.getBean(AccountService.class);

        accountService.newAccount("RO123", "Emanuel", 100);
        accountService.newAccount("RO124", "Marius", 200);
        accountService.newAccount("RO125", "Ana", 300);

        accountService.displayAccounts();

    }
}
