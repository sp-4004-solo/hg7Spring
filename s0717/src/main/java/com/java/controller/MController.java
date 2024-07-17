package com.java.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.annotation.JsonCreator.Mode;
import com.java.dto.Member;
import com.java.service.MService;

import jakarta.servlet.http.HttpSession;
import jakarta.websocket.Session;


@Controller
@RequestMapping("/member")
public class MController {
	@Autowired
	HttpSession session;// session 변수선언
	
	@RequestMapping("/mlist")
	public String blist(Model model) {//모델로 선언한다.
		ArrayList<Member>list = mService.selectMemberAll();
		System.out.println(list.get(0).getId());//확인용
		model.addAttribute("list", list);//모델로 넘긴다
		return "member/mlist";
	}//mlist
	
	@GetMapping("/join")
	public String join() {
		return "member/join";
	}//join
	
	@PostMapping("/join")
	public String doJoin(Member member, String[]hobby, Model model) {
		String hobbys="";
		for(int i=0; i<hobby.length; i++) {
			if(i == 0)hobbys += hobby[i];
			else hobbys += ","+hobby[i]; 
		}
		member.setHobbys(hobbys);
		mService.insertMember(member);
		
		return "redirect:/index";
	}//doJoin
	
	
	
	//login페이지를 여는 부분 
	@RequestMapping("/login")
	public String login() {
		return "/member/login";
	}//login
	
	//login페이지에서 submit 버튼을 눌렀을때 연결되는 부분
	
	@Autowired//자동으로 객체를 생성해서 사용하게 해준다.
	MService mService;
	@RequestMapping("/doLogin")
	public String dologin(Member member, Model model ) {
		//확인용
		System.out.println("doLogin id:"+member.getId());
		System.out.println("doLogin pw:"+member.getPw());
		
		Member m = mService.selectLogin(member.getId(), member.getPw());
		
		//System.out.println("doLogin DB연결확인 ID"+m.getId());
		if(m != null) {
			session.setAttribute("sessionId", m.getId());
			session.setAttribute("sessionName", m.getName());
			model.addAttribute("loginCk",1);
			//model이라는 변수를 만들어서 아이디가 존재하면 1
		}else {
			model.addAttribute("loginCk",0);
			//model이라는 변수를 만들어서 아이디가 존재하면 0
		}
		return "member/doLogin";
	}//dologin
	
	@RequestMapping("/logout")
	public String logout() {
		session.invalidate();
		
		//model.addAttribute("logout" loout);
		//return "member/logout";//페이지 이동시킴
		return "/index";//인덱스(메인페이지로) 꼭! 리턴한다.
	}//logout
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}//class
