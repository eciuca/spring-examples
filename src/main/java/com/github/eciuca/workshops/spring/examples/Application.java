package com.github.eciuca.workshops.spring.examples;

import com.github.eciuca.workshops.spring.examples.config.AppConfig;
import com.github.eciuca.workshops.spring.examples.domain.*;
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

        AccountController controller = context.getBean(AccountController.class);

        controller.start();
    }

    public static void noSpring() {
        //POJO - plain old java object
        AccountCsvMapper accountCsvMapper = new AccountCsvMapper();
        AccountRepository accountRepository = new FileAccountRepository();
        AccountService service = new MyAccountService();
        AccountController controller1 = new AccountController();
    }
}
