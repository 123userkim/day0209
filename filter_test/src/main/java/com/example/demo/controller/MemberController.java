package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MemberController {
	
	@RequestMapping("/member/menu1")
	@ResponseBody
	public String menu1() {
		return "서비스1입니다.";
	}
	
	@RequestMapping("/member/menu2")
	@ResponseBody
	public String menu2() {
		return "서비스2입니다.";
	}
}
