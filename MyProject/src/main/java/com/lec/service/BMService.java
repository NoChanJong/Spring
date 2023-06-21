package com.lec.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.lec.domain.BlogMaker;

public interface BMService {

	long getTotalRowCount(BlogMaker blogMaker);
	BlogMaker getBlog(BlogMaker blogMaker);
	Page<BlogMaker> getBlogList(Pageable pageable, String searchType, String searchWord);
	void insertBlog(BlogMaker blogMaker);
	void updateBlog(BlogMaker blogMaker);
	void deleteBlog(BlogMaker blogMaker);
}
