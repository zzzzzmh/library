package com.lashouinc.library.service.domain;

import java.io.Serializable;

public class BookTranslators implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer bookId;
	private Integer translatorId;
	
	public BookTranslators() {
		
	}
	public BookTranslators(Integer bookId, Integer translatorId) {
		this.bookId = bookId;
		this.translatorId = translatorId;
	}
	
	public Integer getBookId() {
		return bookId;
	}
	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}
	
	public Integer getTranslatorId() {
		return translatorId;
	}
	public void setTranslatorId(Integer translatorId) {
		this.translatorId = translatorId;
	}
	
}
