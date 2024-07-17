package com.java.service;

import java.util.ArrayList;

import com.java.dto.Member;

public interface MService {//부모

	public Member selectLogin(String id, String pw);

	public ArrayList<Member> selectMemberAll();

	public void insertMember(Member member);

	
		
	//selectLogin

}
