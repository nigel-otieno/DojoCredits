package com.codingdojo.Strings;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class HomeController {
	
	@RequestMapping("/")
	public String hello(@RequestParam(value="q", required = false) String searchQuery) {
		if(searchQuery == null) {
			return "nothing";
		}else {
			return "hello:" + searchQuery;
		}
		
	}
	
}
