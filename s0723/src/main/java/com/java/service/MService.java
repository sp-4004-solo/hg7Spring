package com.java.service;

import java.util.ArrayList;

import com.java.dto.Member;

public interface MService {

	ArrayList<Member> memberSelectAll();

	int login(Member member);

	Member insertMember(Member mem);

	Member deleteMember(String id);

	void delMem(String id);

	

	
	
}
