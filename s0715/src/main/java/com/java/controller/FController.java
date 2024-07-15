package com.java.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.java.dto.BoardDto;
import com.java.service.BService;
import com.java.service.BServiceImpl;
import com.java.service.BServiceImpl2;

@Controller
public class FController {
	
	@Autowired
	BoardDto bdto;
	BServiceImpl bservice1 = new BServiceImpl();
	BServiceImpl2 bservice2 = new BServiceImpl2();
	
	@Autowired // @Service가 붙은 위치에 적용이 됨.
	BService bService;
	
	@RequestMapping("/index")
	public String index() {
		bdto.setBno(1);
		System.out.println(bdto.getBno());
		// System.out.println(bservice1.add());
		// System.out.println(bservice2.add());
		System.out.println(bService.add());
		return "index";
	}
	
	
	
	
	
}




















