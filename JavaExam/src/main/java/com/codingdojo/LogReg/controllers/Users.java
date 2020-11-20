package com.codingdojo.LogReg.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.LogReg.models.User;
import com.codingdojo.LogReg.services.UserService;

@Controller
public class Users {
private final UserService userService;
    
    public Users(UserService userService) {
        this.userService = userService;
    }
    
    @RequestMapping("/")
    public String registerForm(@ModelAttribute("user") User user) {
        return "LogReg.jsp";
    }
    @RequestMapping("/")
    public String login() {
        return "LogReg.jsp";
    }
    
    @RequestMapping(value="/registration", method=RequestMethod.POST)
    public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session) {
    	if(result.hasErrors()) {
    		return "LogReg.jsp";
    	}
    	User u = userService.registerUser(user);
    	session.setAttribute("user_id", u.getId());
    	return "redirect:/courses";
        // if result has errors, return the registration page (don't worry about validations just now)
        // else, save the user in the database, save the user id in session, and redirect them to the /home route
    }
    
    @RequestMapping(value="/login", method=RequestMethod.POST)
    public String loginUser(@RequestParam("email") String email, @RequestParam("password") String password, Model model, HttpSession session) {
    	boolean isAuthenticated = userService.authenticateUser(email, password);
    	if(isAuthenticated) {
    		User u = userService.findByEmail(email);
        	session.setAttribute("user_id", u.getId());
    		return "redirect:/courses";
    	}else {
    		model.addAttribute("error", "Invalid Credentials. Try again.");
    		return "LogReg.jsp";
    	}
        // if the user is authenticated, save their user id in session
        // else, add error messages and return the login page
    }
//    @RequestMapping("/courses")
//    public String dashboard(HttpSession session, Model model, @ModelAttribute("course") Course course) {
//    	Long userId = (Long) session.getAttribute("user_id");
//    	User u = userService.findUserById(userId);
//    	model.addAttribute("user_logged", u); 
//		List<User> users = userService.allUsers();
//	    model.addAttribute("users", users);
//	    model.addAttribute("events", userService.allCourses());
//    	return "dashboard.jsp";
//        // get user from session, save them in the model and return the home page
//    }
    
//    @RequestMapping(value="/courses", method=RequestMethod.POST)
//	public String coursesCreator(@Valid @ModelAttribute("event") Course course, BindingResult result, HttpSession session) {
//		if(result.hasErrors()) {
//			return "homePage.jsp";
//		}else {
//			Long userId = (Long) session.getAttribute("user_id");
//			User user = userService.findUserById(userId);
//			event.setUser(user);
//			userService.createEvents(event);
//			return "redirect:/courses";
//		}
//	}
//    
//    @RequestMapping("/home")
//    public String home(HttpSession session, Model model) {
//    	Long userId = (Long) session.getAttribute("user_id");
//    	User u = userService.findUserById(userId);
//    	model.addAttribute("user", u);
//    	return "homePage.jsp";
//        // get user from session, save them in the model and return the h;ome page
//    }
//    @RequestMapping("/logout")
//    public String logout(HttpSession session, Object user) {
//    	session.invalidate();
//    	return "redirect:/login";
//        // invalidate session
//        // redirect to login page
//    }
}
