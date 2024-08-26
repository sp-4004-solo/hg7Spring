package com.java.dto;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
//프로젝트 제작시 변수 소문자로 변경할것
public class F_BOARD {
	private int F_BNO;
	private String USER_AUTH_ID;
	private String F_BTITLE;
	private String F_BCONTENT;
	private String F_BIMAGE;
	private Timestamp F_BDATE;
	private int F_HIT;
	private int USER_ID;
	
	
}

//CREATE TABLE F_BOARD (
//	     
//		 USER_SEQ	NUMBER	NOT NULL,
//		 USER_AUTH_ID	VARCHAR2(30)	NULL,
//		 F_BTITLE	VARCHAR2(30)	NULL,
//		 F_BCONTENT	VARCHAR2(3000)	NULL,
//		 F_BIMAGE	VARCHAR2(300)	NULL,
//		 F_BDATE	DATE	NULL,
//		 F_HIT	NUMBER	NULL,
//		 USER_ID	VARCHAR2(30)	NULL
//	);