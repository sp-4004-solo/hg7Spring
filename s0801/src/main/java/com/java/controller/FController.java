package com.java.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.java.dto.Member;

@Controller
public class FController {
	
	@RequestMapping("/index")
	public String index() {
		return "index";
	}//index
	
	
	
	
	
}//class
