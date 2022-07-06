package com.greatlearning.library.service;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.greatlearning.library.entity.Book;

public class BookServiceImpl implements BookService
{
	private SessionFactory sessionfactory;
	
	private Session session;
	
	
	
	public BookServiceImpl(SessionFactory sessionfactory) {
		this.sessionfactory = sessionfactory;
		
		
		try {
			session=this.sessionfactory.getCurrentSession();
		} 
		catch (HibernateException e)
		{
		 session=this.sessionfactory.openSession();	
		}
		
	}

	@Transactional
	public List<Book> findAll()
	{
		List<Book> booklist=session.createQuery("from Book").list();
		
		for(Book b:booklist)
		{
			System.out.println(b);
		}
		return booklist;
	}
	
	@Transactional
	public Book findById(Integer id)
	{
		Book book=session.get(Book.class, id);
	
		return book;
	}
	
	@Transactional
	public void save(Book book)
	{
		Transaction tr=session.beginTransaction();
		session.saveOrUpdate(book);
		tr.commit();
	}
	
	
	
} 
