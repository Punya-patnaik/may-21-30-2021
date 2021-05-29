package com.synechron;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SquareController {

	@GetMapping("/square/{num}")
	public HttpEntity<Integer> getSquare(@PathVariable int num) {
		return new ResponseEntity<Integer>(num * num, HttpStatus.OK);
	}
	
	@GetMapping("/squarelarge/{num}")
	public HttpEntity<Double> getSquareOfLargeNumbers(@PathVariable double num) {
		return new ResponseEntity<Double>(num * num, HttpStatus.OK);
	}
	
}
