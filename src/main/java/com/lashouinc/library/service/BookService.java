package com.lashouinc.library.service;



import java.util.Map;

import com.lashou.common.util.Page;
import com.lashouinc.library.service.domain.Book;
import com.lashouinc.library.web.bean.BookInfoBean;


public interface BookService {
	
	public int insertBook(BookInfoBean infoBean);	
	public int countByCondition(Map<String,Object> condition);
	public Page<Book> findByCondition(Map<String,Object> condition);
	public void updateStatusById(Book book);
}
