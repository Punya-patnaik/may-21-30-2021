package com.synechron;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovieController {

	@Autowired
	private JmsTemplate jmsTemplate;
	
	@Value("${movie.input.queue}")
	private String movieInputQueue;
	
	@PostMapping("/fetchmoviedetails")
	public String fetchMovieDetails(@RequestParam String movie) {
		jmsTemplate.convertAndSend(movieInputQueue, movie);
		return "Details for " + movie + " will be fetched soon";
	}
}
