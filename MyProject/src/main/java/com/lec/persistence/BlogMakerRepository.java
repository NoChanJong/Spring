package com.lec.persistence;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import com.lec.domain.BlogMaker;

public interface BlogMakerRepository extends CrudRepository<BlogMaker, Long>{

	Page<BlogMaker> findByTitleContaining(String title, Pageable pageable);
	Page<BlogMaker> findByWriterContaining(String writer, Pageable pageable);
	Page<BlogMaker> findByContentContaining(String content, Pageable pageable);
	
}
