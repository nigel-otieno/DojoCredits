package com.codingdojo.commUnity.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

import com.codingdojo.commUnity.models.Event;

public interface EventRepository extends CrudRepository<Event, Long> {
	List<Event> findAll();
	List<Event> findByState(String state);
	List<Event> findByStateIsNot(String state);
	
}
