package com.codingdojo.relationships.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RelationshipController {
	
//	private final RelationshipService relationshipService;
//
//    public RelationshipController (RelationshipService relationshipService) {
//        this.relationshipService = relationshipService;
//    }
	@RequestMapping("/students")
	public String home() {
		return "/relationships/Dashboard.jsp";

	}
	@RequestMapping("/students/new")
	public String studentsNew() {
		return "/relationships/Students.jsp";
		
	}
	@RequestMapping("/contact/new")
	public String contact() {
		return "/relationships/ContactInfo.jsp";
		
	}
//	@RequestMapping("/students")
//	public String students() {
//		return "/relationships/Dashboard.jsp";
//	}
//	@RequestMapping("/students")
//	public String contact() {
//		return "/relationships/Dashboard.jsp";
//	}
}
