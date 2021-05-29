package com.synechron;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class UIController {
	@Autowired
	private RestTemplate restTemplate;
	
	@Value("${math.service.base.url}")
	private String mathServiceBaseUrl;
	
	@Value("${math.service.square.url}")
	private String mathServiceSquareUrl;
	
	@Value("${math.service.cube.url}")
	private String mathServiceCubeUrl;
	
	@PostMapping("/square/{num}")
	public HttpEntity<Long> getSquare(@PathVariable int num) {
		String url = mathServiceBaseUrl + mathServiceSquareUrl + "/" + num;
		return restTemplate.getForEntity(url, Long.class);
	}
	
	@PostMapping("/cube/{num}")
	public HttpEntity<Long> getCube(@PathVariable int num) {
		String url = mathServiceBaseUrl + mathServiceCubeUrl + "/" + num;
		return restTemplate.getForEntity(url, Long.class);
	}

}
