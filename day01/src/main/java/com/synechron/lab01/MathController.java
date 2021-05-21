package com.synechron.lab01;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/math")
public class MathController {

	//private List<String> operations = Arrays.asList("add", "subtract", "product");
	
	@Autowired
	@Qualifier("menu")
	private List<String> operations;

	@GetMapping("/operations")
	public List<String> getOperations() {
		return operations;
	}
}
