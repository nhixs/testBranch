package com.Library;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Book {
	
	private Long id;
	private String name;
	private String edition;
	private String publisher;
	private double price;
	private String pages;
	private String bookshelf;
	
	protected Book() {
	}
	

	protected Book(Long id, String name, String edition, String publisher, double price, String pages, String bookshelf) {
		super();
		this.id = id;
		this.name = name;
		this.edition = edition;
		this.publisher = publisher;
		this.price = price;
		this.pages = pages;
		this.bookshelf = bookshelf;
	}


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEdition() {
		return edition;
	}

	public void setEdition(String edition) {
		this.edition = edition;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getPages() {
		return pages;
	}

	public void setPages(String pages) {
		this.pages = pages;
	}

	public String getBookshelf() {
		return bookshelf;
	}

	public void setBookshelf(String bookshelf) {
		this.bookshelf = bookshelf;
	}

	
	
	
	
	

}
