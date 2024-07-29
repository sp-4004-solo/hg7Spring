package com.java.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties.Producer;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.java.dto.Product;
import com.java.service.PService;

import jakarta.servlet.http.HttpSession;

@Controller
public class FController {
	@Autowired PService pService;
	
//	@RequestMapping("/main")
//	public String main() {
//		
//		return "main";
//	}
//	메인지움
	
	@RequestMapping("/")
	public String index() {
		
		return "main";
	}
	
//	@RequestMapping("/ajax01")
//	public String ajax01() {
//		
//		return "ajax01";
//	}
//	
//	@RequestMapping("/ajax02")
//	public String ajax02() {
//		
//		return "ajax02";
//	}
	
	@RequestMapping("/product")
	public String Product() {
		
		return "product";
	}
	
	@PostMapping("/productList")
	@ResponseBody
	public ArrayList<Product> productList() {
		ArrayList<Product> plist = pService.selectAll();
		return plist;
	}
	
	
//	@PostMapping("/pList")
//	@ResponseBody
//	public ArrayList<Product> pList() {
//		ArrayList<Product>list =pService.selectAll();
//		return list;
//	}
	
	@PostMapping("/insertProductInfo")
	@ResponseBody
	public Product insertProductInfo(Product pdto) {
		System.out.println(pdto.getName());
		System.out.println(pdto.getCategory());
		System.out.println(pdto.getPrice());
		
		//Product product = new Product();
		//product.setName(pdto.getName());
		//product.setPrice(pdto.getPrice());
		//product.setCategory(pdto.getCategory());
		Product product = pService.insertProductInfo(pdto);
		return product;
	}
	
	
//	@PostMapping("/insertProduct")
//	@ResponseBody
//	public Product insertProduct(Product product) {
//		//System.out.println(pdto.getName());
//		//System.out.println(pdto.getCategory());
//		//System.out.println(pdto.getPrice());
//	
//		Product pdto = pService.insertProduct(product);
//		System.out.println("pcontroller "+product.getPno());
//		System.out.println("pcontroller "+product.getName());
//		
//		
//		//ArrayList<product>list =pService.insertOne(pdto);
//		return product ;
//	}


}

