package com.java.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.java.dto.Member;

@Mapper
public interface Mmapper {

	Member selectLogin(String id, String pw);

}
