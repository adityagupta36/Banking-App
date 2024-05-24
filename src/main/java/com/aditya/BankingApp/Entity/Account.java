package com.aditya.BankingApp.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table   //bydefault ==> small a ==> account
public class Account {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long account_number;
	
	@Column
	private String account_holdername;
	
	@Column
	private Double account_balance;

	
	
	
	public Account() {
		super();
	}

	public Account(String account_holdername, Double account_balance) {
		this.account_holdername = account_holdername;
		this.account_balance = account_balance;
	}

	public Long getAccount_number() {
		return account_number;
	}

	public void setAccount_number(Long account_number) {
		this.account_number = account_number;
	}

	public String getAccount_holdername() {
		return account_holdername;
	}

	public void setAccount_holdername(String account_holdername) {
		this.account_holdername = account_holdername;
	}

	public Double getAccount_balance() {
		return account_balance;
	}

	public void setAccount_balance(Double account_balance) {
		this.account_balance = account_balance;
	}

	@Override
	public String toString() {
		return "Account [account_number=" + account_number + ", account_holdername=" + account_holdername
				+ ", account_balance=" + account_balance + "]";
	}
	
	
	
	
	
			
		


}
