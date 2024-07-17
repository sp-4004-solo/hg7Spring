package com.java.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.java.dto.Member;

@Mapper
public interface MemberMapper {

	Member selectLogin(String id, String pw);
	//부모가 인터페이스 이기때문에 자식이 상속을 받아 반드시 구현 시켜야함.

	ArrayList<Member> selectMemberAll();

	void insertMember(Member member);

}
