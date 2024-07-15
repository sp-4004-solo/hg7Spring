package com.java.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.java.dto.MemberDto;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/member")
public class MemberController {
@Autowired// 자동으로 객체생성
HttpSession session;	
	
	@RequestMapping("/member1")
	public String member1() {
		return "member/member1";
	}
	@RequestMapping("/login")
	public String login() {
		return "member/login";
	}
	
	//회원가입창을 보여줌
	//회원가입후 전송버튼을 눌렀을때 이동
	@RequestMapping("/memberForm")
	public String MemberForm() {
		return "member/memberForm";
	}
	
	@RequestMapping("/doMemberForm")
	public String doMemberForm(MemberDto mdto, 
			HttpServletRequest request ,Model model) {
	
//		String id = request.getParameter("id");
//		String pw = request.getParameter("pw");
//		String name = request.getParameter("name");
//		String gender = request.getParameter("gender");
//		
//		System.out.println(id);
//		System.out.println(pw);
//		System.out.println(name);
//		System.out.println(gender);
		
		//model에 정보넣기
		//form태그속 name명과 dto의 변수명이 같은경우
//		MemberDto member = new MemberDto();
		model.addAttribute("member",mdto);
//		model.addAttribute("member",member);
//		model.addAllAttributes("id",id);
//		model.addAllAttributes("pw",pw);
//		model.addAllAttributes("name",name);
//		model.addAllAttributes("gender",gender);
		
		
		return "member/doMemberForm";
	}//doMemberForm

	@RequestMapping("/doLogin")
//	public String doLogin(@RequestParam(defaultValue="admin")
//							String id, String pw, Model model) {	
	public String doLogin(String id, String pw, Model model) {	
		model.addAttribute("id",id);
		model.addAttribute("pw",pw);
		//만약에 db에 aaa 1111 있다면.
		if(id.equals("aaa") && pw.equals("1111")){
			session.setAttribute("sessionId",id);
		}
		return "member/doLogin";
	}//doLogin
	
	
	@RequestMapping("/mForm")
	public String MForm() {
		return "member/mForm";
	}//MForm

	
	@RequestMapping("/doMForm")
	public String doMForm(MemberDto mdto,String[] hobbys, Model model ) {
		
		System.out.println(1000000);
		//확인해보기
		System.out.println("이름"+mdto.getName());
		String hobby="";
		for(int i=0; i<hobbys.length; i++) {
			if(i==0)hobby += hobbys[i];
			else hobby += ","+ hobbys[i];
			
		}//for문
		System.out.println(hobby);
		mdto.setHobby(hobby);
		model.addAttribute("member", mdto);
		return "member/doMForm";
	}//doMForm
	
	@RequestMapping("/updateMForm")
	public String updateMForm(MemberDto mdto, Model model) {
	
		model.addAttribute("member",mdto);
		
		return "member/updateMForm";

	}//updateMForm
	

}//class MemberController





