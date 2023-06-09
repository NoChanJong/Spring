package com.lec.config;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

import com.lec.domain.Member;

public class SecurityUser extends User {

	public SecurityUser(Member member) {
		// super(member.getId(), "{noop}" + member.getPassword(), 
		   super(member.getId(), member.getPassword(), 
				AuthorityUtils.createAuthorityList(member.getRole().toString()));
	}
}
