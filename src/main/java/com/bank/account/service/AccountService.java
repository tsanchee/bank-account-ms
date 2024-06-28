package com.bank.account.service;

import java.util.List;

import com.bank.account.document.Account;


public interface AccountService {
	List<Account> getAccounts();
	Account saveAccount(Account account);
	Account editAccount(Account account);
	boolean deletedAccount(String id);
	List<Account> searchByPersonId(String personId);
}
