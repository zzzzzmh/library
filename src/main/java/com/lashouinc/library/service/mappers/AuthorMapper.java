package com.lashouinc.library.service.mappers;

import com.lashouinc.library.service.domain.Author;

public interface AuthorMapper {
	Author selectByName(String name);
	Author selectById(Integer id);
	int add(Author author);
}