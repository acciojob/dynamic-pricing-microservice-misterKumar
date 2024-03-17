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
			// Formula to calculate dynamic price
			// Dynamic Price = Competitor Pricing * (1 + Demand Factor + Global Events Impact)
			double dynamicPrice = request.getCompetitorPricing() * (1 + request.getDemandFactor() + request.getGlobalEventsImpact());
			return round(dynamicPrice, 5); // Rounding to 2 decimal places
	    }
	private double round(double value, int places) {
		if (places < 0) throw new IllegalArgumentException();

		long factor = (long) Math.pow(10, places);
		value = value * factor;
		long tmp = Math.round(value);
		return (double) tmp / factor;
	}
}
