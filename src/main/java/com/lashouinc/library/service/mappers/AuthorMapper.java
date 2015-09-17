package com.lashouinc.library.service.mappers;

import com.lashouinc.library.service.domain.Author;

public interface AuthorMapper {
	int add(Author author);
	Author selectByName(String name);
}