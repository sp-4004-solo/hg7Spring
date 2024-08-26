package com.java.dto;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
//프로젝트 제작시 변수 소문자로 변경할것
public class F_BOARD_COMENT {
	private int F_BNO;
	private int USER_SEQ;
	private String C_CONTENT;
	private int C_PW;
	
}
//CREATE TABLE F_BOARD_COMENT (
//		F_BNO	NUMBER	NULL,
//		USER_SEQ	NUMBER	NOT NULL,
//		C_CONTENT	VARCHAR2(300)	NULL,
//		C_PW	NUMBER	NULL
//	);