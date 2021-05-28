package com.synechron;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "squareclient", url="http://localhost:8081")
public interface MySquareClient {

	@GetMapping("/square/{num}")
	public HttpEntity<Integer> getSquare(@PathVariable int num);
	
	@GetMapping("/squarelarge/{num}")
	public HttpEntity<Double> getLargeNumberSquare(@PathVariable double num);
}
