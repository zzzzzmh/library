package com.lashouinc.library.web;

import javax.annotation.Resource;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lashouinc.library.service.UserService;
import com.lashouinc.library.service.domain.User;

@Controller
@RequestMapping("/account")
public class AccountController {
	
	@Resource
	UserService userService;
	
	@RequestMapping("/login")
	public String login(ServletRequest request) {
		
		String url = WebUtils.getPathWithinApplication(WebUtils.toHttp(request));
		
		Subject subject = SecurityUtils.getSubject();
		if (subject.isRemembered()) {
			request.setAttribute("error", "默认登录的，需要重新登录确认身份"); 
		}
		
		//System.out.println(url);
		String s = (String) request.getAttribute("shiroLoginFailure");
		if(LockedAccountException.class.getName().equals(s)) {  
			request.setAttribute("error", "账号被锁定"); 
			System.out.println("账号被锁定");
        } else if(ExcessiveAttemptsException.class.getName().equals(s)) {  
        	request.setAttribute("error", "提交太频繁"); 
			System.out.println("提交太频繁");
        } else if(s != null) {  
        	request.setAttribute("error", "用户名/密码错误");  
        	System.out.println("用户名/密码错误");
        }
		
		return "account/login";
	}
	
	@RequestMapping("/logout")
	public void logout() {
		SecurityUtils.getSubject().logout();
	}
	
	@RequestMapping("/unauthorized")
	public String unauthorized() {
		return "account/unauthorized";
	}
	
	@RequestMapping("/logsubmit")
	public String logsubmit(HttpServletRequest req, HttpServletResponse resp) {
		
		String error = null;  
        String username = req.getParameter("username");  
        String password = req.getParameter("password");  
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken(username, password);
		
		try {  
            subject.login(token);  
        } catch (UnknownAccountException e) {  
            error = "用户名/密码错误";  
        } catch (IncorrectCredentialsException e) {  
            error = "用户名/密码错误";  
        } catch (AuthenticationException e) {  
            //其他错误，比如锁定，如果想单独处理请单独catch处理  
            error = "登录失败：" + e.getMessage();  
        }
//		
//		//出错了，返回登录页面
//		if(error != null) {  
//			req.setAttribute("error", error);  
//            req.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(req, resp);  
//        } else {//登录成功  
//            req.getRequestDispatcher("/WEB-INF/jsp/loginSuccess.jsp").forward(req, resp);  
//        }  
		
		return "/";
	}
	
	@RequestMapping("/test")
	public void test() {
		
		User user = new User();
		user.setUsername("hello3");
		user.setPassword("123456");
		userService.createUser(user);
	}
	
	

	
}
