package com.banking.customer.model;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CustomerDetails {

	@NotNull
	@Size(min=2)
    private String firstName;
	@NotNull
	@Size(min=2)
    private String lastName;
    
	@NotBlank
    private String middleName;
    
	//@NotNull
	//@Size(min=5, max=10)
    private Long customerNumber;
    
    private String status;
    
    private AddressDetails customerAddress;
    
    private ContactDetails contactDetails;
    
}