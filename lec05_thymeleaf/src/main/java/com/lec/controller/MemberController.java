package com.lec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lec.domain.Member;
import com.lec.service.MemberService;

@Controller
public class MemberController {

	@Autowired
	public MemberService memberService;
	
	@RequestMapping("/getMemberList")
	public String getMemberList(Member member, Model model) {
		
		List<Member> memberList = memberService.getMemberList(member);
		model.addAttribute("memberList", memberList);
		return "getMemberList";
	}
	
	@GetMapping("/getMember")
	public String getMember(Member member, Model model) {
		model.addAttribute("member", memberService.getMember(member));
		return "getMember";
	}
	
	@PostMapping("/updateMember")
	public String updateMember(Member member) {
		memberService.updateMember(member);
		return "forward:getMemberList";
	}
	
}






























