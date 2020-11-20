package com.codingdojo.HelloHuman;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HelloController {
	
	@RequestMapping("/your_server")
	public String hello(@RequestParam(value="q", required = false) String searchQuery) {
		if(searchQuery == null) {
			return "hello Human";
		}else {
			return "hello:" + searchQuery;
		}
		
	}
	
}
