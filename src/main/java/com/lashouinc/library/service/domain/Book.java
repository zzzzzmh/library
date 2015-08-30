package com.lashouinc.library.service.domain;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

public class Book implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String title;
	private String subtitle;
	private String originTitle;
	private String altTitle;
	private Integer categoryId;
	private String authors;
	private String translators;
	private Date pubdate;
	private String publisher;
	private String img;
	private String binding;
	private String doubanId;
	private String isbn10;
	private String isbn13;
	private String price;
	private Integer pages;
	private Integer owner;
	private Integer contributor;
	private Integer borrower;
	private Integer wanted;
	private String tags;
	private Timestamp addTime;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSubtitle() {
		return subtitle;
	}
	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}
	public String getOriginTitle() {
		return originTitle;
	}
	public void setOriginTitle(String originTitle) {
		this.originTitle = originTitle;
	}
	public String getAltTitle() {
		return altTitle;
	}
	public void setAltTitle(String altTitle) {
		this.altTitle = altTitle;
	}
	public Integer getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}
	public String getAuthors() {
		return authors;
	}
	public void setAuthors(String authors) {
		this.authors = authors;
	}
	public String getTranslators() {
		return translators;
	}
	public void setTranslators(String translators) {
		this.translators = translators;
	}
	public Date getPubdate() {
		return pubdate;
	}
	public void setPubdate(Date pubdate) {
		this.pubdate = pubdate;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getBinding() {
		return binding;
	}
	public void setBinding(String binding) {
		this.binding = binding;
	}
	public String getDoubanId() {
		return doubanId;
	}
	public void setDoubanId(String doubanId) {
		this.doubanId = doubanId;
	}
	public String getIsbn10() {
		return isbn10;
	}
	public void setIsbn10(String isbn10) {
		this.isbn10 = isbn10;
	}
	public String getIsbn13() {
		return isbn13;
	}
	public void setIsbn13(String isbn13) {
		this.isbn13 = isbn13;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public Integer getPages() {
		return pages;
	}
	public void setPages(Integer pages) {
		this.pages = pages;
	}
	public Integer getOwner() {
		return owner;
	}
	public void setOwner(Integer owner) {
		this.owner = owner;
	}
	public Integer getContributor() {
		return contributor;
	}
	public void setContributor(Integer contributor) {
		this.contributor = contributor;
	}
	public Integer getBorrower() {
		return borrower;
	}
	public void setBorrower(Integer borrower) {
		this.borrower = borrower;
	}
	public Integer getWanted() {
		return wanted;
	}
	public void setWanted(Integer wanted) {
		this.wanted = wanted;
	}
	public String getTags() {
		return tags;
	}
	public void setTags(String tags) {
		this.tags = tags;
	}
	public Timestamp getAddTime() {
		return addTime;
	}
	public void setAddTime(Timestamp addTime) {
		this.addTime = addTime;
	}
}
