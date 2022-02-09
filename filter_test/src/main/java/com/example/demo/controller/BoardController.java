package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BoardController {
	
	@RequestMapping("/listBoard.do")
	@ResponseBody
	public String list() {
		return "게시물 목록입니다.";
	}
	

	@RequestMapping("/insertBoard.do")
	@ResponseBody
	public String insert() {
		return "게시물 등록입니다.";
	}
}
