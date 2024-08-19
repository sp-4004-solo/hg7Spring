package com.java.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.java.dto.Member;



@Mapper
public interface MMapper {

	Member login(String id, String pw);

	String idCheck(String id);

	void insertMember(Member member);

}
