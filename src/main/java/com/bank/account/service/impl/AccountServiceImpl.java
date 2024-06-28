package com.bank.account.service.impl;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.bank.account.constant.AccountType;
import com.bank.account.constant.PersonType;
import com.bank.account.document.Account;
import com.bank.account.repository.AccountRepository;
import com.bank.account.service.AccountService;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class AccountServiceImpl implements AccountService{
	@Autowired
	private AccountRepository accountRepository;
	@Value("${api.people.endpoint}")
	private String personEndpoint;
	
	public List<Account> getAccounts() {
		return accountRepository.findAll();
	}
	
	public String getPersonType(String personId){
		String personType="";
		ObjectMapper mapper = new ObjectMapper();
		RestTemplate restTemplate = new RestTemplate();
	    String result = restTemplate.getForObject(personEndpoint, String.class, personId);
	    try {
	    	Map<String, String> map = mapper.readValue(result, Map.class);
	    	personType=map.get("personType");
		} catch (IOException e) {
            e.printStackTrace();
		}
	    return personType;
	}
	
	public Account saveAccount(Account account) {
		Account newAccount= null;
		String personType=getPersonType(account.getPersonId());
		
		if(account.getAccountType().equals(AccountType.CUENTA_AHORRO.toString())){
			account.setCommission(0);
			//account.setMaxMonthtransactions(10);
		} else if(account.getAccountType().equals(AccountType.CUENTA_CORRIENTE.toString())){
			//account.setCommission(5);
			account.setLimited(false);
		} else if(account.getAccountType().equals(AccountType.PLAZO_FIJO.toString())){
			account.setCommission(0);
			account.setMaxMonthtransactions(1);
			//account.setTransactionDay(new Date("2021-10-28"));
		}
		
		List<Account> accts = accountRepository.findByPersonId(account.getPersonId());
		
		if (personType.equals(PersonType.PERSONAL.toString())) {
			if (accts==null || accts.size()==0) {
				newAccount = accountRepository.save(account);
			}else {
				System.out.println("El Cliente ya tiene una cuenta");
			}
		}else if (personType.equals(PersonType.EMPRESARIAL.toString()))  {
			if (account.getAccountType().equals(AccountType.CUENTA_CORRIENTE.toString())) {
				newAccount = accountRepository.save(account);
			}else {
				System.out.println("El Cliente solo puede tener cuenta corriente");
			}
		}
		return newAccount;
	}

	public Account editAccount(Account account) {
		return accountRepository.save(account);
	}

	public boolean deletedAccount(String id) {
		boolean deleted = false;
		try {
			accountRepository.deleteById(id);
			deleted = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return deleted;
	}

	public List<Account> searchByPersonId(String personId) {
		return accountRepository.findByPersonId(personId);
	}
}
