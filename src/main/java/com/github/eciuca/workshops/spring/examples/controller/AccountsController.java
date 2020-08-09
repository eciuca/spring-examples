package com.github.eciuca.workshops.spring.examples.controller;

import com.github.eciuca.workshops.spring.examples.model.Account;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AccountsController {

//    @RequestMapping(path = "/accounts", method = RequestMethod.GET)
    //matches agains the url from the browser address bar:
    // http://localhost:8080/conturi
    // http://localhost:8080/accounts
    @GetMapping({"/conturi", "/accounts"})
    public String getAccountsList(Model model) {

        Account account = new Account();
        account.setIban("RO123");
        account.setHolder("Emanuel");
        account.setBalance(100);

        model.addAttribute("dummyAccountName", "My dummy account");
        model.addAttribute("myAccount", account);


        return "accounts-list"; //the name of the html template
    }
}
