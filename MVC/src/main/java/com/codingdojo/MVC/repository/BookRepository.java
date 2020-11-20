package com.codingdojo.MVC.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.MVC.models.Book;

@Repository
public interface BookRepository  extends CrudRepository<Book, Long>{
	List<Book> findAll();
	Long deleteByTitleStartingWith(String search);
}
