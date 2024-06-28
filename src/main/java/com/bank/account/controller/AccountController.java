package com.bank.account.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bank.account.document.Account;
import com.bank.account.service.AccountService;

@RestController
public class AccountController {
	
	@Autowired
	private AccountService accountService;
	
	@GetMapping(value="/api/v1/accounts")
	@ResponseBody List<Account> getAccounts(){
		return accountService.getAccounts();
	}

	@PostMapping(value="/api/v1/accounts")
	@ResponseBody Account savePerson(@RequestBody Account account){
		return accountService.saveAccount(account);
	}
	
	@PutMapping(value="/api/v1/accounts")
	@ResponseBody Account editPerson(@RequestBody Account account){
		return accountService.editAccount(account);
	}
	
	@DeleteMapping(value="/api/v1/accounts/{id}")
	@ResponseBody boolean deletedAccount(@PathVariable String id){
		return accountService.deletedAccount(id);
	}
	
	@GetMapping(value="/api/v1/accounts/{personId}")
	@ResponseBody List<Account> searchByPersonId(@PathVariable String personId){
		return accountService.searchByPersonId(personId);
	}
}
