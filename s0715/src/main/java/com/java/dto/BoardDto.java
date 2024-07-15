package com.java.dto;

import org.springframework.stereotype.Component;

import jakarta.annotation.Generated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//data = getter $ setter 동시에 가져옴
@Getter
@Setter
@ToString
@AllArgsConstructor
@Data
@NoArgsConstructor
@Component
public class BoardDto {

	
	private int bno;
	private String btitle;
	
}//class BoardDto
