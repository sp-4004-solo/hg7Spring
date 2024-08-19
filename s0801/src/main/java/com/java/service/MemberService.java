package com.java.service;

import com.java.dto.Member;

public interface MemberService {

	Member login(Member member);

	Member selectLogin(Member member);


}
