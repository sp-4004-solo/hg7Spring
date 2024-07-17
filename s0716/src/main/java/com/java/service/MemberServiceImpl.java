package com.java.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.dto.Member;
import com.java.mapper.MemberMapper;
@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	MemberMapper memberMapper;
	@Override
	public ArrayList<Member> memberSelectAll() {//회원전체정보 가져오기
		
		ArrayList<Member>list = memberMapper.memberSelectAll();
		return list;
	}//memberSelectAll
	
	@Override
	public Member memberSelectOne(String id) {//회원한명정보 가져오기
		Member member = memberMapper.memberSelectOne(id);
		
		return member;
	}//memberSelectOne

	@Override
	public Member memberSelectLogin(String id, String pw) {
		
		//회원 로그인 하기
		Member m = memberMapper.memberSelectLogin(id,pw);
		return m;
		
		
		
	}//memberSelectLogin
	
}//MemberService
