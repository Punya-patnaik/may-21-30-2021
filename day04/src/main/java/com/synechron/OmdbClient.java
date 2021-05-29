package com.synechron;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "omdbClient", url = "http://omdbapi.com")
public interface OmdbClient {

	@GetMapping
	public String getDetails(@RequestParam("i") String identifier, 
			@RequestParam("apikey") String apiKey, 
			@RequestParam("t") String movie);
	
}
