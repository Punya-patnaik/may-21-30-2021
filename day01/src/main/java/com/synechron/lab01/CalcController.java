package com.synechron.lab01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calc")
public class CalcController {

	@Autowired
	private Calculator calculator;
	
	@GetMapping("/add/{a}/{b}")
	public HttpEntity<Integer> sum(@PathVariable("a") int num1, @PathVariable("b") int num2) {
		int result = calculator.add(num1, num2);
		ResponseEntity<Integer> response = new ResponseEntity<>(result, HttpStatus.OK);
		return response;
	}
	
	@GetMapping("/square/{num}")
	public HttpEntity<Integer> square(@PathVariable int num) {
		int result = calculator.square(num);
		ResponseEntity<Integer> response = new ResponseEntity<>(result, HttpStatus.OK);
		return response;
	}
	
	@PutMapping("/subtract/{a}/{b}")
	public HttpEntity<Integer> difference(@PathVariable int a, @PathVariable int b) {
		int result = calculator.subtract(a, b);
		ResponseEntity<Integer> response = new ResponseEntity<>(result, HttpStatus.OK);
		return response;
	}
	
	@PostMapping("/product")
	public HttpEntity<Integer> product(@RequestParam int num1, @RequestParam int num2) {
		int result = calculator.multiply(num1, num2);
		ResponseEntity<Integer> response = new ResponseEntity<>(result, HttpStatus.OK);
		return response;
	}
	
}
