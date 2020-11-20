package com.codingdojo.commUnity.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.commUnity.models.Event;
import com.codingdojo.commUnity.models.User;
import com.codingdojo.commUnity.repository.EventRepository;
import com.codingdojo.commUnity.repository.UserEventRepository;
import com.codingdojo.commUnity.repository.UserRepository;




@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private UserEventRepository userEventRepository;
	    
 
   
    // register user and hash their password
    public User registerUser(User user) {
        String hashed = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
        user.setPassword(hashed);
        return userRepository.save(user);
    }
    
    // find user by email
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
    
    // find user by id
    public User findUserById(Long id) {
    	Optional<User> u = userRepository.findById(id);
    	
    	if(u.isPresent()) {
            return u.get();
    	} else {
    	    return null;
    	}
    }
    
    // authenticate user
    public boolean authenticateUser(String email, String password) {
        // first find the user by email
        User user = userRepository.findByEmail(email);
        // if we can't find it by email, return false
        if(user == null) {
            return false;
        } else {
            // if the passwords match, return true, else, return false
            if(BCrypt.checkpw(password, user.getPassword())) {
                return true;
            } else {
                return false;
            }
        }
    }
    @Autowired
	public UserRepository userRepo;
	@Autowired
	public EventRepository eventRepo;
	public List<User> allUsers(){
		return userRepo.findAll();
	}
	public List<Event> allEvents(){
		return eventRepo.findAll();
	}
	public List<Event> eventsInState(String state) {
        return eventRepo.findByState(state);
    }
	public List<Event> eventsOutOfState(String state) {
	    return eventRepo.findByStateIsNot(state);
	}
	public User createUser(User user) {
        return userRepo.save(user);
    }
	public Event createEvents(Event event) {
        return eventRepo.save(event);
    }
	public User findUser(Long user_id) {
		// TODO Auto-generated method stub
		return userRepo.findById(user_id).orElse(null);
	}

	public Event findEvent(Long event_id) {
		// TODO Auto-generated method stub
		return eventRepo.findById(event_id).orElse(null);
	}

	public UserRepository getUserRepo() {
		return userRepo;
	}

	public void setUserRepo(UserRepository userRepo) {
		this.userRepo = userRepo;
	}

	public EventRepository getEventRepo() {
		return eventRepo;
	}

	public void setEventRepo(EventRepository eventRepo) {
		this.eventRepo = eventRepo;
	}

	public Event findEventById(Long event_id) {
		// TODO Auto-generated method stub
		return eventRepo.findById(event_id).orElse(null);
	}

	public void saveUser(User attendee) {
		userRepo.save(attendee);
	}

	public Event saveEvent(@Valid Event event) {
		return this.eventRepo.save(event);
	}

	public void deleteEvent(Long event_id) {
		eventRepo.deleteById(event_id);
	}
	
    
}

