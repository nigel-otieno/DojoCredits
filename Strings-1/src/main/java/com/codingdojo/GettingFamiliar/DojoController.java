package com.codingdojo.GettingFamiliar;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
public class DojoController {
	
	@RequestMapping("/dojo")
	public String D(@RequestParam(value="g", required=false) String searchQuery) {
		return "The Dojo is awesome" + searchQuery;
	}
	@RequestMapping("/burbank")
	public String A(@RequestParam(value="g", required=false) String searchQuery) {
		return "Burbank Dojo" + searchQuery;
	}
	@RequestMapping("/burbank-dojo")
	public String C(@RequestParam(value="g", required=false) String searchQuery) {
		return "Burbank Dojo" + searchQuery;
	}
	

}
