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
			double basePrice = 100.0;
			double demandFactor = 1.0 + request.getDemandFactor();
			double competitorFactor = 1.0 - request.getCompetitorPricing() / 100.0;
			double globalEventsFactor = 1.0 + request.getGlobalEventsImpact() / 100.0;
			return basePrice*demandFactor*competitorFactor*globalEventsFactor;
	    }
}
