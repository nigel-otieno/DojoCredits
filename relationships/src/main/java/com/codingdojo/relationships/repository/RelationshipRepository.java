package com.codingdojo.relationships.repository;

import java.util.List;

public interface RelationshipRepository extends CrudRepository<Relationship, Long> {
	List<Relationship> findAll();
	Long deleteByTitleStartingWith(String search);
}

