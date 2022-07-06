package com.greatlearning.library.service;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

import com.greatlearning.library.entity.Book;

@Repository
public interface BookService {

	List<Book> findAll();
	
	public void save (Book b);
	public Book findById(Integer id);

}
