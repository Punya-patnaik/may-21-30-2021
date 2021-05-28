package com.synechron;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MathController {
	
	@GetMapping("/add/{a}/{b}")
	public HttpEntity<Integer> add(@PathVariable int a, @PathVariable int b) {
		return new ResponseEntity<Integer>(a + b, HttpStatus.OK);
	}
	
	@GetMapping("/subtract/{a}/{b}")
	public HttpEntity<Integer> subtract(@PathVariable int a, @PathVariable int b) {
		return new ResponseEntity<Integer>(a - b, HttpStatus.OK);
	}
}
