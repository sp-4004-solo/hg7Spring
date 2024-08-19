package com.java.service;

import com.java.dto.Member;

public interface MService {

	Member selectLogin(Member mem);

	void insertOne(Member member);

}
