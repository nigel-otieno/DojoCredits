package com.codingdojo.Roster.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.Roster.models.ContactInfo;

@Repository
public interface ContactInfoRepository extends CrudRepository<ContactInfo, Long>  {
	List<ContactInfo> findAll();
}

