package com.github.eciuca.workshops.spring.examples.resource;

import com.github.eciuca.workshops.spring.examples.dto.DepositDto;
import com.github.eciuca.workshops.spring.examples.model.Account;
import com.github.eciuca.workshops.spring.examples.repository.AccountRepository;
import com.github.eciuca.workshops.spring.examples.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.NotAcceptableStatusException;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

import static org.springframework.http.HttpStatus.*;

/**
 * General REST API design rules (Accounts):
 * <p>
 * GET /accounts (retrieve accounts)
 * GET /accounts/{id} (retrieve the details of one account)
 * POST /accounts (create an account)
 * PUT /accounts/{id} (updates the account with the given id) (sends full resource)
 * DELETE /accounts/{id} (delete the account)
 * PATCH /accounts/{id} (partially update the account) (sends partial resource)
 */

@RestController
@RequestMapping("/accounts")
public class AccountsResource {

    @Autowired
    private AccountService accountService;
    @Autowired
    private AccountRepository accountRepository;

    @GetMapping
    public List<Account> getAccounts() {
        return accountService.getAllAccounts();
    }

    @GetMapping("/{id}")
    public Account getAccountById(@PathVariable Long id) {
        return accountRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Account with id " + id + " does not exist"));
    }

    @PostMapping
    public ResponseEntity<Account> createNewAccount(@RequestBody Account account) {
        Account newAccount = accountService.newAccount(account);

        return ResponseEntity
                .status(CREATED)
                .body(newAccount);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Account> updateAccount(@PathVariable Long id, @RequestBody Account account) {
        if (id.equals(account.getId())) {
            Account savedAcccount = accountService.updateAccount(account);

            return ResponseEntity
                    .status(OK)
                    .body(savedAcccount);
        } else {
            throw new NotAcceptableStatusException("The id from the url is different from the id of the account in the payload");
        }
    }

    @DeleteMapping("/{id}")
    public void deleteAccount(@PathVariable Long id) {
        accountService.deleteById(id);
    }

    @PatchMapping("/{id}/deposit")
    public ResponseEntity<Account> updateAccount(@PathVariable Long id, @RequestBody DepositDto deposit) {
            Account account = accountService.deposit(id, deposit.amount);

            return ResponseEntity
                    .status(OK)
                    .body(account);
    }
}
