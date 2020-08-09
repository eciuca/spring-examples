package com.github.eciuca.workshops.spring.examples.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AccountsController {

//    @RequestMapping(path = "/accounts", method = RequestMethod.GET)
    @GetMapping({"/conturi", "/accounts"}) //matches agains the url from the browser address bar:
    // http://localhost:8080/conturi
    // http://localhost:8080/accounts
    public String getAccountsList(){
        return "accounts-list"; //the name of the html template
    }
}
