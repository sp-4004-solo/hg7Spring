package com.java.service;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.dto.Member;
import com.java.mapper.MMapper;

import jakarta.servlet.http.HttpSession;

@Service
public class MServiceImpl implements MService {
	
	@Autowired MMapper mmapper;
	@Autowired HttpSession session;
	
	@Override
	public Member selectLogin(Member member) {
		Member mem = mmapper.selectLogin(member);
		if(mem != null) {
			session.setAttribute("sessionId", mem.getId());
			session.setAttribute("sessionName", mem.getName());
		}
		return mem;
	}
}
