package com.lashouinc.library.web.bean;

import java.io.Serializable;

public class BookInfoImagesBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String small;
	private String large;
	private String medium;
	
	public BookInfoImagesBean() {}

	public String getSmall() {
		return small;
	}

	public void setSmall(String small) {
		this.small = small;
	}

	public String getLarge() {
		return large;
	}

	public void setLarge(String large) {
		this.large = large;
	}

	public String getMedium() {
		return medium;
	}

	public void setMedium(String medium) {
		this.medium = medium;
	}
}
