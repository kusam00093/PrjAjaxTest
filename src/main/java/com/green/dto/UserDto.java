package com.green.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


// @Data : @NoArgsConstructor + @Setter + @ Getter + @ToString + hashCode() + equals()
// @AllArgsConstructor 추가되면 기본생성자 모든인자 생성자로 변경된다 그러므로 기본생성자가 없어짐
// @NoArgsConstructor 를 추가 해야함
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
	private String userid;
	private String username;
	private String userpass;
}
