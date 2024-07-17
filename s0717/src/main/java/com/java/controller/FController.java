package com.java.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FController {
	
	@RequestMapping("/index")//주소창에 입력될 주소
	public String index() {
		//views아래에 파일 위치
		return "index";
	}//index
}//class
