package com.java.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.java.dto.Member;
import com.java.service.MService;

import jakarta.servlet.http.HttpSession;
@Controller
public class FController {
	@Autowired HttpSession session;
	//자동으로 객체생성후 선언을 한다.
	
	@Autowired MService mService;
	//자동으로 객체생성후 선언을 한다.
	
	@RequestMapping("/index")
	public String index() {
	
		return "index";
	}//index
	
	@GetMapping("/login")
	public String login() {
		System.out.println("Get 방식");
		return "login";
	}//login
	
	@PostMapping("/login")
	public String dologin(Member member, Model model) {
		System.out.println("Post 방식");//확인용
		System.out.println("id:"+member.getId());//확인용
		System.out.println("pw:"+member.getPw());//확인용
		Member mem = mService.selectLogin(member.getId()
				,member.getPw());//매개변수로 보냄
		if(mem != null) {
			session.setAttribute("sessionId", mem.getId());
			session.setAttribute("sessionName", mem.getName());
			model.addAttribute("loginCk",1);//맞으면1
		}else {
			model.addAttribute("loginCk",0);//틀리면0
		}
		return "login";
	}//dologin
	
	@RequestMapping("/logout")
	public String logout() {
		session.invalidate();
		//return "index";//둘중에 하나 사용하면 됨
		return "redirect:/";//둘중에 하나 사용하면 됨
	}
}
