package com.synechron;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class MathController {
	
	@ApiOperation(value = "Addition", notes = "Adds two numbers")
	@ApiResponses({
		@ApiResponse(code = 200, response = Integer.class, message = "Sum is"),
		@ApiResponse(code = 500, response = Integer.class, message = "Oops!!!")
	})
	@GetMapping("/add/{a}/{b}")
	public HttpEntity<Integer> add(@PathVariable @ApiParam(example = "12", defaultValue = "number1") int a, 
			@PathVariable @ApiParam(example = "20", defaultValue = "number2") int b) {
		return new ResponseEntity<Integer>(a + b, HttpStatus.OK);
	}
	
	@ApiOperation(value = "Subtraction", notes = "Subtracts two numbers")
	@ApiResponse(code = 200, response = Integer.class, message = "Difference is")
	@GetMapping("/subtract/{a}/{b}")
	public HttpEntity<Integer> subtract(@PathVariable @ApiParam(example = "10") int a, 
			@PathVariable @ApiParam(example = "8") int b) {
		return new ResponseEntity<Integer>(a - b, HttpStatus.OK);
	}
}
