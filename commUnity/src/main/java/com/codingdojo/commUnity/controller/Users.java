package com.codingdojo.commUnity.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.commUnity.models.Event;
import com.codingdojo.commUnity.models.User;
import com.codingdojo.commUnity.services.UserService;


@Controller
public class Users {
private final UserService userService;
	
//	private final String[] states = { "AK", "AL", "AR", "AZ", "CA", "CO", "CT", "DE", "FL", "GA", "HI", "IA", "ID",
//        "IL", "IN", "KS", "KY", "LA", "MA", "MD", "ME", "MI", "MN", "MO", "MS", "MT", "NC", "ND", "NE", "NH", "NJ",
//        "NM", "NV", "NY", "OH", "OK", "OR", "PA", "RI", "SC", "SD", "TN", "TX", "UT", "VA", "VT", "WA", "WI", "WV",
//        "WY" };
    public Users(UserService userService) {
        this.userService = userService;
    }
    
    @RequestMapping("/")
    public String Log(@ModelAttribute("user") User user, Model model) {
//    	model.addAttribute("states", states);        
    	return "Login.jsp";
    }
    @RequestMapping("/register")
    public String Reg(@ModelAttribute("user") User user, Model model) {
//    	model.addAttribute("states", states);        
    	return "Reg.jsp";
    }
    @RequestMapping(value="/register", method=RequestMethod.POST)
    public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session) {
    	if(result.hasErrors()) {
    		return "Reg.jsp";
    	}
    	User u = userService.registerUser(user);
    	session.setAttribute("user_id", u.getId());
    	return "redirect:/timeline";
        // if result has errors, return the registration page (don't worry about validations just now)
        // else, save the user in the database, save the user id in session, and redirect them to the /home route
    }
    
    @RequestMapping(value="/login", method=RequestMethod.POST)
    public String loginUser(@Valid @RequestParam("email") String email, @ModelAttribute("user") User user, @RequestParam("password")String password, Model model, HttpSession session) {
    	boolean isAuthenticated = userService.authenticateUser(email, password);
    	if(isAuthenticated) {
    		User u = userService.findByEmail(email);
        	session.setAttribute("user_id", u.getId());
    		return "redirect:/timeline";
    	}else {
    		model.addAttribute("error", "Invalid Credentials. Try again.");
    		return "Log.jsp";
    	}
        // if the user is authenticated, save their user id in session
        // else, add error messages and return the login page
    }
    
    @RequestMapping("/timeline")
    public String dashboard(HttpSession session, Model model, @ModelAttribute("event") Event event) {
    	Long userId = (Long) session.getAttribute("user_id");
    	User u = userService.findUserById(userId);
    	model.addAttribute("user_logged", u);
//    	model.addAttribute("states", states);   
//		List<User> users = userService.allUsers();
//	    model.addAttribute("users", users);
//	    String state = u.getState();
//	    List<Event> eventsIn = userService.eventsInState(state);
//	    model.addAttribute("eventsIn", eventsIn);
//	    List<Event> eventsOut = userService.eventsOutOfState(state);
//	    model.addAttribute("eventsOut", eventsOut);
////	    model.addAttribute("states", states);  
//	    model.addAttribute("events", userService.allEvents());
    	return "dashboard.jsp";
        // get user from session, save them in the model and return the home page
    }
    @RequestMapping("/profile")
    public String profile(@ModelAttribute("user") User user, Model model) {
//    	model.addAttribute("states", states);        
    	return "Profile.jsp";
    }
    @RequestMapping("/editprofile")
    public String editprofile(@ModelAttribute("user") User user, Model model) {
//    	model.addAttribute("states", states);        
    	return "edit_profile.jsp";
    }
    @RequestMapping("/privacy&security")
    public String p_s(@ModelAttribute("user") User user, Model model) {
//    	model.addAttribute("states", states);        
    	return "privacyandsecurity.jsp";
    }
    @RequestMapping("/messages")
    public String messages(@ModelAttribute("user") User user, Model model) {
//    	model.addAttribute("states", states);        
    	return "Messages.jsp";
    }
    @RequestMapping(value="/events", method=RequestMethod.POST)
	public String eventsCreator(@Valid @ModelAttribute("event") Event event, BindingResult result, HttpSession session) {
		if(result.hasErrors()) {
			return "dashboard.jsp";
		}else {
			Long userId = (Long) session.getAttribute("user_id");
			User user = userService.findUserById(userId);
			event.setUser(user);
			userService.createEvents(event);
			return "redirect:/events";
		}
	}
    @RequestMapping("/events/{event_id}")
    public String eventList(@PathVariable("event_id") Long event_id, Model model) {
    	Event event = userService.findEventById(event_id);
    	model.addAttribute("event", event);
    	return "Event-Message.jsp";
    }
    @RequestMapping("/events/{event_id}/join")
    public String addJoin(@PathVariable("event_id")Long event_id, HttpSession session) {
		Long userId = (Long) session.getAttribute("user_id");
		User attendee = userService.findUserById(userId);
		Event eventsAttending = userService.findEventById(event_id);
		List<User> attendees = eventsAttending.getAttendees();
		attendees.add(attendee);
		eventsAttending.setAttendees(attendees);
		userService.saveUser(attendee);
		return "redirect:/events";
    }
    @RequestMapping("/events/{event_id}/cancel")
    public String cancel(@PathVariable("event_id")Long event_id, HttpSession session) {
		Long userId = (Long) session.getAttribute("user_id");
		User attendee = userService.findUserById(userId);
		Event eventsAttending = userService.findEventById(event_id);
		List<User> attendees = eventsAttending.getAttendees();
		attendees.remove(attendee);
		eventsAttending.setAttendees(attendees);
		userService.saveUser(attendee);
		return "redirect:/events";
    }
    @RequestMapping("/events/{event_id}/edit")
    public String edit(@PathVariable("event_id")Long event_id, Model model) {
		Event event = userService.findEventById(event_id);
		model.addAttribute("event", event);
//	    model.addAttribute("states", states);  
		return "eventEdit.jsp";
    }
    @PutMapping("/events/{id}/update")
    public String updateEvent(@PathVariable("id")Long id, Model model, @Valid @ModelAttribute("event") Event event, BindingResult result) {
    	if (result.hasErrors()) {
//    	    model.addAttribute("states", states);  
    		return "eventEdit.jsp";
    	}else {
    		this.userService.saveEvent(event);
    		return "redirect:/events/"+event.getId();
    	}
    }
    @RequestMapping("/events/{event_id}/delete")
    public String delete(@PathVariable("event_id")Long event_id, Model model) {
    	userService.deleteEvent(event_id);
		return "redirect:/events"; 
    }
    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }
}
