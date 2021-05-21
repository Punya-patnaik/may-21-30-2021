package com.synechron;

import java.time.LocalDateTime;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SampleController {
	
	@GetMapping("/home")
	public String getHomePage(HttpSession session) {
		String now = LocalDateTime.now().toLocalDate().toString();
		session.setAttribute("message", now);
		return "myhome"; //myhome is the View. It needs to get resolved to /myhome.jsp
	}
}
