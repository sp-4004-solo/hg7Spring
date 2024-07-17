package com.java.dto;



import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Board {
	private int bno;
	private int bhit;
	
	private String id;
	private String btitle;
	private String bcontent;
	private String bfile;
	
	private Timestamp bdate;
	
	private int bgroup;
	private int bstep;
	private int bindent;
	
}
