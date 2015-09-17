package com.lashouinc.library.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.ArrayUtils;
import org.springframework.stereotype.Service;

import com.lashou.common.util.Page;
import com.lashouinc.library.service.BookService;
import com.lashouinc.library.service.domain.Author;
import com.lashouinc.library.service.domain.Book;
import com.lashouinc.library.service.domain.BookAuthors;
import com.lashouinc.library.service.domain.BookCatalog;
import com.lashouinc.library.service.domain.BookTranslators;
import com.lashouinc.library.service.domain.BorrowLog;
import com.lashouinc.library.service.mappers.AuthorMapper;
import com.lashouinc.library.service.mappers.BookAuthorsMapper;
import com.lashouinc.library.service.mappers.BookCatalogMapper;
import com.lashouinc.library.service.mappers.BookMapper;
import com.lashouinc.library.service.mappers.BookTranslatorsMapper;
import com.lashouinc.library.service.mappers.BorrowLogMapper;
import com.lashouinc.library.web.bean.BookInfoBean;

@Service("bookService")
public class BookServiceImpl implements BookService{
	
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
	
	@Resource
	BorrowLogMapper borrowLogMapper;
	
	
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
	}

	
	public int countByCondition(Map<String,Object> condition) {
		return bookMapper.countByCondition(condition);
	}
	
	public Page<Book> findByCondition(Map<String,Object> condition) {
		Integer pageSize = 5;
		if(condition.get("pageSize") != null) {
			pageSize = (Integer) condition.get("pageSize");
		}
		Page<Book> page = new Page<Book>();
		page.setPageSize(pageSize);
		int cnt = countByCondition(condition);
		System.out.println(cnt);
		if(cnt > 0) {
			page.setTotalCount(cnt);
			Integer totalPages = (int) (Math.ceil(cnt/pageSize)+1);
			Integer currentPage = 1;
			if(condition.get("page") != null) {
				currentPage = (Integer) condition.get("page");
			}			
			currentPage = currentPage>0?currentPage:1;
			if(currentPage > totalPages) {
				currentPage = totalPages;
				page.setPageNo(currentPage);
			}
			condition.put("offset", (currentPage-1)*pageSize);
			List<Book> result = bookMapper.findByCondition(condition);
			page.setResult(result);
		}
		return page;
	}
	
	
	public void updateStatusById(Book book) {
		
		BorrowLog borrowLog = new BorrowLog();
		borrowLog.setBookId(book.getId());
		borrowLog.setBorrower(book.getBorrower());
		borrowLog.setBorrowTime(book.getBorrowTime());
		
		book.setBorrower(0);
		book.setBorrowNum(book.getBorrowNum()+1);
		
		bookMapper.updateStatusById(book);
		borrowLogMapper.add(borrowLog);
	}
}

