package com.codingdojo.cummUnityX.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.cummUnityX.models.Event;
import com.codingdojo.cummUnityX.models.User;


@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	User findByEmail(String email);
	List<User> findAll();
	Event findByName(String name);
}


