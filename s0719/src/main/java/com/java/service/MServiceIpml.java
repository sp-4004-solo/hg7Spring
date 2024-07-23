package com.java.service;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.dto.Member;
import com.java.mapper.Mmapper;

@Service
public class MServiceIpml implements MService {
	@Autowired 
	Mmapper mmp;
	@Override
	public Member selectLogin(String id, String pw) {
		Member mem = mmp.selectLogin(id,pw);
		return mem;
	}

}
