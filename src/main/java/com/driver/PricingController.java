package com.driver;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pricing")
public class PricingController {
	 @PostMapping("/calculate")
	    public double calculateDynamicPrice(@RequestBody PricingRequest request) {
		// your code goes here
	        return calculatePrice(request);
	    }

	    private double calculatePrice(PricingRequest request) {
	    	// your code goes here

	        return 0.0;
	    }
}
