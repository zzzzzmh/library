package com.lashouinc.library.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ExplainController {
	@ResponseBody
	public String contribute() {
		//return "共享页面说明";
		return "共享采用线下的方式，在书签中写明你的员工号，可以选择赎回，下一次员工归还，书就不外借，如果你离职，"
				+ "公司会选择邮寄给你，最短时间要3个月，可以直接交到hrbp处，或者放在书籍的最底格，hrbp会每日去收集";
	}
	
	@ResponseBody
	public String borrow() {
		return "借阅说明：书号有个生成规则，按书号生成二维码，pc页面扫描二维码，在页面中选择借阅 "
				+ "点击借阅既可以完成借阅，2个小时默认被取走，如果没取，请选择延期或者退回或者无此书"
				+ "请按照书名、封面、和书号和摆放位置 正确的取书";
	}
}