package com.lashouinc.library.service;


import java.util.ArrayList;

import javax.annotation.Resource;

import org.apache.commons.lang3.ArrayUtils;
import org.springframework.stereotype.Service;

import com.lashouinc.library.service.domain.Author;
import com.lashouinc.library.service.domain.Book;
import com.lashouinc.library.service.domain.BookAuthors;
import com.lashouinc.library.service.domain.BookCatalog;
import com.lashouinc.library.service.domain.BookTranslators;
import com.lashouinc.library.service.mappers.AuthorMapper;
import com.lashouinc.library.service.mappers.BookAuthorsMapper;
import com.lashouinc.library.service.mappers.BookCatalogMapper;
import com.lashouinc.library.service.mappers.BookMapper;
import com.lashouinc.library.service.mappers.BookTranslatorsMapper;
import com.lashouinc.library.web.bean.BookInfoBean;


@Service
public class BookService {
	
	@Resource
	AuthorMapper authorMapper;
	
	@Resource
	BookCatalogMapper bookCatalogMapper;
	
	@Resource
	BookMapper bookMapper;
	
	@Resource
	BookAuthorsMapper bookAuthorsMapper;
	
	@Resource
	BookTranslatorsMapper bookTranslatorsMapper;
	
	
	public int insertBook(BookInfoBean infoBean) {
		if(infoBean == null) {
			return -1;
		}
			
		String translators = ArrayUtils.toString(infoBean.getTranslator(), "");
		String authors = ArrayUtils.toString(infoBean.getAuthor(), "");
		
		Book book = new Book();
		book.setTitle(infoBean.getTitle());
		book.setSubtitle(infoBean.getSubtitle());
		book.setOriginTitle(infoBean.getOrigin_title());
		book.setAltTitle(infoBean.getAlt_title());
		book.setPubdate(infoBean.getPubdate());
		book.setPublisher(infoBean.getPublisher());
		book.setImg(infoBean.getImages().getLarge());
		book.setBinding(infoBean.getBingding());
		book.setDoubanId(String.valueOf(infoBean.getId()));
		book.setIsbn10(infoBean.getIsbn10());
		book.setIsbn13(infoBean.getIsbn13());
		book.setPrice(infoBean.getPrice());
		book.setPages(infoBean.getPages());
		book.setTranslators(translators);
		book.setAuthors(authors);
		bookMapper.add(book);
		Integer id = book.getId();
		if(id > 0) {
			//book catalog
			BookCatalog bookCatalog = new BookCatalog();
			bookCatalog.setBookId(id);
			bookCatalog.setCatalog(infoBean.getCatalog());
			bookCatalog.setSummary(infoBean.getSummary());
			bookCatalogMapper.add(bookCatalog);
			
			//author translators 
			ArrayList<Integer> authorIds = new ArrayList<Integer>();
			ArrayList<Integer> translatorIds = new ArrayList<Integer>();
			String[] authors1 = infoBean.getAuthor();
			String[] translators1 = infoBean.getTranslator();
			
			for (int i = 0; i < authors1.length; i++) {
				String authorStr = authors1[i];
				System.out.println(authorStr);
				Author author = authorMapper.selectByName(authorStr);
				if(author!= null && author.getId() > 0) {
					authorIds.add(author.getId());
				} else {
					Author author2 = new Author(authorStr);
					authorMapper.add(author2);
					authorIds.add(author2.getId());
				}
			}
			
			for (int i = 0; i < translators1.length; i++) {
				String translatorStr = translators1[i];
				Author translator = authorMapper.selectByName(translatorStr);
				if(translator != null && translator.getId() > 0) {
					translatorIds.add(translator.getId());
				} else {
					Author translator2 = new Author(translatorStr);
					authorMapper.add(translator2);
					translatorIds.add(translator2.getId());
				}
			}
			
			//book_authors
			for(Integer i:authorIds) {
				BookAuthors bookAuthors = new BookAuthors(id, i);
				bookAuthorsMapper.add(bookAuthors);
			}
			//book_translators
			for(Integer i:translatorIds) {
				BookTranslators bookTranslators = new BookTranslators(id, i);
				bookTranslatorsMapper.add(bookTranslators);
			}
		}
		return id;
		
//		  `category_id` int(11) DEFAULT '0' COMMENT '分类',
//		  `tags` varchar(300) DEFAULT NULL COMMENT '标签',
//		  `owner` int(8) DEFAULT '0' COMMENT '所有者 0公司 员工id',
//		  `contributor` int(8) DEFAULT '0' COMMENT '贡献者 员工id',
//		`borrower` int(8) DEFAULT '0' COMMENT '借阅人'
//		  
	}
}
