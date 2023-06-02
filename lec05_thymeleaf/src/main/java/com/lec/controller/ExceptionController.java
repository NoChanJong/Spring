package com.lec.controller;

import java.sql.SQLException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lec.exception.BoardNotFountException;

@Controller
public class ExceptionController {

	@RequestMapping("/boardError")
	public String boardError() {
		throw new BoardNotFountException("검색된 게시글이 없습니다.");
	}
	
	@RequestMapping("/illegalArgumentError")
	public String illegalArgumentError() {
		throw new IllegalArgumentException("적절하지 않는 매개변수가 전달되었습니다.");
	}
	
	@RequestMapping("/sqlError")
	public String sqlError() throws SQLException {
		throw new SQLException("SQL구문에 오류가 있습니다.");
	}
	
	@ExceptionHandler(SQLException.class) 
	public String numberFormatError(SQLException exception, Model model) {
		model.addAttribute("exception", exception);
		return "/errors/sqlError";
	}	
}


















