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
@RequestMapping
public class MController {
	
	@Autowired HttpSession session;
	@Autowired MService mService;
	
	@RequestMapping("member")
	public String login() {
		return "/member/login";
	}
	
	@GetMapping("logout")
	public String logout() {
		session.invalidate();//세션삭제
		return "redirect:/index";
	}
	
	
	@GetMapping("login")
	public String join() {
		return "/member/join";
	}
	
	
	@PostMapping("join")
	public String dojoin(Member member, String[]hobby) {
		System.out.println(member.getId());
		System.out.println(member.getPw());
		System.out.println(member.getName());
		System.out.println(member.getPhone());
		
		String hb = "";
		for(int i = 0 ; i < hobby.length ; i ++ ) {
			if(i==0) hb += hobby[i];
			else hb += ", "+ hobby[i];
		}
		member.setHobbys(hb);
		System.out.println(member.getHobbys());
		mService.insertOne(member);
		return "/member/join";
	}

	
	@PostMapping("login")
	public String dojoin(Member mem) {
		//System.out.println(mem.getId());//확인용
		//System.out.println(mem.getPw());//확인용
		
		Member member = mService.selectLogin(mem);
		if(member != null) {
			session.setAttribute("sessionId", member.getId());
			session.setAttribute("sessionName", member.getName());
		}
		return "redirect/index";
	}
	
	@RequestMapping("updateMem")
	public String updateMem() {
		return "/member/updateMem";
	}
	
}

