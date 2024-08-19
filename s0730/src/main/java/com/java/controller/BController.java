package com.java.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import com.java.dto.Board;
import com.java.service.BService;

import lombok.AllArgsConstructor;
@Controller
	public class BController {
	@Autowired BService bService;

	@RequestMapping("/board/blist")
	public String bilst(Model model) {
		ArrayList<Board>list = bService.selectBoardAll();
		System.out.println(list.get(0).getBtitle());//확인용
		 model.addAttribute("list",list);//모델에 추가
		return "board/bilst";
	}//bilst
	

	
	@RequestMapping("/board/bview")
	public String bview(int bno, Model model) {
		Board board = bService.selectOne(bno);
		
		//System.out.println(board.getBfile());
		//"", 여기서 스플릿해서 .bfile set함
		if(board.getBfile()!= null || board.getBfile().equals("")) {
			String[]splitFiles = board.getBfile().split(",");
			board.setBfiles(splitFiles);
		}
		model.addAttribute("board",board);
		return "board/bview";
	}//bview
	
	@GetMapping("/board/bwrite")
	public String bwrite() {
		return "board/bwrite";
	}//bwrite
	
	@PostMapping("/board/dobwrite")
	public String dobwrite(Board board,@RequestPart 
			MultipartFile file)throws Exception {
		String fileName="";
		if(!file.isEmpty()) {   // 파일을 upload에 저장
			String ori_fileName = file.getOriginalFilename();
			UUID uuid = UUID.randomUUID();
			fileName = uuid+"_"+ori_fileName;
			String uploadUrl = "c:/upload/";
			File f = new File(uploadUrl+fileName);
			file.transferTo(f);
		}
		board.setBfile(fileName);
		bService.insertOne(board);
		return "redirect:blist";
	}//dobwrite

	@GetMapping("/board/bwrite2")
	public String bwrite2() {
		return "board/bwrite2";
	}//bwrite2
	
	@PostMapping("/board/bwrite2")
	public String bwrite2(Board board, List<MultipartFile>files)throws Exception {
		String fName="";
		String fileName="";
		int i=0;
		for(MultipartFile file:files) {
			//System.out.println(file.getOriginalFilename());
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
		board.setBfile(fName);
		bService.insertOne(board);
		
		return "bwrite2";
	}//bwrite2
	
	@GetMapping("/board/bwrite3")
	public String bwrite3() {
		return "board/bwrite3";
	}//bwrite3
	
	@PostMapping("/uploadImage")
	public String uploadImage(@RequestPart MultipartFile afile)throws Exception {
		String urlName="";
		long time = System.currentTimeMillis();
		long oriFileName = 0;
		String uploadfileName = time+"_"+oriFileName;//파일이름변경
		String uploadUrl = "c:/upload/";
		File f = new File(uploadUrl+uploadfileName);//파일등록
		afile.transferTo(f);//파일서버로 전송
		urlName = "/images/"+uploadfileName;
		return "urlName";
	}//bwrite3
	





}//class
