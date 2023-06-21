package com.lec.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.lec.domain.BlogMaker;
import com.lec.persistence.BlogMakerRepository;
import com.lec.service.BMService;

@Service
public class BlogMakerServiceImpl implements BMService {

	@Autowired
	private BlogMakerRepository blogMakerRepository;
	
	@Override
	public long getTotalRowCount(BlogMaker blogMaker) {
		return blogMakerRepository.count();
	}

	@Override
	public BlogMaker getBlog(BlogMaker blogMaker) {
		Optional<BlogMaker> findBlog = blogMakerRepository.findById(blogMaker.getSeq());
		if(findBlog.isPresent()) return findBlog.get();
		else return null;
	}

	@Override
	public Page<BlogMaker> getBlogList(Pageable pageable, String searchType, String searchWord) {
		if(searchType.equalsIgnoreCase("title")) {
			return blogMakerRepository.findByTitleContaining(searchWord, pageable);
		} else if(searchType.equalsIgnoreCase("writer")) {
			return blogMakerRepository.findByWriterContaining(searchWord, pageable);
		} else {
			return blogMakerRepository.findByContentContaining(searchWord, pageable);
		}
	}

	@Override
	public void insertBlog(BlogMaker blogMaker) {
		blogMakerRepository.save(blogMaker);
	}

	@Override
	public void updateBlog(BlogMaker blogMaker) {
		BlogMaker findBlog = blogMakerRepository.findById(blogMaker.getSeq()).get();
		findBlog.setTitle(blogMaker.getTitle());
		findBlog.setWriter(blogMaker.getWriter());
		findBlog.setContent(blogMaker.getContent());
		blogMakerRepository.save(blogMaker);
	}

	@Override
	public void deleteBlog(BlogMaker blogMaker) {
		blogMakerRepository.deleteById(blogMaker.getSeq());
	}
}
