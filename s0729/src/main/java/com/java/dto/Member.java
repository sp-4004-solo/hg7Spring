package com.java.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data//getset, setter
@AllArgsConstructor//모든생성자
@NoArgsConstructor//기본생생자
public class Member {
	
	private String id;
	private String pw;
	private String name;
	private String phone;
	private String gender;
	private String hobbys;
	
}
