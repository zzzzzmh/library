package com.lashouinc.library.web;

import org.springframework.stereotype.Controller;


@Controller
public class AdminController {
	
	//申请列表，要不要加审批流
	public void applyList() {}
	
	//录入
	public void add() {
		
		/*
		// 抓去内容
		String url = "https://api.douban.com/v2/book/isbn/:" + "9787115316066";
		String str = HttpClient.getStr(url);

		// 解析json
		BookInfoErrorBean errorBean = null;
		BookInfoBean infoBean = null;
		if (str == null || "".equals(str)) {
		} else {
			errorBean = JsonUtil.json2GenericObject(str,
					new TypeReference<BookInfoErrorBean>() {
					});
			if (errorBean.getCode() != null) {
				System.out.println(errorBean);
			} else {
				infoBean = JsonUtil.json2GenericObject(str,
						new TypeReference<BookInfoBean>() {
						});
			}
		}
		// 写记录
		if (infoBean != null) {
			int id = bookService.insertBook(infoBean);
		}
		*/
		
	}
	
	//现有图书列表
	public void bookList() {}
	
	//无此书处理
	
}
