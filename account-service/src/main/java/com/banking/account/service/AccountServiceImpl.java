package com.banking.account.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import com.banking.account.exceptionhandling.ResourceNotFoundException;
import com.banking.account.model.Account;
import com.banking.account.model.AccountInformation;
import com.banking.account.model.Address;
import com.banking.account.model.AddressDetails;
import com.banking.account.model.BankInfo;
import com.banking.account.model.BankInformation;
import com.banking.account.model.Customer;
import com.banking.account.model.CustomerAccountXRef;
import com.banking.account.repository.AccountRepository;
import com.banking.account.repository.CustomerAccountXRefRepository;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountRepository accountRepository;
	@Autowired
	private RestTemplate restTemplate;

//	@Autowired
//	private CustomerRepository customerRepository;

	@Autowired
	private CustomerAccountXRefRepository custAccXRefRepository;

	/*
	 * @Autowired private BankingServiceHelper bankingServiceHelper;
	 */

	public AccountServiceImpl(AccountRepository repository) {
		this.accountRepository = repository;
	}

	@Override
	public ResponseEntity<Object> findByAccountNumber(Long accountNumber) {

		Optional<Account> accountEntityFromRepo = accountRepository.findByAccountNumber(accountNumber);
		if (accountEntityFromRepo.isPresent()) {
			System.out.println("finBy-->>");
			AccountInformation information = convertToAccountDomain(accountEntityFromRepo.get());
			return ResponseEntity.status(HttpStatus.OK).body(information);
		} else {
			Account information = accountEntityFromRepo.orElse(new Account());
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(information);//"Account Number " + accountNumber + " Not found"
		}
	}

	@Override
	@Transactional
	public ResponseEntity<Object> addNewAccount(AccountInformation accountInformation, Long customerNumber) throws ResourceNotFoundException {

		System.out.println("inside addNewAccount of account service");

		// User user = userRepository.findByUserId(userId);

		String URL = "http://localhost:9001/Banking_Application/customer/get/" + customerNumber;

		System.out.println("URL : " + URL);

		Customer cust = restTemplate.getForObject(URL, Customer.class);
		
        if(cust ==null)
        {
        	    	throw new ResourceNotFoundException("customer not found");
//        	
        	
        }
		Optional<Account> accountEntityFromRepo = accountRepository.findByAccountNumber(cust.getCustomerNumber());// customerRepository.findByCustomerNumber(customerNumber);

		if (!accountEntityFromRepo.isPresent()) {
			Account account = convertToAccountEntity(accountInformation);
			accountRepository.save(account);

			custAccXRefRepository
					.save(CustomerAccountXRef.builder().accountNumber(accountInformation.getAccountNumber()).build());// .customerNumber(customerNumber).build());
		}
		return ResponseEntity.status(HttpStatus.CREATED).body("New account created");

	}

	@Override
	public List<AccountInformation> findAll() {
		List<AccountInformation> allAccountDetails = new ArrayList<AccountInformation>();

		Iterable<Account> customerList = accountRepository.findAll();

		customerList.forEach(account -> {
			allAccountDetails.add(convertToAccountDomain(account));
		});
		return allAccountDetails;
	}

	public AccountInformation convertToAccountDomain(Account account) {

		return AccountInformation.builder().accountType(account.getAccountType())
				.accountBalance(account.getAccountBalance()).accountNumber(account.getAccountNumber())
				.accountStatus(account.getAccountStatus())
				.bankInformation(convertToBankInfoDomain(account.getBankInformation())).build();
	}

	public BankInformation convertToBankInfoDomain(BankInfo bankInfo) {

		return BankInformation.builder().branchCode(bankInfo.getBranchCode()).branchName(bankInfo.getBranchName())
				.routingNumber(bankInfo.getRoutingNumber())
				.branchAddress(convertToAddressDomain(bankInfo.getBranchAddress())).build();
	}

	public AddressDetails convertToAddressDomain(Address address) {

		return AddressDetails.builder().address1(address.getAddress1()).address2(address.getAddress2())
				.city(address.getCity()).state(address.getState()).zip(address.getZip()).country(address.getCountry())
				.build();
	}

	public Account convertToAccountEntity(AccountInformation accInfo) {

		return Account.builder().accountType(accInfo.getAccountType()).accountBalance(accInfo.getAccountBalance())
				.accountNumber(accInfo.getAccountNumber()).accountStatus(accInfo.getAccountStatus())
				.bankInformation(convertToBankInfoEntity(accInfo.getBankInformation())).build();
	}

	public BankInfo convertToBankInfoEntity(BankInformation bankInformation) {

		return BankInfo.builder().branchCode(bankInformation.getBranchCode())
				.branchName(bankInformation.getBranchName()).routingNumber(bankInformation.getRoutingNumber())
				.branchAddress(convertToAddressEntity(bankInformation.getBranchAddress())).build();
	}

	public Address convertToAddressEntity(AddressDetails addressDetails) {

		return Address.builder().address1(addressDetails.getAddress1()).address2(addressDetails.getAddress2())
				.city(addressDetails.getCity()).state(addressDetails.getState()).zip(addressDetails.getZip())
				.country(addressDetails.getCountry()).build();
	}

}
