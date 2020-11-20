package com.codingdojo.Roster.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.Roster.models.Students;

@Repository
public interface StudentsRepository  extends CrudRepository<Students, Long> {
	List<Students> findAll();
}
