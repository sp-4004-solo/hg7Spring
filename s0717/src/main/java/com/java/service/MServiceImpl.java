package com.java.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import com.java.dto.Member;
import com.java.mapper.MemberMapper;

@Service
public class MServiceImpl implements MService {//자식
	//인터페이스는 부모가 껍데기이므로 반드시 상속을 받아 자식이 구현을 시켜야 한다.
	@Autowired
	MemberMapper mMapper;

	@Override
	public Member selectLogin(String id, String pw) {
		
		//자식이 상속해서 물려받으면 반드시 구현 시켜야함.
		Member member = mMapper.selectLogin(id,pw);
		return member;
	}

	@Override
	public ArrayList<Member> selectMemberAll() {
		ArrayList<Member>list = mMapper.selectMemberAll();
		
		return list;
	}

	@Override
	public void insertMember(Member member) {
		mMapper.insertMember(member);
		
	}

	
}
