package com.lashouinc.library.web.bean;

import java.io.Serializable;

public class BookInfoTagsBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private Integer count;
	private String name;
	private String title;
	
	public BookInfoTagsBean() {}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}
