package com.synechron;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovieController {

	@Autowired
	private OmdbClient omdbClient;
	
	@GetMapping("/details/{movie}")
	public String getMovieDetails(@PathVariable String movie) {
		return omdbClient.getDetails("tt3896198", "52d1c7f", movie);
	}
}
