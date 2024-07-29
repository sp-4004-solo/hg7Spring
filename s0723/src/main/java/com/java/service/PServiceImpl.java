package com.java.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.dto.Product;
import com.java.mapper.BMapper;
import com.java.mapper.PMapper;
@Service
public class PServiceImpl implements PService{
	@Autowired PMapper pMapper;
	@Override
	public ArrayList<Product> selectAll() {
		ArrayList<Product>list =pMapper.selectAll();
		return list;
	}//selectAll
	
	public Product insertProductInfo(Product pdto) {
		pMapper.insertOne(pdto);
		Product product = pMapper.selectOne(pdto);
		return product;
	}//selectAll
	
	
	

}
