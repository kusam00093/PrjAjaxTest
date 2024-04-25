package com.green.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


// @Controller + RequestMapping("/mvc") : .jsp, mustache 를 찾고
// @Controller + RequestMapping("/mvc") + @ResponseBody : .jsp, mustache 를 찾지않고 data를 출력한다 : 새로운 페이지에
// @Controller + @ResponseBody : @RestController -> 모든 함수에 @ResponseBody가 적용된다
// @Controller : view 파일을 리턴하고
// @RestController : data를 리턴한다
@Controller
public class MvcController {
	@RequestMapping("/mvc")
	public String mvc(Model model) {
		model.addAttribute("username", "페이커");
		return "/mvc";      //  src/main/resources/templates/mvc.mustache
	}
	
	@RequestMapping("/ajax1")
	public String ajax1() {
		String username="페이커";
		return username;   // 404 No static resource 페이커
	}

	@RequestMapping("/ajax2")
	@ResponseBody
	public String ajax2(Model model) {
		String username="<h2>페이커</h2>";
		return username;    // http://localhost:8080/ajax2 페이지에 페이커출력
	}
}
