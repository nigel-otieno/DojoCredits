package com.codingdojo.cummUnityX.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.cummUnityX.models.UserEvent;


@Repository
public interface UserEventRepository extends CrudRepository <UserEvent, Long>{
	List<UserEvent> findAll();

	@Query("SELECT e FROM Event e JOIN e.attendees a")
	List<UserEvent> joinUserEvents();
	
	@Query("SELECT e FROM Event e JOIN e.attendees a")
	List<Object[]> joinUserAndEvents();
}
