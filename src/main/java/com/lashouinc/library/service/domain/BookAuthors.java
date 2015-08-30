package com.lashouinc.library.service.domain;

import java.io.Serializable;

public class BookAuthors implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private Integer bookId;
	private Integer authorId;
	
	public BookAuthors() {
		
	}
	public BookAuthors(Integer bookId, Integer authorId) {
		this.bookId = bookId;
		this.authorId = authorId;
	}
	
	public Integer getBookId() {
		return bookId;
	}
	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}
	public Integer getAuthorId() {
		return authorId;
	}
	public void setAuthorId(Integer authorId) {
		this.authorId = authorId;
	}
}