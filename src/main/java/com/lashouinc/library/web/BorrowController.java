package com.lashouinc.library.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BorrowController {
	
	@ResponseBody
	@RequestMapping("/borrow")
	public String index() {
		return "借阅页面, 直接扫描页面，不需要登录";
	}
	
	//borrow?str = dfaddfsd
	//str = uid=&bookId=&sessionId=&active_time=121314141
}