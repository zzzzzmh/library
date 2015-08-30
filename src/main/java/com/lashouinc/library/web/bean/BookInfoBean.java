package com.lashouinc.library.web.bean;
import java.io.Serializable;


public class BookInfoBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private Rating rating;
	private String subtitle;
	private String origin_title;
	private String image;
	private String bingding;
	private String[] translator;
	private String[] author;
	private BookInfoTagsBean[] tags;
	private String catalog;
	private Integer pages;
	private BookInfoImagesBean images;
	private String alt;
	private Integer id;
	private String publisher;
	private String pubdate;
	private String isbn10;
	private String isbn13;
	private String title;
	private String url;
	private String alt_title;
	private String author_intro;
	private String summary;
	private String price;
	
	public BookInfoBean() {}

	public Rating getRating() {
		return rating;
	}

	public void setRating(Rating rating) {
		this.rating = rating;
	}

	public String getSubtitle() {
		return subtitle;
	}

	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}

	public String getOrigin_title() {
		return origin_title;
	}

	public void setOrigin_title(String origin_title) {
		this.origin_title = origin_title;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getBingding() {
		return bingding;
	}

	public void setBingding(String bingding) {
		this.bingding = bingding;
	}

	public String[] getTranslator() {
		return translator;
	}

	public void setTranslator(String[] translator) {
		this.translator = translator;
	}

	public String[] getAuthor() {
		return author;
	}

	public void setAuthor(String[] author) {
		this.author = author;
	}

	public BookInfoTagsBean[] getTags() {
		return tags;
	}

	public void setTags(BookInfoTagsBean[] tags) {
		this.tags = tags;
	}
	
	public Integer getPages() {
		return pages;
	}

	public void setPages(Integer pages) {
		this.pages = pages;
	}

	public BookInfoImagesBean getImages() {
		return images;
	}

	public void setImages(BookInfoImagesBean images) {
		this.images = images;
	}

	public String getAlt() {
		return alt;
	}

	public void setAlt(String alt) {
		this.alt = alt;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getAlt_title() {
		return alt_title;
	}

	public void setAlt_title(String alt_title) {
		this.alt_title = alt_title;
	}

	public String getAuthor_intro() {
		return author_intro;
	}

	public void setAuthor_intro(String author_intro) {
		this.author_intro = author_intro;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getPubdate() {
		return pubdate;
	}

	public void setPubdate(String pubdate) {
		this.pubdate = pubdate;
	}

	public String getCatalog() {
		return catalog;
	}

	public void setCatalog(String catalog) {
		this.catalog = catalog;
	}
}

class Rating implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private Integer max;
	private Integer numRaters;
	private Float average;
	private Integer min;
	
	public Rating() {}

	public Integer getMax() {
		return max;
	}

	public void setMax(Integer max) {
		this.max = max;
	}

	public Integer getNumRaters() {
		return numRaters;
	}

	public void setNumRaters(Integer numRaters) {
		this.numRaters = numRaters;
	}

	public Float getAverage() {
		return average;
	}

	public void setAverage(Float average) {
		this.average = average;
	}

	public Integer getMin() {
		return min;
	}

	public void setMin(Integer min) {
		this.min = min;
	}	
}

