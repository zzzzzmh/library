package com.lashouinc.library;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lashou.common.util.Page;
import com.lashouinc.library.service.BookService;
import com.lashouinc.library.service.domain.Book;

public class TestAop {

	
	@Test  
    public void testHelloworld() {  
        ApplicationContext ctx =  new ClassPathXmlApplicationContext("spring/spring-context.xml");  
        BookService bookService = ctx.getBean("bookService", BookService.class);  
        
        Map<String, Object> map = new HashMap<String, Object>();
		map.put("borrower", 10);
		map.put("bookId", 18);
		map.put("page", 1);
		map.put("pageSize", 1);
		Page<Book> result = bookService.findByCondition(map);
		List<Book> books = result.getResult();
		if(books.size() > 0) {
			Book book = books.get(0);
			bookService.updateStatusById(book);
		} else {
			//没借不能还哦
		}
    }
	
}
