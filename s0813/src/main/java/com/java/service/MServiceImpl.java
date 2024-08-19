package com.java.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.dto.Member;
import com.java.repository.MemberRepository;

@Service
public class MServiceImpl implements MService{
	
	@Autowired MemberRepository memberRepository;
	
	@Override
	public Member selectLogin(Member member) {
		Member mem = memberRepository.findById(member.getId()).orElse(null);
		return mem;
	}

	@Override
	public void insertOne(Member member) {
		memberRepository.save(member);
		
	}

}
