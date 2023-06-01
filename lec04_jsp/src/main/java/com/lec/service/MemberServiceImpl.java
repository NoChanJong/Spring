package com.lec.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lec.domain.Member;
import com.lec.persistence.MemberRepository;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberRepository memberRepository;
	
	@Override
	public List<Member> getMemberList(Member member) {
		return (List<Member>) memberRepository.findAll();
	}

	@Override
	public void insertMember(Member member) {
		memberRepository.save(member);
	}
	
	@Override
	public Member getMember(Member member) {
		return memberRepository.findById(member.getMember_id()).get();
	}

	@Override
	public void updateMember(Member member) {
		Member findmember = memberRepository.findById(member.getMember_id()).get();
		findmember.setMember_id(member.getMember_id());
		findmember.setName(member.getName());
		findmember.setPassword(member.getPassword());
		findmember.setRole(member.getRole());
		memberRepository.save(findmember);
	}

	@Override
	public void deleteMember(Member member) {
		memberRepository.deleteById(member.getMember_id());
	}
	
}
