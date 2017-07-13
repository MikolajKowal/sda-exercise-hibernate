package pl.sda.exercise.hibernate;

import pl.sda.exercise.hibernate.service.BookService;

/**
 * Exercise 04: get books by title
 */
public class Hibernate04 {

	public static void main(String[] args) {
		BookService bookService = new BookService();
		String title = "CHar";
		System.out.println("Books by name:");
		bookService.getBooksByTitle(title).forEach(System.out::println);
	}

}
