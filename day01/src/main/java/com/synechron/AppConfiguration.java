package com.synechron;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfiguration {
	
	@Bean
	public List<String> numericOperations() {
		return Arrays.asList("add", "sum", "product", "multiply", "square");
	}
	
	@Bean
	public List<String> menu() {
		return Arrays.asList("Vadapav", "Sandwich", "Dosa");
	}
}
