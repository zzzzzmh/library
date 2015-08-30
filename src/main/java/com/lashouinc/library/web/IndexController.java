package com.lashouinc.library.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.codehaus.jackson.type.TypeReference;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lashou.common.util.JsonUtil;
import com.lashouinc.library.common.util.HttpClient;
import com.lashouinc.library.web.bean.BookInfoBean;
import com.lashouinc.library.web.bean.BookInfoErrorBean;


@Controller
public class IndexController {
	//首页
	@ResponseBody
	@RequestMapping({"/", "/home"})
	public void Index() {
		//抓去内容
		String url = "https://api.douban.com/v2/book/isbn/:" + "9787115316066";
		String str = HttpClient.getStr(url);
		
		//解析json
		BookInfoErrorBean errorBean = null;
		BookInfoBean infoBean = null;
		if(str == null || "".equals(str)) {
		} else {
			errorBean = JsonUtil.json2GenericObject(str, new TypeReference<BookInfoErrorBean>() {}) ;
			if(errorBean.getCode() != null) {
				System.out.println(errorBean);
			} else {
				infoBean = JsonUtil.json2GenericObject(str, new TypeReference<BookInfoBean>() {}) ;
			}
		}
		
		if(infoBean != null) {
			/**
			 *  book
			 *  book_authors
			 *  book_catelog
			 *  book_translators
			 *  category
			 *	authors
			 */
		}
	}
	
	
	//搜索
	public void search() {
	}
	
	//我的图书
	public void list() {
	}
	
	//我的图书归还
	public void back() {
		//列表里点击归还
	}
	
	//书籍详情
	public void bookDetail() {
	
		//谁看过此书
	}
}