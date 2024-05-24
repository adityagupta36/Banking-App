package com.aditya.BankingApp.AccountService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.aditya.BankingApp.Entity.Account;
import com.aditya.BankingApp.Repository.AccountRepository;

@Service
public class AccountServiceImpl implements AccountService {

	
	@Autowired
	AccountRepository repo;

	
	@Override
	public Account createAccount(Account account) {
		Account account_saved = repo.save(account);
		return account_saved;
	}
	
	
	

	@Override
	public Account getAccountDetailsByAccountNumber(Long account_number) {
		Optional<Account> account = repo.findById(account_number);
		
		if(account.isEmpty()) {
			throw new RuntimeException("Account doesn't exist");
		}
		Account accountfound = repo.findById(account_number).get();		
		return accountfound;
	}

	
	
	
	
	
	@Override
	public List<Account> getAllAccountDetails() {
		
		return repo.findAll() ;
	}
	
	
	
	
	

	@Override
	public Account depositAmount(Long account_number, Double amount) {
		Optional <Account> account = repo.findById(account_number);		
		if(account.isEmpty()) {
			throw new RuntimeException("Account doesn't exist");
		}
		
		Account accPresent = repo.findById(account_number).get();
		Double d1 = accPresent.getAccount_balance();
		d1 = d1+amount;
		
		accPresent.setAccount_balance(d1);
		Account finalamt = repo.save(accPresent);
		
		return finalamt;
	}
	
	
	
	
	
	

	@Override
	public Account withdrawAmount(Long account_number, Double amount) {
		Optional <Account> account = repo.findById(account_number);		
		if(account.isEmpty()) {
			throw new RuntimeException("Account doesn't exist");
		}
		Account accPresent = repo.findById(account_number).get();
		Double d1 = accPresent.getAccount_balance();
		d1=d1-amount;
		
		accPresent.setAccount_balance(d1);
		Account finalamt = repo.save(accPresent);

		return finalamt;
	}
	
	
	
	
	
	

	@Override
	public void closeAccount(Long accountNumber) {
		getAccountDetailsByAccountNumber(accountNumber);
		repo.deleteById(accountNumber);
		
	}

}
