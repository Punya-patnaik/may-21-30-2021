package com.synechron;

import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	//http://localhost:8080/hello -> TGIF
	
	@GetMapping("/hello")
	public String greet() {
		return "TGIF";
	}
	
	//http://localhost:8080/bye/Ram -> Bye Bye Ram
	@GetMapping("/bye/{name}")
	public String bye(@PathVariable("name") String name) {
		return "Bye bye " + name;
	}
	
	@PostMapping("/now")
	public String getTime() {
		return LocalDateTime.now().toLocalTime().toString();
	}
	
	//http://localhost:8080/person?name=Sam&age=12
	@PostMapping("/person")
	public String getPersonInfo(@RequestParam("name") String name, @RequestParam("age") int age) {
		return "Hi " + name + "! You are " + age + " years old";
	}
}
