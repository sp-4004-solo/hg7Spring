package com.java.dto;

import java.security.Timestamp;

import lombok.AllArgsConstructor;//매개변수 생성자
import lombok.Data;//getter,setter 생성
//import lombok.Getter;
import lombok.NoArgsConstructor;//기본생성자
//import lombok.Setter;
//@Setter
@Data//롬복에서 제공하는 setter,getter 생성
//@Getter
@AllArgsConstructor//롬복에서 제공하는 매개생성자
@NoArgsConstructor//롬복에서 제공하는기본생성자
public class Board {
	
	private int BNO;
	private String ID;
	private String BTITLE;
	private String BCONTENT;
	private Timestamp BDATE;
	private int BHIT;
	private int BGROUP;
	private int BSTEP;
	private int BINDENT;
	private String BFILE;
	
}//class Board
