package com.java.controller;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URLEncoder;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FController {
	@RequestMapping("/index")
	public String index() {
		return "index";
	}//index
	
	@RequestMapping("/blist")
	public String blist() {
		return "blist";
	}//blist
	
	@RequestMapping("/bikeData")
	public String bikeData () {
		return "bikeData";
	}//bikeData
	
	@RequestMapping("/sportsData")
	public String sportsData () {
		return "sportsData";
	}//sportsData

	@RequestMapping("/subwayData")
	public String subwayData () {
		return "subwayData";
	}//subwayData
	
	@RequestMapping("/movieData")
	public String movieData () {
		return "movieData";
	}//movieData

	@RequestMapping("/publicData")
	public String publicData () {
		return "publicData";
	}//publicdata

	
	
	




}//class FController
