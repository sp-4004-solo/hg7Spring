package com.java.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.java.dto.Member;

@Mapper
public interface MemberMapper {
	
	//회원전체정보 가져오기
	ArrayList<Member> memberSelectAll();
	
	//회원 한명의 정보가져오기
	Member memberSelectOne(String id);
	
	//회원 로그인값 가져오기
	Member memberSelectLogin(String id, String pw);
	
	
	
	
}//interface MemberMapper
