package com.greatlearning.library.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.greatlearning.library.entity.Book;
import com.greatlearning.library.service.BookService;

@Controller
@RequestMapping("/books")
public class BookController
{
	@Autowired
	private BookService bookService;
	
	@RequestMapping("/list")
	public String findAll(Model model)
	{
		List<Book> booklist=bookService.findAll();
		model.addAttribute("booklist", booklist);
		
		return "Books";
	}
	
	
	@RequestMapping("/save")
	public String save(@RequestParam("id") Integer id
			,@RequestParam("title") String title,
			@RequestParam("author") String author,
			@RequestParam("category") String category)
	{
		Book b=null;
		if(id!=-1)
		{
			b=bookService.findById(id);
			b.setAuthor(author);
			b.setCategory(category);
			b.setCategory(category);
			b.setTitle(title);
		}
		else
		 b=new Book(title,author,category);
		bookService.save(b);
		
		return "redirect: list";
	}
	
	
	@RequestMapping("/addBook")
	public String addBook()
	{
		return "BookForm";
	}
	
	
}
