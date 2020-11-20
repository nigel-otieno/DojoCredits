package com.codingdojo.Roster.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.Roster.models.Dorms;

@Repository
public interface DormsRepository extends CrudRepository<Dorms, Long> {
	List<Dorms> findAll();

}
