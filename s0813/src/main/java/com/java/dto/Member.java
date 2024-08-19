package com.java.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity//JPA가 관리한 클래스 - 필드의 어노테이션을 보고 DB테이블과 맵핑해서 관리함.
//@Tavble(name="MEMBERDTO")	
public class Member {
	@Id // entity의 primary key로 설정 - not null, uniqye
	private String id;
	@Column(nullable = false, length = 30)
	private String pw;
	@Column(nullable = false, length = 30)
	private String name;
	private String phone;
	private String gender;
	private String hobbys;
	
}
