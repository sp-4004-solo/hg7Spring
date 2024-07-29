package com.java.service;

import java.util.ArrayList;

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
	public ArrayList<Member> memberSelectAll() {
		
		ArrayList<Member>list = mMapper.memberSelectAll();
				
		return list;
	}
	@Override
	public int login(Member member) {
		int result=0;
		Member mdto =mMapper.login(member);
		//로그인에 성공하면
		if(mdto != null) {
			//세션에 값넣기
			session.setAttribute("sessionId", mdto.getId());
			session.setAttribute("sessionName", mdto.getName());
			//result값 넣기
			result=1;
			
		}
		return result;
	}
	@Override
	public Member insertMember(Member mem) {
		//정보넣기
		mMapper.insertMember(mem);
		//정보가져오기
		Member member =mMapper.SelectOne(mem);
		return member;
	}
	
	@Override
	public void delMem(String id) {
		Member member =mMapper.delMem(id);
		
	}
	@Override
	public Member deleteMember(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
