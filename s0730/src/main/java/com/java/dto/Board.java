package com.java.dto;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Board {
	private int bno;//게시번호
	private int bhit;//조회수
	
	private String id;//아이디
	private String btitle;//제목
	private String bcontent;//내용
	private String bfile;//파일
	
	private Timestamp bdate;
	
	private int bgroup;//답글
	private int bstep;
	private int bindent;
	private String[] bfiles;
	
}
