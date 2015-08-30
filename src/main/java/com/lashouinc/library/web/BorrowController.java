package com.lashouinc.library.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BorrowController {
	@ResponseBody
	public String index() {
		return "借阅页面, 直接扫描页面，不需要登录";
	}
	
}