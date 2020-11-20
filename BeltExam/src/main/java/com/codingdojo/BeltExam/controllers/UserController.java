package com.codingdojo.BeltExam.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.BeltExam.models.User;
import com.codingdojo.BeltExam.services.UserService;

public class UserController {
	 @RequestMapping("/")
	    public String LogReg(@ModelAttribute("user") User user, Model model) {     
	    	return "LogReg.jsp";
	    }
	  
	    @RequestMapping(value="/register", method=RequestMethod.POST)
	    public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session) {
	    	if(result.hasErrors()) {
	    		return "LogReg.jsp";
	    	}
	    	User u = UserService.registerUser(user);
	    	session.setAttribute("user_id", u.getId());
	    	return "redirect:/events";
	        // if result has errors, return the registration page (don't worry about validations just now)
	        // else, save the user in the database, save the user id in session, and redirect them to the /home route
	    }
	    
	    @RequestMapping(value="/login", method=RequestMethod.POST)
	    public String loginUser(@RequestParam("email") String email, @ModelAttribute("user") User user, @RequestParam("password") String password, Model model, HttpSession session) {
	    	boolean isAuthenticated = UserService.authenticateUser(email, password);
	    	if(isAuthenticated) {
	    		User u = UserService.findByEmail(email);
	        	session.setAttribute("user_id", u.getId());
	    		return "redirect:/events";
	    	}else {
	    		model.addAttribute("error", "Invalid Credentials. Try again.");
	    		return "LogReg.jsp";
	    	}
	        // if the user is authenticated, save their user id in session
	        // else, add error messages and return the login page
	    }
	    
}
