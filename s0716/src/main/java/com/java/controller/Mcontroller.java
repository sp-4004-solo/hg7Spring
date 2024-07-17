package com.java.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.java.dto.Member;
import com.java.service.MemberService;

import jakarta.servlet.http.HttpSession;

@Controller//꼭써줘야 컨트롤러 역할을 할수 있다.
public class Mcontroller {
	@Autowired
	MemberService memberService;
	
	@Autowired//선언한걸 자동으로 생성하게 해준다.
	HttpSession session;//세션선언
	
	@RequestMapping("/member/login")
	public String login() {
		return "member/login";
		
	}//login
	
	@RequestMapping("/member/logout")
	public String logout(Model model) {
		//세션삭제
		session.invalidate();
		model.addAttribute("logout",1);
		return "member/logout";
		
	}//logout
	
	@RequestMapping("/member/doLogin")
	public String doLogin(String id, String pw, Model model) {
		System.out.println("id:"+id);
		System.out.println("pw:"+pw);
		
		Member m = memberService.memberSelectLogin(id,pw);
		
		
		if(m != null){
		//세션에 추가
		session.setAttribute("sessionId",m.getId());
		session.setAttribute("sessionName",m.getName());
		 
		model.addAttribute("loginCheck",1);//doLogin넘어감
		}else {
			model.addAttribute("loginCheck",0);//doLogin넘어감
		}
		
//		if(id.equals("aaa")&& pw.equals("1111")){
//			//세션에 추가
//			session.setAttribute("sessionId",id);
//			session.setAttribute("sessionName", "홍길동");
//			model.addAttribute("loginCheck",1);
//		}else {
//			model.addAttribute("loginCheck",0);
//		}
		return "member/doLogin";
		
	}//doLogin
	
	@RequestMapping("/member/join")
	public String join() {
		return "member/join";
		
	}//login
	
	@RequestMapping("/member/memView")
	public String memView(String id, Model model) {
	System.out.println("id="+id);//콘솔에 아어디 확인용
	Member member = memberService.memberSelectOne(id);
		System.out.println(member.getName());//확인용
		model.addAttribute("member", member);//모델이란 객체에 실려 보내겠다.
		return "member/memView";
		
	}//login
	
	@RequestMapping("/member/memList")
	public String memList(Model model) {
		
		ArrayList<Member>list = memberService.memberSelectAll();
		
		//확인용
		System.out.println(list.get(0).getName());
		model.addAttribute("list",list);
		
		return "member/memList";
		
	}//memList
	
	
	@RequestMapping("/member/doJoin")
//	public String doJoin(String id, String pw, String name,
//			String phone, String gender, String hobbys
//			, Model model) {
		//넘어온 정보 콘솔창에 출력하기
		public String doJoin(Member member,String[] hobby,
								Model model) {
			//넘어온 정보 콘솔창에 출력하기
		System.out.println(member.getId());
		System.out.println(member.getPw());
		System.out.println(member.getName());
		System.out.println(member.getGender());
		System.out.println(member.getPhone());
		String hobbys="";
		for(int i=0; i<hobbys.length(); i++) {
			if(i==0)hobbys += hobby[i];
			else hobbys += ","+hobby[i];
		}
		member.setHobbys(hobbys);
		System.out.println(member.getHobbys());
		model.addAttribute("member",member);
		
		return "member/doJoin";
		
	}//login
	
	
	
	
	
	
	
	
	
	
	
	
}//Mcontroller
