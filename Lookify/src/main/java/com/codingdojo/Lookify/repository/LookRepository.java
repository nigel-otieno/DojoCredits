package com.codingdojo.Lookify.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.Lookify.models.Look;

@Repository
public interface LookRepository extends CrudRepository<Look, Long>{
	List<Look> findAll();
	Long deleteByTitleStartingWith(String search);
	List<Look> findByArtistContaining(String artist);
//	List<Look> findTop10ByRatingDesc();
}

