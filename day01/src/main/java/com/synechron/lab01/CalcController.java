package com.synechron.lab01;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calc")
public class CalcController {

	@Autowired
	private Calculator calculator;

	//private List<String> operations = Arrays.asList("add", "subtract", "product");
	@Autowired
	@Qualifier("numericOperations")
	private List<String> operations;
	
	@GetMapping("/operations")
	public List<String> getOperations() {
		return operations;
	}
	
	@PostMapping("/subtract") 
	public HttpEntity<Integer> subtract(@RequestBody CalcRequestParams params) {
		int result = calculator.subtract(params.getNum1(), params.getNum2());
		return new ResponseEntity<Integer>(result, HttpStatus.OK);
	}
	
	
	//The result is automatically serialized to JSON
	//Jackson is the built-in library that's responsible for this
	@GetMapping("/sum/{a}/{b}")
	public HttpEntity<CalcResult> add(@PathVariable("a") int num1, @PathVariable("b") int num2) {
		int sum = calculator.add(num1, num2);
		CalcResult calcResult = new CalcResult();
		calcResult.setResult(sum);
		calcResult.setOperation("Addition");
		calcResult.setNumbers(Arrays.asList(num1, num2));
		ResponseEntity<CalcResult> response = new ResponseEntity<>(calcResult, HttpStatus.OK);
		return response;
	}
	
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
	
	@PostMapping("/product2")
	public HttpEntity<Integer> product2(@RequestParam Map<String, String> params) {
		int result = calculator.multiply(Integer.parseInt(params.get("num1")), Integer.parseInt(params.get("num2")));
		ResponseEntity<Integer> response = new ResponseEntity<>(result, HttpStatus.OK);
		return response;
	}
	
	
}
