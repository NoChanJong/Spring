package com.lec.service;

import java.util.List;

import com.lec.domain.Member;

public interface MemberService {

	List<Member> getMemberList(Member member);
	Member getMember(Member member);
	void updateMember(Member member);
	
}