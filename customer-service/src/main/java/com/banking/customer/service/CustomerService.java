package com.banking.customer.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import com.banking.customer.file.UploadedFile;
import com.banking.customer.model.CustomerDetails;

public interface CustomerService {

	public List<CustomerDetails> findAll();

	public ResponseEntity<Object> addCustomer(CustomerDetails customerDetails);

	public CustomerDetails findByCustomerNumber(Long customerNumber);

	public ResponseEntity<Object> updateCustomer(CustomerDetails customerDetails, Long customerNumber);

	public ResponseEntity<Object> deleteCustomer(Long customerNumber);

	public UploadedFile uploadToDb(MultipartFile multipartFile);

	public UploadedFile downloadFile(String id);

	//public ResponseEntity<Object> findByAccountNumber(Long accountNumber);

	// public ResponseEntity<Object> findByEmail(String email);

	//public ResponseEntity<Object> addNewAccount(AccountInformation accountInformation, Long customerNumber);

//	public ResponseEntity<Object> transferDetails(TransferDetails transferDetails, Long customerNumber);

	//public List<TransactionDetails> findTransactionsByAccountNumber(Long accountNumber);

}
