package com.java.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.dto.Member;
import com.java.mapper.MMapper;

import jakarta.servlet.http.HttpSession;
@Service
public class MServiceImpl implements MService {
	@Autowired MMapper mMapper;
	@Autowired HttpSession session;
	
	@Override
	public int login(Member member) {
		int result=0;
		Member mdto = mMapper.login(member);
		//로그인에 성공하면
		if(mdto != null) {
			//세션에 값넣기
			session.setAttribute("sessionId", mdto.getId());
			session.setAttribute("sessionName", mdto.getName());
			//result 값 넣기
			result=1;//성공값 1, 실패값 0
		}
		return result;
	}
	
}
