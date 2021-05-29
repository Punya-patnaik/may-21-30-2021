package com.synechron;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/math")
public class MathController {

	@GetMapping("/square/{num}")
	public HttpEntity<Long> computeSquare(@PathVariable long num) {
		return new ResponseEntity<Long>(num * num, HttpStatus.OK);
	}
	
	@GetMapping("/cube/{num}")
	public HttpEntity<Long> computeCube(@PathVariable long num) {
		return new ResponseEntity<Long>(num * num * num, HttpStatus.OK);
	}
}
