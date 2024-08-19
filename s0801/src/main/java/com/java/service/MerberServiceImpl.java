package com.java.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.dto.Member;
import com.java.mapper.MemberMapper;

import jakarta.servlet.http.HttpSession;

@Service
public class MerberServiceImpl implements MemberService{
	
	@Autowired MemberMapper memberMapper;
	@Autowired HttpSession session;
	@Override
	public Member login(Member member) {

		//Member mem= mService.login(member);
		Member mem = memberMapper.login(member);
		//로그인에 성공하면
		if(mem != null) {
			//세션에 넣기
			session.setAttribute("sessionId", mem.getId());
			session.setAttribute("sessioName", mem.getName());
		}
		return mem;
	}
	@Override
	public Member selectLogin(Member member) {
		Member mem = memberMapper.selectLogin(member);
		return mem;
	}

}
