package pl.sda.exercise.hibernate.service;

import java.util.LinkedList;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import pl.sda.exercise.hibernate.model.Author;

public class AuthorService {

	SessionFactory sessionFactory;
	
	public List<Author> getAuthors() {
		Session session = sessionFactory.openSession();
		List<Author> list = session.createQuery("from Author", Author.class).list();
		list.forEach(author -> Hibernate.initialize(author.getBooks()));
		session.close();
		return list;
	}

	public AuthorService() {
		sessionFactory = new Configuration().configure().buildSessionFactory();
	}

	
}
