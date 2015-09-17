package com.lashouinc.library.service.mappers;

import java.util.List;
import java.util.Map;

import com.lashouinc.library.service.domain.Book;

public interface BookMapper {
	int add(Book book);
	int countByCondition(Map<String,Object> condition);
	int updateStatusById(Book book);
	List<Book> findByCondition(Map<String,Object> condition);
}
