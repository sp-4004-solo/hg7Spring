package com.java.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.java.dto.Member;
@Mapper
public interface MMapper {

	ArrayList<Member> memberSelectAll();

	Member login(Member member);

	void insertMember(Member mem);

	Member SelectOne(Member mem);

	Member delMem(String id);

	

	
}
