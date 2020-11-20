package com.codingdojo.GettingFamiliar;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class CodingController {
	
	@RequestMapping("/coding")
	public String Coding(){
		return "Hello Coding Dojo";
	}
	@RequestMapping("/coding/python")
	public String Python() {
		return "Python is great";
	}
	@RequestMapping("/coding/java")
	public String Java(){
		return "python is not better than java";
	}

}
