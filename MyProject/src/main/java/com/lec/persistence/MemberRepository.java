package com.lec.persistence;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import com.lec.domain.Member;

public interface MemberRepository extends CrudRepository<Member, String>{

	Page<Member> findByIdContaining(String searchWord, Pageable pageable);
	Page<Member> findByNameContaining(String searchWord, Pageable pageable);
	
}
