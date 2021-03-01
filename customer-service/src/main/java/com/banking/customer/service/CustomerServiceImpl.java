package com.banking.customer.service;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.banking.customer.model.Address;
import com.banking.customer.model.AddressDetails;
import com.banking.customer.model.Contact;
import com.banking.customer.model.ContactDetails;
import com.banking.customer.model.Customer;
import com.banking.customer.model.CustomerDetails;
import com.banking.customer.repository.CustomerRepository;

//https://github.com/sbathina/BankApp/blob/master/src/main/java/com/coding/exercise/bankapp/service/BankingServiceImpl.java
@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	/*
	 * @Autowired private BankingServiceHelper bankingServiceHelper;
	 */

	public CustomerServiceImpl(CustomerRepository repository) {
		this.customerRepository = repository;
	}

	@Override
	public List<CustomerDetails> findAll() {
		List<CustomerDetails> allCustomerDetails = new ArrayList<CustomerDetails>();

		Iterable<Customer> customerList = customerRepository.findAll();

		customerList.forEach(customer -> {
			allCustomerDetails.add(convertToCustomerDomain(customer));
		});
		return allCustomerDetails;
	}

	/**
	 * Add new customer/CREATE
	 */
	@Override
	public ResponseEntity<Object> addCustomer(CustomerDetails customerDetails) {

		Customer customer = convertToCustomerEntity(customerDetails);
		customer.setCreateDateTime(LocalDate.of(2014, Month.DECEMBER, 12));//set(1900, 12, 10, 00, 00));
		customer.setUpdateDateTime(new Date());
		customerRepository.save(customer);

		return ResponseEntity.status(HttpStatus.CREATED).body("New Customer has been created");
	}

	/**
	 * Find a customer /READ
	 */
	@Override
	public CustomerDetails findByCustomerNumber(Long customerNumber) {
		Optional<Customer> customerEntity = customerRepository.findByCustomerNumber(customerNumber);
		if (customerEntity.isPresent())
			return convertToCustomerDomain(customerEntity.get());

		return null;

	}

	/**
	 * Update Customer/UPDATE
	 */
	@Override
	public ResponseEntity<Object> updateCustomer(CustomerDetails customerDetails, Long customerNumber) {
		Optional<Customer> customerEntityFromRepo = customerRepository.findByCustomerNumber(customerNumber);
		Customer customerEnt = convertToCustomerEntity(customerDetails);

		if (customerEntityFromRepo.isPresent()) {
			Customer managedCustomerEntity = customerEntityFromRepo.get();
			// check for contact details
			if (Optional.ofNullable(customerEnt.getContactDetails()).isPresent()) {

				Contact managedContact = managedCustomerEntity.getContactDetails();
				if (managedContact != null) {
					managedContact.setEmailId(customerEnt.getContactDetails().getEmailId());
					managedContact.setHomePhone(customerEnt.getContactDetails().getHomePhone());
					managedContact.setWorkPhone(customerEnt.getContactDetails().getWorkPhone());

				} else {
					managedCustomerEntity.setContactDetails(customerEnt.getContactDetails());
				}

			}
			// check for address details
			if (Optional.ofNullable(customerEnt.getCustomerAddress()).isPresent()) {
				Address managedAddress = managedCustomerEntity.getCustomerAddress();
				if (managedAddress != null) {
					managedAddress.setAddress1(customerEnt.getCustomerAddress().getAddress1());
					managedAddress.setAddress2(customerEnt.getCustomerAddress().getAddress2());
					managedAddress.setCity(customerEnt.getCustomerAddress().getCity());
					managedAddress.setState(customerEnt.getCustomerAddress().getState());
					managedAddress.setZip(customerEnt.getCustomerAddress().getZip());
					managedAddress.setCountry(customerEnt.getCustomerAddress().getCountry());
				} else {
					managedCustomerEntity.setCustomerAddress(customerEnt.getCustomerAddress());
				}
			}
			managedCustomerEntity.setUpdateDateTime(new Date());
			managedCustomerEntity.setStatus(customerEnt.getStatus());
			managedCustomerEntity.setFirstName(customerEnt.getFirstName());
			managedCustomerEntity.setMiddleName(customerEnt.getMiddleName());
			managedCustomerEntity.setLastName(customerEnt.getLastName());
			managedCustomerEntity.setUpdateDateTime(new Date());

			customerRepository.save(managedCustomerEntity);

			return ResponseEntity.status(HttpStatus.OK).body("Customer Updated");

		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Customer " + customerNumber + " Not found");

		}

	}

	/**
	 * DELETE customer
	 */
	@Override
	public ResponseEntity<Object> deleteCustomer(Long customerNumber) {
		Optional<Customer> customerEntityFromRepo = customerRepository.findByCustomerNumber(customerNumber);
		if (customerEntityFromRepo.isPresent()) {
			Customer managedCustomerEntity = customerEntityFromRepo.get();
			customerRepository.delete(managedCustomerEntity);
			return ResponseEntity.status(HttpStatus.OK).body("Customer Deleted");

		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Customer " + customerNumber + " Not found");

		}
	}

	public CustomerDetails convertToCustomerDomain(Customer customer) {

		return CustomerDetails.builder().firstName(customer.getFirstName()).middleName(customer.getMiddleName())
				.lastName(customer.getLastName()).customerNumber(customer.getCustomerNumber())
				.status(customer.getStatus()).contactDetails(convertToContactDomain(customer.getContactDetails()))
				.customerAddress(convertToAddressDomain(customer.getCustomerAddress())).build();
	}

	public ContactDetails convertToContactDomain(Contact contact) {

		return ContactDetails.builder().emailId(contact.getEmailId()).homePhone(contact.getHomePhone())
				.workPhone(contact.getWorkPhone()).build();
	}

	public AddressDetails convertToAddressDomain(Address address) {

		return AddressDetails.builder().address1(address.getAddress1()).address2(address.getAddress2())
				.city(address.getCity()).state(address.getState()).zip(address.getZip()).country(address.getCountry())
				.build();
	}

	public Customer convertToCustomerEntity(CustomerDetails customerDetails) {

		return Customer.builder().firstName(customerDetails.getFirstName()).middleName(customerDetails.getMiddleName())
				.lastName(customerDetails.getLastName()).customerNumber(customerDetails.getCustomerNumber())
				.status(customerDetails.getStatus())
				.contactDetails(convertToContactEntity(customerDetails.getContactDetails()))
				.customerAddress(convertToAddressEntity(customerDetails.getCustomerAddress()))
				.build();
	}

	public Address convertToAddressEntity(AddressDetails addressDetails) {

		return Address.builder().address1(addressDetails.getAddress1()).address2(addressDetails.getAddress2())
				.city(addressDetails.getCity()).state(addressDetails.getState()).zip(addressDetails.getZip())
				.country(addressDetails.getCountry()).build();
	}

	public Contact convertToContactEntity(ContactDetails contactDetails) {

		return Contact.builder().emailId(contactDetails.getEmailId()).homePhone(contactDetails.getHomePhone())
				.workPhone(contactDetails.getWorkPhone()).build();
	}
}
