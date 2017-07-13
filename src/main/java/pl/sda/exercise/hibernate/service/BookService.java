package pl.sda.exercise.hibernate.service;

import java.util.LinkedList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import pl.sda.exercise.hibernate.model.Book;

public class BookService {

	private SessionFactory sessionFactory;
	public BookService() {
		sessionFactory = new Configuration().configure().buildSessionFactory();
	}
	public List<Book> getBooks() {
		Session session = sessionFactory.openSession();
		List<Book> books = session.createQuery("from Book", Book.class).list();
		session.close();
		return books;
	}

	public long countBooks() {
		
		Session session = sessionFactory.openSession();
		long booksCount = session.createQuery("select count(*) from Book", Long.class)
				.uniqueResult();
		session.close();
		return booksCount;
	}

	public Book getBookById(int bookId) {
		
		Session session = sessionFactory.openSession();
		
		Query<Book> query = session.createQuery("from Book b where b.id = :id", Book.class);
		query.setParameter("id", bookId);
		
		Book bookToReturn = query.uniqueResult();
		

		session.close();
	
		return bookToReturn;
	}

	public List<Book> getBooksByTitle(String title) {
		Session session = sessionFactory.openSession();
		
		Query<Book> createQuery = session.createQuery("from Book b where"
				+ " b.title like :title",Book.class);
		createQuery.setParameter("title", "%"+title+ "%");
		List<Book> list = createQuery.list();
		session.close();
		return list;
	}

	public void createBook(Book book) {
		//TODO
		Session session = sessionFactory.openSession();
		session.save(book);
		session.close();
	}

	public void updateBook(Book book) {
		Session session = sessionFactory.openSession();
		Transaction beginTransaction = session.beginTransaction();
		session.update(book);
		beginTransaction.commit();
		session.close();
		//TODO
	}

	public void deleteBook(Book book) {
		//TODO
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.delete(book);
		transaction.commit();
		session.close();
	}

}
