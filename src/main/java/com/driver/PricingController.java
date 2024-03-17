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
			// Extract input factors
			double demandFactor = request.getDemandFactor();
			double competitorPricing = request.getCompetitorPricing();
			double globalEventsImpact = request.getGlobalEventsImpact();

			// Dynamic pricing calculation
			double basePrice = 100.0; // Base price for the service
			double adjustedPrice = basePrice * (0.9941 + demandFactor) - competitorPricing + globalEventsImpact;

			// Ensure the price is not negative
			if (adjustedPrice < 0) {
				adjustedPrice = 0;
			}

			return adjustedPrice;
	    }
}
