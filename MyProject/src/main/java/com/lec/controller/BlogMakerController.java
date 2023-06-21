package com.lec.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.lec.domain.BlogMaker;
import com.lec.domain.Member;
import com.lec.domain.PagingInfo;
import com.lec.service.BMService;

@Controller
@SessionAttributes({"member", "pageInfo"})
public class BlogMakerController {
	@Autowired
	private BMService bmservice;
	
	@Autowired
	private Environment environment;
	
	public PagingInfo pagingInfo = new PagingInfo();
	
	@ModelAttribute("member")
	public Member setMember() {
		return new Member();
	}
	
	@GetMapping("getBlogList")
	public String getMemberList(Model model,
			@RequestParam(defaultValue = "0") int curPage,
			@RequestParam(defaultValue = "10") int rowSizePerPage,
			@RequestParam(defaultValue = "title") String searchType,
			@RequestParam(defaultValue = "") String searchWord) {
		
		Pageable pageable = PageRequest.of(curPage, rowSizePerPage, Sort.by(searchType).ascending());
		Page<BlogMaker> pagedResult = bmservice.getBlogList(pageable, searchType, searchWord);
		
		int totalRowCount = pagedResult.getNumberOfElements(); 
		int totalPageCount = pagedResult.getTotalPages();
		int pageSize = pagingInfo.getPageSize();
		int startPage = curPage / pageSize * pageSize + 1;
		int endPage = startPage + pageSize + 1;
		endPage = endPage > totalPageCount ? (totalPageCount > 0 ? totalPageCount : 1) : endPage;
		
		pagingInfo.setCurPage(curPage);
		pagingInfo.setTotalRowCount(totalRowCount);
		pagingInfo.setTotalPageCount(totalPageCount);
		pagingInfo.setStartPage(startPage);
		pagingInfo.setEndPage(endPage);
		pagingInfo.setSearchType(searchType);
		pagingInfo.setSearchWord(searchWord);
		model.addAttribute("pagingInfo", pagingInfo);
		
		model.addAttribute("pagedResult", pagedResult);
		model.addAttribute("pageable", pageable);
		model.addAttribute("cp", curPage);
		model.addAttribute("sp", startPage);
		model.addAttribute("ep", endPage);
		model.addAttribute("ps", pageSize);
		model.addAttribute("rp", rowSizePerPage);
		model.addAttribute("tp", totalPageCount);
		model.addAttribute("st", searchType);
		model.addAttribute("sw", searchWord);
		
		return "blog/getBlogList";
	}
	
	@GetMapping("/getBlog")
	public String getBlog(@ModelAttribute("member") Member member, BlogMaker blogMaker, Model model) {
		
		if(member.getId() == null) {
			return "redirect:login";
		}
		model.addAttribute("blog", bmservice.getBlog(blogMaker));
		return "blog/getBlog";
	}
	
	@GetMapping("/insertBlog")
	public String insertBlog(@ModelAttribute("member") Member member) {
		
		if(member.getId() == null) {
			return "redirect:login";
		}
		return "blog/insertBlog";
	}
	
	@PostMapping("/insertBlog")
	public String insertBlog(@ModelAttribute("member") Member member, BlogMaker blogMaker) {
		
		if(member.getId() == null) {
			return "redirect:login";
		}
		bmservice.insertBlog(blogMaker);
		return "blog/insertBlog";
	}
	
	@GetMapping("/updateBlogView")
	public String updateBlogView(@ModelAttribute("member") Member member, BlogMaker blogMaker, Model model) {
		
		if(member.getId() == null) {
			return "redirect:login";
		}
		model.addAttribute("blog", bmservice.getBlog(blogMaker));
		return "blog/updateBlogView";
	}
	
	@PostMapping("/updateBlog")
	public String updateBlog(@ModelAttribute("member") Member member, BlogMaker blogMaker) {
		
		if(member.getId() == null) {
			return "redirect:login";
		}
		bmservice.updateBlog(blogMaker);
		return "redirect:getBlogList";
	}
	
	@GetMapping("/deleteBlog")
	public String deleteBlog(@ModelAttribute("member") Member member, BlogMaker blogMaker, Model model) {

		if(member.getId() == null) {
			return "redirect:login";
		}
		bmservice.deleteBlog(blogMaker);
		return "forward:getBlogList";
	}
}
