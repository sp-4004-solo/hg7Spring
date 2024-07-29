package com.java.cintroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.java.dto.Member;
import com.java.service.MService;

@Controller
public class MController {
	@Autowired MService mService;
	@GetMapping("/login")//파일의 주소
	public String login() {
		System.out.println();
		return "/member/login";//파일의 위치
	}//login
	
	@PostMapping("/login")//파일의 주소(파일주소 바꾸는것)
	public String dologin(Member member, Model model) {
		System.out.println("id:"+member.getId());
		System.out.println("pw:"+member.getPw());
		//1 은성공 , 0은 실패
		int result = mService.login(member);
		model.addAttribute("result",result);
		return "redirect:/";//파일의 위치
	}//login
	
//	@RequestMapping("/ajaxLogin")//파일의 주소(데이터 송신, 수신)
//	@ResponseBody
//	public String ajaxlogin(Member member) {
//		System.out.println("id:"+member.getId());
//		System.out.println("pw:"+member.getPw());
//		//1 은성공 , 0은 실패
//		int result = mService.login(member);
//		return "+result/";//파일의 위치
//	}//login

	








}


