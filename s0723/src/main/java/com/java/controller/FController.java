package com.java.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;

@Controller
public class FController {
	@RequestMapping("/")
	public String index() {
		
		return "main";
	}
	
//	@RequestMapping("/main")
//	public String main() {
//		
//		return "main";
//	}
//	메인지움
}
