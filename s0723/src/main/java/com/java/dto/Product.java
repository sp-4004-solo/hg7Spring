package com.java.dto;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
	private int pno;
	private String name;
	private int price;
	private String category;
	private Timestamp pdate;
	

}
