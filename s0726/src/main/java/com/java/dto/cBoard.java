package com.java.dto;

import java.sql.Timestamp;

import org.apache.logging.log4j.message.TimestampMessage;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class cBoard {

	private int cno;
	private int bno;
	private String id;
	private String cpw;
	private Timestamp cdate;
	private String ccontent;
		
	
	
}
