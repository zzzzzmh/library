package com.lashouinc.library.service.domain;

import java.io.Serializable;
import java.sql.Timestamp;

public class BorrowLog implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public BorrowLog() {}
	
	private Integer id;
	private Integer borrower;
	private Timestamp borrowTime;
	private Timestamp back_time;
	private Integer bookId;

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getBorrower() {
		return borrower;
	}
	public void setBorrower(Integer borrower) {
		this.borrower = borrower;
	}
	public Timestamp getBorrowTime() {
		return borrowTime;
	}
	public void setBorrowTime(Timestamp borrowTime) {
		this.borrowTime = borrowTime;
	}
	public Timestamp getBack_time() {
		return back_time;
	}
	public void setBack_time(Timestamp back_time) {
		this.back_time = back_time;
	}
	public Integer getBookId() {
		return bookId;
	}
	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}
}
