package com.synechron.controller;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import com.synechron.exception.AccountNotFoundException;
import com.synechron.service.AccountService;

@RestController
@RequestMapping("/bank")
public class BankController {
	@Autowired
	private AccountService accountService;
	
	
	@PostConstruct
	public void printDetails() {
		System.out.println("*********************************");
		System.out.println(accountService.getClass().getName());
		System.out.println(accountService.getClass().getSuperclass().getName());
		System.out.println("*********************************");
	}

	@PostMapping("/deposit")
	public String deposit(@RequestParam("accountnumber") int accountNumber, @RequestParam int amount, @RequestParam String type) {
		accountService.deposit(accountNumber, amount, type);
		return "Deposit successful";
	}
	
	@PostMapping("/withdraw")
	public String withdraw(@RequestParam("accountnumber") int accountNumber, @RequestParam int amount, @RequestParam String type) {
		accountService.withdraw(accountNumber, amount, type);
		return "Withdraw successful";
	}
	
//	@ExceptionHandler(AccountNotFoundException.class)
//	public HttpEntity<String> handleAccountNotFoundException(AccountNotFoundException ex, WebRequest req) {
//		String message = "Error: Account " + ex.getMessage() + " is not found";
//		return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
//	}
//	
//	@ExceptionHandler(Exception.class)
//	public HttpEntity<String> handleException(Exception ex, WebRequest req) {
//		String message = "Error: " + ex.getMessage(); 
//		return new ResponseEntity<>(message, HttpStatus.INTERNAL_SERVER_ERROR);
//	}

}
