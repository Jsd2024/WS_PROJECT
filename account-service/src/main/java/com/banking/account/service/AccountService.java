package com.banking.account.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.banking.account.exceptionhandling.ResourceNotFoundException;
import com.banking.account.model.AccountInformation;

public interface AccountService {
	public List<AccountInformation> findAll();

	
	public ResponseEntity<Object> findByAccountNumber(Long accountNumber);


	public ResponseEntity<Object> addNewAccount(AccountInformation accountInformation, Long customerNumber) throws ResourceNotFoundException;


}
