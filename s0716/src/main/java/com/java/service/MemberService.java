package com.java.service;

import java.util.ArrayList;

import com.java.dto.Member;

public interface MemberService {//인터페이스 있는 모든 메서드를 완성해야한다.
	
	ArrayList<Member>memberSelectAll();
	//회원전체 정보 가져오기
	
	Member memberSelectOne(String id);
	//회원 한명의 정보 가져오기
	
	Member memberSelectLogin(String id, String pw);
	//회원 로그인값 가져오기

}//interface MemberService
