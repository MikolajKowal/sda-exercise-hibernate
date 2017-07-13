package pl.sda.exercise.hibernate.model;

import java.util.Set;

public class Author {
	
	private Integer authorId;
	private String firstName; 
	private String lastName;
	private Set<Book> books;
	
	public Integer getAuthorId() {
		return authorId;
	}
	public void setAuthorId(Integer authorId) {
		this.authorId = authorId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	@Override
	public String toString() {
		return "Author [authorId=" + authorId + ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}
	public Set<Book> getBooks() {
		return books;
	}
	public void setBooks(Set<Book> books) {
		this.books = books;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	

}
