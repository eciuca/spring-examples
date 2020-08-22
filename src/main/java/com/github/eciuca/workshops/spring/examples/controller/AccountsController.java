package com.github.eciuca.workshops.spring.examples.controller;

import com.github.eciuca.workshops.spring.examples.model.Account;
import com.github.eciuca.workshops.spring.examples.repository.AccountRepository;
import com.github.eciuca.workshops.spring.examples.service.AccountService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Controller
public class AccountsController {

    @Autowired
    private AccountService service;

    @Autowired
    private AccountRepository repository;


//    @RequestMapping(path = "/accounts", method = RequestMethod.GET)
    //matches agains the url from the browser address bar:
    // http://localhost:8080/conturi
    // http://localhost:8080/accounts
    @GetMapping({"/accounts", "/"})
    public String getAccountsList(Model model) {
        List<Account> accountList = service.getAllAccountsByBalanceDescending();

        model.addAttribute("myAccountsList", accountList);

        return "accounts-list"; //the name of the html template
    }

    @GetMapping("/accounts/create")
    public String showCreateNewAccountPage(Model model) {
        Account emptyAccount = new Account();

        model.addAttribute("account", emptyAccount);

        return "accounts-create";
    }

    @PostMapping("/accounts/create")
    public String createNewAccount(Account account) {

        service.newAccount(account);

        return "redirect:/accounts";
    }

    @GetMapping({"/demo"})
    public String getAccountsDemoPage(Model model) {

        Account account = new Account();
        account.setIban("RO123");
        account.setHolder("Emanuel");
        account.setBalance(100);

        model.addAttribute("dummyAccountName", "My dummy account");
        model.addAttribute("myAccount", account);


        return "accounts-demo"; //the name of the html template
    }

    @GetMapping("/accounts/delete/{id}")
    public String deleteAccount(@PathVariable("id") Long id) {
        service.deleteById(id);

        return "redirect:/accounts";
    }

    @GetMapping("/accounts/edit/{id}")
    public String showAccountsEditPage(@PathVariable("id") Long id, Model model) {
        Account account = repository.findById(id).orElseThrow(() -> new EntityNotFoundException());

        model.addAttribute("account", account);

        return "accounts-edit";
    }

    @Transactional
    @PostMapping("/accounts/update/{id}")
    public String saveAccountChanges(@PathVariable("id") Long id, Account account) {
        account.setId(id);

        repository.save(account);

        return "redirect:/accounts";
    }
}
