package com.demoMicroService.cloud.gateway;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * whenever any service is down it will redirect to this controller
 * 
 * @author egaonsu
 *
 */

@RestController
public class FallBackMethodController {

	@GetMapping("/accountServiceFallBack")
	public String accountServiceFallBackMethod() {

		return "account service is taking longer than expected please try again later";
	}

	@GetMapping("/customerServiceFallBack")
	public String customerServiceFallBackMethod() {

		return "customer service is taking longer than expected please try again later";
	}

}
