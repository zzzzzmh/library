package com.lashouinc.library.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/auth")
public class AuthController {
	@RequestMapping("/login")
	public void login(){}
	
	@RequestMapping("/logout")
	public void logout(){}
}
