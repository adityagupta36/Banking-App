package com.aditya.BankingApp.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aditya.BankingApp.AccountService.AccountService;
import com.aditya.BankingApp.Entity.Account;

@RestController
@RequestMapping("/account")
public class AccountController {
	
	
	
	@Autowired
	AccountService service;
	
	
	//create the account
	@PostMapping("/create")
	public ResponseEntity<Account> createAccount(@RequestBody Account account) {
		
		Account createAccount = service.createAccount(account);
		return ResponseEntity.status(HttpStatus.CREATED).body(createAccount);
		
	}
	
	
	
	@GetMapping("/{account_number}")
	public Account getAccountDetailsByAccountNumber(@PathVariable Long account_number) {
		
		Account account = service.getAccountDetailsByAccountNumber(account_number);
		return account;
		
	}
	
	
	
	@GetMapping("/getallaccounts")
	public List<Account> getAllAccountDetails(){
		List<Account> allAccDetails = service.getAllAccountDetails();
		return allAccDetails;
		
	}
	
	
	
	
	@PutMapping("/deposit/{account_number}/{amount}")
	public Account depositAmount(@PathVariable Long account_number, @PathVariable Double amount) {
		
		Account account = service.depositAmount(account_number, amount);
		return account;
		
	}
	
	
	
	

	@PutMapping("/withdraw/{account_number}/{amount}")
	public Account withdrawAmount(@PathVariable Long account_number, @PathVariable Double amount) {
		
		Account account = service.withdrawAmount(account_number, amount);
		return account;
	}

	
	
	
	
	
	
	@DeleteMapping("/delete/{account_number}")
	public ResponseEntity<String> closeAccount(@PathVariable Long account_number) {
		
		service.closeAccount(account_number);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body("Account closed");
		
	}

}
