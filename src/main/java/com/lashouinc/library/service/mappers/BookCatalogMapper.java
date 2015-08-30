package com.lashouinc.library.service.mappers;

import com.lashouinc.library.service.domain.BookCatalog;

public interface BookCatalogMapper {
	BookCatalogMapper selectById(Integer id);
	int add(BookCatalog bookCatalog);
}
