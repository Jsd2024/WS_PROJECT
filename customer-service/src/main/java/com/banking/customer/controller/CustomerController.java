package com.banking.customer.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.banking.customer.file.FileUploadResponse;
import com.banking.customer.file.UploadedFile;
import com.banking.customer.model.CustomerDetails;
import com.banking.customer.service.CustomerService;

@RestController
@Validated
@RequestMapping("Banking_Application/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerSevice;
	String validateFieldStr = "Please provide all fields";

	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping(path = "/all")
	public List<CustomerDetails> getAllCustomers() {

		return customerSevice.findAll();
	}

	// check the id for login, give syso.. approuter.js L21-->login L46 -->auth.js
	// L16
	/*
	 * public ResponseEntity<Object> checkCredentials(@RequestBody CustomerDetails
	 * customerDetails){
	 * 
	 * }
	 */

	@PostMapping(path = "/add")
	public ResponseEntity<Object> addCustomer(@RequestBody CustomerDetails customer) {

		return customerSevice.addCustomer(customer);
	}

	//@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping(path = "/get/{customerNumber}")
	public ResponseEntity<Object> getCustomer(@RequestHeader("Accept") String acceptHeader,
			@RequestHeader(value = "Authorization") String authorizationHeader,
			@RequestHeader Map<String, String> header,
			@PathVariable @Min(value = 15, message = "Customer Number  should not be less than {value}") @Max(value = 1500, message = "Customer Number should not be greater than  {value}") Long customerNumber) {
		
		Map<String, String> values = new HashMap<>();
		values.put("Accept", acceptHeader);
		values.put("Authorization", authorizationHeader);
		values.put("Customer", customerSevice.findByCustomerNumber(customerNumber).toString());
		return ResponseEntity.ok(header);
	}

	@PutMapping(path = "/{customerNumber}")
	public ResponseEntity<Object> updateCustomer(@RequestBody @Valid CustomerDetails customerDetails,
			@PathVariable @Valid Long customerNumber) {
		return customerSevice.updateCustomer(customerDetails, customerNumber);
	}

	@DeleteMapping(path = "/{customerNumber}")
	public ResponseEntity<Object> deleteCustomer(@PathVariable Long customerNumber) {
		return customerSevice.deleteCustomer(customerNumber);
	}
	
	///File Upload
	 @PostMapping("/upload/db")
	    public FileUploadResponse uploadDb(@RequestParam("filetodb") MultipartFile multipartFile)
	    {
	       UploadedFile uploadedFile = customerSevice.uploadToDb(multipartFile);
	       FileUploadResponse response = new FileUploadResponse();
	       if(uploadedFile!=null){
	           String downloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
	                   .path("/Banking_Application/customer/download/")
	                   .path(uploadedFile.getFileId())
	                   .toUriString();
	           response.setDownloadUri(downloadUri);
	           response.setFileId(uploadedFile.getFileId());
	           response.setFileName(uploadedFile.getFileName());
	           response.setFileType(uploadedFile.getFileType());
	           response.setUploadStatus(true);
	           response.setMessage("File Uploaded Successfully!");
	           return response;

	       }
	       response.setMessage("Oops 1 something went wrong please re-upload.");
	       return response;
	    }
	 
	 
	 @GetMapping("/download/{id}")
	    public ResponseEntity<Resource> downloadFile(@PathVariable String id)
	    {
	        UploadedFile uploadedFileToRet =  customerSevice.downloadFile(id);
	        return ResponseEntity.ok()
	                .contentType(MediaType.parseMediaType(uploadedFileToRet.getFileType()))
	                .header(HttpHeaders.CONTENT_DISPOSITION,"attachment; filename= "+uploadedFileToRet.getFileName())
	                .body(new ByteArrayResource(uploadedFileToRet.getFileData()));
	    }

}
