package com.codingdojo.Roster.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.Roster.models.ContactInfo;
import com.codingdojo.Roster.models.Dorms;
import com.codingdojo.Roster.models.Students;
import com.codingdojo.Roster.services.RosterServices;

@Controller
public class RosterController {
	@Autowired
	private RosterServices rosterServices;
	@RequestMapping("/students")
	public String home(@ModelAttribute("Student") Students student, Model model) {
		List<Students> students = rosterServices.allStudents();
	    model.addAttribute("students", students);
		return "roster/Dashboard.jsp";

	}
	@RequestMapping("/students/new")
	public String studentsNew(Model model) {
		Students students = new Students();
		model.addAttribute("student", students);
		return "roster/Students.jsp";
		
	}
	@RequestMapping(value="/create/new", method=RequestMethod.POST)
	public String studentsCreate(@Valid @ModelAttribute("student") Students student, BindingResult result) {
		if(result.hasErrors()) {
			return "roster/Students.jsp";
		}else {
			rosterServices.createStudent(student);
			return "redirect:/contact/new";
		}
		
	}
	@RequestMapping("/contact/new")
	public String contactNew(Model model) {
		ContactInfo contactInfo = new ContactInfo();
		model.addAttribute("contactInfo", contactInfo);
		List<Students> students = rosterServices.allStudents();
	    model.addAttribute("students", students);
		return "roster/ContactInfo.jsp";
		
	}
	@RequestMapping(value="/contact/create", method=RequestMethod.POST)
	public String contactCreate(@Valid @ModelAttribute("contactInfo") ContactInfo contactInfo, BindingResult result) {
		if(result.hasErrors()) {
			return "roster/ContactInfo.jsp";
		}else {
			rosterServices.createContactInfo(contactInfo);
			return "redirect:/students";
		}
	}
	@RequestMapping("/dorms/new")
	public String dormNew(Model model) {
		Dorms dorms = new Dorms();
		model.addAttribute("dorm", dorms);
		List<Students> students = rosterServices.allStudents();
	    model.addAttribute("students", students);
		return "roster/NewDorm.jsp";
		
	}
	@RequestMapping(value="/dorms/new", method=RequestMethod.POST)
	public String dormCreate(@Valid @ModelAttribute("dorm") Dorms dorm, BindingResult result) {
		if(result.hasErrors()) {
			return "roster/NewDorm.jsp";
		}else {
			rosterServices.createDorms(dorm);
			return "redirect:/dorms/new"+dorm.getId();
		}
	}
	@RequestMapping("/dorms/create/")
	public String dormRender(@PathVariable("id") Long id, Model model) {
		Dorms dorms = new Dorms();
		model.addAttribute("dorm", dorms);
		List<Students> students = rosterServices.allStudents();
	    model.addAttribute("students", students);
		return "roster/Dorm.jsp";
		
	}
	@RequestMapping(value="/dorms/{id}/add", method=RequestMethod.POST)
	public String dormDisplay(@PathVariable("id") Long dorm_id, @RequestParam("student") Long student_id, Model model) {
		Students student = rosterServices.findStudent(student_id);
		student.setDorm(rosterServices.findDorm(dorm_id));
		rosterServices.createStudent(student);
		return "redirect:/dorms/"+dorm_id;
	}
	
}
