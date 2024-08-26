package com.java.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.java.dto.Member;
import com.java.service.MService;

import jakarta.servlet.http.HttpSession;

@Controller
public class MController {
	
	@Autowired MService mService;
	@Autowired HttpSession session;
	
	@GetMapping("/member/login")
	public String login() {
		return "member/login";
	}
	
	@PostMapping("/member/login")
	public String dologin(Member member) {
		System.out.println(member.getId());
		System.out.println(member.getPw());
		Member mem = mService.selectLogin(member);
		if(mem != null) {
			session.setAttribute("sessionId",mem.getId());
			session.setAttribute("sessionName",mem.getName());
		}
		return "redirect:/";
	}

	@RequestMapping("/member/idsearch")
	public String idsearch() {
		return "member/idsearch";
	}
	
	@RequestMapping("/member/step01")
	public String step01() {
		return "member/step01";
	}
	
	@RequestMapping("/member/step02")
	public String step02() {
		return "member/step02";
	}
	
	@RequestMapping("/member/step03")
	public String step03() {
		return "member/step03";
	}
	
	@RequestMapping("/member/step04")
	public String step04() {
		return "member/step04";
	}
	
	@RequestMapping("/member/zip")
	public String zip() {
		return "member/zip";
	}
	

}
