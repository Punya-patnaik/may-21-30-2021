package com.synechron;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Configuration
public class AppConfiguration {
	
	@Bean
//	@Lazy
	public List<String> numericOperations() {
		return Arrays.asList("add", "sum", "product", "multiply", "square");
	}
	
	@Bean
	public List<String> menu() {
		return Arrays.asList("Vadapav", "Sandwich", "Dosa");
	}
}
