package com.java.controller;

import java.io.File;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import com.java.dto.Board;

@Controller
public class FController {
	@RequestMapping("/")
	public String index() {
		return "index";
	}//index
	
	@RequestMapping("/map1")
	public String map1() {
		return "map1";
	}//map1
	
	@RequestMapping("/map2")
	public String map2() {
		return "map2";
	}//map2
	
	@RequestMapping("/form1")
	public String form1() {
		return "form1";
	}//form1
	
	@RequestMapping("/form2")
	public String form2() {
		return "form2";
	}//form2
	
	@RequestMapping("/doForm1")
	public String doForm1(Board board,
			@RequestPart MultipartFile file, Model model) throws Exception {
		   // 파일명
		String fileName="";
		if(!file.isEmpty()) {   // 파일을 upload에 저장
			String ori_fileName = file.getOriginalFilename();
			UUID uuid = UUID.randomUUID();
			fileName = uuid+"_"+ori_fileName;
			String uploadUrl = "c:/upload/";
			File f = new File(uploadUrl+fileName);
			file.transferTo(f);
		}
		model.addAttribute("fileName", fileName);
		model.addAttribute("btitle", board.getBtitle());
		return "fileCheck";
	}//doForm1

	@RequestMapping("/doform2")
	public String doform2(Board board,
			List<MultipartFile>files, Model model)throws Exception {
		String fName="";
		int i=0;
		String fileName="";
		for(MultipartFile file:files) {
			System.out.println(file);
			String ori_fileName = file.getOriginalFilename();
			UUID uuid = UUID.randomUUID();
			fileName = uuid+"_"+ori_fileName;
			String uploadUrl = "c:/upload/";
			File f = new File(uploadUrl+fileName);
			file.transferTo(f);
			if(i==0) fName += fileName;
			else fName += "," + fileName;
			i++;
		}
		
		
		String[]splitNames =fName.split(",");
		board.setBfile(fName);
		board.setBfiles(splitNames);
		model.addAttribute("board",board);
		
		
		return "fileCheck2";
	}//doform2
	







	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}//class
