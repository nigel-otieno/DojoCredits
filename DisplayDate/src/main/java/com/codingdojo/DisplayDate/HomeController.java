package com.codingdojo.DisplayDate;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

@Controller
public class HomeController {
	@RequestMapping("/")
	public String home(Model model) {
		return "Index.jsp";
	}
	
	@RequestMapping("/Date")
	public String Date() {
		new java.util.Date();
		return "Date.jsp";
	}
	
	@RequestMapping("/Time")
	public String Time() {
		new java.util.Date();
		return "Time.jsp";
	}
}

