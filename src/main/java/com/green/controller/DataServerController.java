package com.green.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.green.dto.UserDto;


// 이페이지의 모든 함수는 전부 @ResponseBody 로 작동
// 1. 데이터전송표준 - soap protocol 방식 : xml
// 2. 데이터전송표준 - rest api 방식 : html,json
@RestController
public class DataServerController {
	@RequestMapping("/ajax3")
	public String ajax3() {
		String username ="페이커";
		return username;
	}
	
	
	// UserDto class를 추가한후 실행
	// new UserDto(userid,username,userpass)
	// jacksonbinder 라이브러리가 작동함 : 
	// js 객체 :{ "userid": "faker", "username": "페이커", "userpass": "1234"}
	
	@RequestMapping("/ajax4")
	public UserDto ajax4() {
		String username = "페이커";
		String userid   = "faker";
		String userpass   = "1234";
		UserDto user = new UserDto(userid,username,userpass);
		return user;
	}
	
	@RequestMapping("/ajax5")
	@ResponseStatus(HttpStatus.CREATED)
	@GetMapping(consumes =MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public UserDto ajax5() {
		String username = "페이커";
		String userid   = "faker";
		String userpass   = "1234";
		UserDto user = new UserDto(userid,username,userpass);
		return user;
	}
	
	@RequestMapping("/ajax6")
	@ResponseStatus(HttpStatus.CREATED)
	@GetMapping(consumes =MediaType.APPLICATION_XML_VALUE,produces=MediaType.APPLICATION_XML_VALUE)
	public UserDto ajax6() {
		String username = "페이커";
		String userid   = "faker";
		String userpass   = "1234";
		UserDto user = new UserDto(userid,username,userpass);
		return user;
	}
	
	
}
