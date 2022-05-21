package com.phoebussoftware.technicalTest.web;

import com.phoebussoftware.technicalTest.DTO.AccountDTO;
import com.phoebussoftware.technicalTest.model.AccountEntity;
import com.phoebussoftware.technicalTest.service.IAccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;



@RestController
@RequestMapping("/account")
public class AccountController {

  IAccountService accountService;

  public AccountController(IAccountService accountService) {
    this.accountService = accountService;
  }

  @GetMapping("/{accountId}")
  public ResponseEntity<AccountDTO> getAccountById(@PathVariable Integer accountId) {

    return ResponseEntity.ok(AccountDTO.builder().build());
  }


  @PostMapping("/add")
  public ResponseEntity<AccountDTO> addAccount(@Valid @RequestBody AccountDTO accountDTO) {

    AccountEntity result = accountService.saveAccount(accountService.convertToEntity(accountDTO));
    return new ResponseEntity<>(accountService.convertToDTO(result), HttpStatus.CREATED);
  }

}
