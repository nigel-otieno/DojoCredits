package com.codingdojo.MVC.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.MVC.models.Book;
import com.codingdojo.MVC.repository.BookRepository;

@Service
public class BookService {
	private final BookRepository bookRepository;
	
	public BookService(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}
	public java.util.List<Book> allBooks() {
        return bookRepository.findAll();
    }
    // creates a book
    public Book createAndUpdateBook(Book b) {
        return bookRepository.save(b);
    }
    // retrieves a book
    public Book findBook(Long id) {
        java.util.Optional<Book> optionalBook = bookRepository.findById(id);
        if(optionalBook.isPresent()) {
            return optionalBook.get();
        } else {
            return null;
        }
    }
    public Book updateBook(Long id, String title, String desc, String lang, Integer numOfPages) {
    	Book foundBook = findBook(id);
    	if(foundBook == null) {
    		return null;
    	}
    	foundBook.setTitle(title);
    	foundBook.setDescription(desc);
    	foundBook.setLanguage(lang);
    	foundBook.setNumberOfPages(numOfPages);
    	return bookRepository.save(foundBook);
    }
	public void deleteBook(Long id) {
		Optional<Book> optionalBook = bookRepository.findById(id);
		if(optionalBook.isPresent()) {
		bookRepository.deleteById(id);
		}
	}
}
