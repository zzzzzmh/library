package com.lashouinc.library.web;


import java.util.HashMap;
import java.util.Map;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lashou.common.util.Page;
import com.lashouinc.library.service.BookService;
import com.lashouinc.library.service.domain.Book;

@Controller
public class IndexController {

	@Resource
	BookService bookService;

	// 首页
	@ResponseBody
	@RequestMapping({ "/", "/home" })
	public void Index(
			@RequestParam(value = "category", required = false) Integer category,
			@RequestParam(value = "page", required = true, defaultValue = "1") int page) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("pageSize", 5);
		if(category != null) {
			map.put("category_id", category);
		}
		map.put("page", page);
		Page<Book> result = bookService.findByCondition(map);
		
		System.out.println(result.getTotalCount());
		System.out.println(result.getResult());
		
	}

	// 搜索
	@RequestMapping("/search")
	public void search(
			@RequestParam(value = "keyword", required = true) String keyword,
			@RequestParam(value = "page", required = true, defaultValue = "1") int page) {

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("pageSize", 20);
		map.put("title", keyword);
		map.put("page", page);
		
		Page<Book> result = bookService.findByCondition(map);

		System.out.println(result.getTotalCount());
		System.out.println(result.getResult());

	}

	// 我的图书
	@ResponseBody
	@RequestMapping("/list")
	public void list(
			@RequestParam(value = "page", required = true, defaultValue = "1") int page) {
		
		System.out.println("borrower");
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("pageSize", 3);
//		map.put("category_id", 0);
		map.put("page", page);
		map.put("borrower", 10);
		Page<Book> result = bookService.findByCondition(map);

		System.out.println(result.getTotalCount());
		System.out.println(result.getResult());

	}

	// 我的图书归还
	//http://localhost:8080/library/return/bookId/18
	@RequestMapping("/return/bookId/{bookId}")
	public void returnBook(@PathVariable(value = "bookId") int bookId) {
		// 列表里点击归还
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("borrower", 10);
		map.put("bookId", bookId);
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
	
	// 书籍详情
	@RequestMapping("/detail/bookId/{bookId}")
	public void bookDetail(@PathVariable("bookId") String bookId) {

		// 谁看过此书
	}
}