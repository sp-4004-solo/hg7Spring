package com.java.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.java.dto.Member;
import com.java.service.BService;
import com.java.service.MService;

import jakarta.servlet.http.HttpSession;

@Controller
public class FController {
	//자동으로 객체를 생성할수 있게 해준다.
	@Autowired HttpSession session;
	//자동으로 객체를 생성할수 있게 해준다.
	@Autowired MService mService;
	
	@RequestMapping("/index")
	public String index() {
		return "index";
	}//index
	
	@GetMapping("/login")
	public String login() {
		//로그인 할수 있는 화면열기
		System.out.println("Get 방식입니다.");
		return "login";
	}//login
	
	@PostMapping("/login")
	public String dologin(String id, String pw, Model model) {
		System.out.println("Post 방식입니다.");
		System.out.println();
		//logi.jsp에서 submit버튼을 눌렀을때 데이터들이 전송됨.
		
		Member member = mService.selectLogin(id,pw);
		if(member != null) {
			session.setAttribute("sessionId", member.getId());
			session.setAttribute("sessionName", member.getName());
			
			model.addAttribute("loginCk",1);//맞으면1
			//model은 해당페이지를 벗어나면 소멸한다.
		}else {
			model.addAttribute("loginCk",0);//틀리면0
			//model은 해당페이지를 벗어나면 소멸한다.
		}
		return "login";
	}//dologin
	
	@RequestMapping("/logout")
	public String logout() {
		//세션 전체 삭제하기
		session.invalidate();
		return "redirect:index";
	}//logout
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}//class
