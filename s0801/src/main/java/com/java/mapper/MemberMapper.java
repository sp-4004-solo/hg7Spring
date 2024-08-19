package com.java.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.java.dto.Member;

@Mapper
public interface MemberMapper {

	Member login(Member member);

	Member selectLogin(Member member);

}
