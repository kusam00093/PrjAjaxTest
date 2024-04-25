package com.green.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BusInfoDto {
	private String numOfRows;
	private String pageNo;
	private String bstopnm;
	private String arsno;
}
