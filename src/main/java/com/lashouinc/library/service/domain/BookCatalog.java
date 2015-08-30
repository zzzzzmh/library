package com.lashouinc.library.service.domain;

import java.io.Serializable;

public class BookCatalog implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer bookId;
	private String catalog;
	private String summary;
	
	public BookCatalog() {}
	
	public Integer getBookId() {
		return bookId;
	}

	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}

	public String getCatalog() {
		return catalog;
	}

	public void setCatalog(String catalog) {
		this.catalog = catalog;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	
}
