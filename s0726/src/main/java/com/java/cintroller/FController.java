package com.java.cintroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;
	
@Controller
public class FController {
	@Autowired HttpSession session;
	@RequestMapping("/")
	public String main() {
		return "main";
	}//index
	
	@RequestMapping("/logout")
	public String logout() {
		session.invalidate();
	return "redirect:/";//파일의 위치
	}//login
	
}
