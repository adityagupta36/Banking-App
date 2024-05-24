package com.aditya.BankingApp.AccountService;

import java.util.*;

import com.aditya.BankingApp.Entity.Account;


public interface AccountService {
	
	public Account createAccount(Account account);
	
	public Account getAccountDetailsByAccountNumber(Long account_number);
	
	public List<Account> getAllAccountDetails();
	
	public Account depositAmount(Long account_number, Double amount);
	
	public Account withdrawAmount(Long account_number, Double amount);
	
	public void closeAccount(Long accountNumber);


	
	
	
	
	
}
