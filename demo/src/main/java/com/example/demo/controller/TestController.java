package com.example.demo.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	@RequestMapping(path = "{id}/{name}")
	public String returnString(@PathVariable int id,@PathVariable(value = "name") String nam) {
		return "hello..."+nam+" your id is "+id;
	}
}
