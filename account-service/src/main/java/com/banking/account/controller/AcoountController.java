package com.banking.account.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banking.account.exceptionhandling.ResourceNotFoundException;
import com.banking.account.model.AccountInformation;
import com.banking.account.service.AccountServiceImpl;

@RestController
@RequestMapping(path = "Banking_Application/account",  produces = MediaType.APPLICATION_JSON_VALUE)//consumes = MediaType.APPLICATION_JSON_VALUE,
public class AcoountController {

	@Autowired
	private AccountServiceImpl accountService;

	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping(path = "/get/{accountNumber}")
	public ResponseEntity<Object> getByAccountNumber(@PathVariable Long accountNumber) {
		System.out.println("within getByAccountNumber: "+ accountNumber);
		return accountService.findByAccountNumber(accountNumber);
	}

	@PostMapping(path = "/add/{customerNumber}")
	public ResponseEntity<Object> addnewAccount(@RequestBody AccountInformation accountInformation,
			@PathVariable("customerNumber") Long customerNumber) throws ResourceNotFoundException {
		return accountService.addNewAccount(accountInformation, customerNumber);
	}

	/*
	 * @PutMapping(path = "/transfer/{customerNumber}") public
	 * ResponseEntity<Object> getTransferDetails(@RequestBody TransferDetails
	 * transferDetails,
	 * 
	 * @PathVariable Long customerNumber) { return
	 * accountService.transferDetails(transferDetails, customerNumber); }
	 * 
	 * @CrossOrigin(origins = "http://localhost:3000")
	 * 
	 * @GetMapping(path = "/transactions/{accountNumber}") public
	 * List<TransactionDetails> getTransactionByAccountNumber(@PathVariable Long
	 * accountNumber) { return
	 * accountService.findTransactionsByAccountNumber(accountNumber); }
	 */}
