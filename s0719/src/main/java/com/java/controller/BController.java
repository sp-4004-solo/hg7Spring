package com.java.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import com.java.dto.Board;
import com.java.service.BService;

@Controller
@RequestMapping("/board")

public class BController {
	
	@Autowired BService bService;//객체자동생성후 선언함.
	@RequestMapping("/blist")//리스트에 요청함.
	public String blist(@RequestParam(defaultValue = "1") int page, Model model) {
		//모델에 실려 값을 보냄
		
		HashMap<String, Object>map = bService.selectAll(page);
		System.out.println(map.get("maxPage"));
		
		
		//확인용
		//System.out.println(map.get(0).getId());//확인용
		model.addAttribute("listCount",map.get("listCount"));//모델에 값을 추가함.
		model.addAttribute("maxPage",map.get("maxPage"));//모델에 값을 추가함.
		model.addAttribute("startPage",map.get("startPage"));//모델에 값을 추가함.
		model.addAttribute("endPage",map.get("endPage"));//모델에 값을 추가함.
		model.addAttribute("startRow",map.get("startRow"));//모델에 값을 추가함.
		model.addAttribute("endRow",map.get("endRow"));//모델에 값을 추가함.
		model.addAttribute("page",map.get("page"));//모델에 값을 추가함.
		model.addAttribute("list",map.get("list"));//모델에 값을 추가함.
		return "/board/blist";//리스트로 돌려보냄
	}//blist
	
	
	@RequestMapping("/bread")
	public String bread(Model model, int bno) {
		System.out.println("bno:"+bno);
		 Board board = bService.selectOne(bno);
		 System.out.println("board"+board);
		 //확인용
		 model.addAttribute("Board", board);
		return "/board/bread";
		
	}//bread
	
	
	@GetMapping("/bwrite")
	public String bwrite() {
		return "/board/bwrite";
	}//bwrite
	
	@PostMapping("/bwrite")
	public String dobwrite(Board board, @RequestPart MultipartFile file) {
		String fileName ="";
		if(!file.isEmpty()) {
			String ori_file = file.getOriginalFilename();// 실제파일이름
			UUID uuid = UUID.randomUUID();// 랜덤숫자생성
			fileName = uuid+"_"+ori_file; // 최종파일이름
			String uploadUrl = "c:/upload/"; // 파일이저장될위치
			File f = new File(uploadUrl+fileName);
			try {
				file.transferTo(f);// 파일저장
			}catch(Exception e) {e.printStackTrace();}
		}
		board.setBfile(fileName); // board객체에 file이름저장
		System.out.println(fileName);//콘솔창에 출력해준다.
		bService.insertOne(board);
		
		return "redirect:blist";
	}//dobwrite
	
	@GetMapping("/bdelete")
	public String bdelete(int bno) {
		bService.deleteOne(bno);
		return "redirect:blist";
	}//bdelete
	
	
	@GetMapping("/bmodi")
	public String bmodiint (int bno, Model model) {// 번호를 가져오고, 출력은 모델로연결
		Board board = bService.selectOne(bno);
		model.addAttribute("Board",board);
		return "/board/bmodi";
	}//bwrite
	
	@PostMapping("/bmodi")//				   							
	public String dobmodi(Board board, @RequestPart MultipartFile file) {
		String fileName ="";
		if(!file.isEmpty()) {
			String ori_file = file.getOriginalFilename();// 실제파일이름
			UUID uuid = UUID.randomUUID();// 랜덤숫자생성
			fileName = uuid+"_"+ori_file; // 최종파일이름
			String uploadUrl = "c:/upload/"; // 파일이저장될위치
			File f = new File(uploadUrl+fileName);
			try {
				file.transferTo(f);// 파일저장
			}catch(Exception e) {e.printStackTrace();}
		}
		board.setBfile(fileName); // board객체에 file이름저장
		System.out.println(fileName);//콘솔창에 출력해준다.
		bService.insertOne(board);
		
		return "redirect:blist";
	}//dobwrite
	
	@PostMapping("/update")//				   							
	public String update(Board board, @RequestPart MultipartFile file) {
		String fileName ="";
		if(!file.isEmpty()) {
			String ori_file = file.getOriginalFilename();// 실제파일이름
			UUID uuid = UUID.randomUUID();// 랜덤숫자생성
			fileName = uuid+"_"+ori_file; // 최종파일이름
			String uploadUrl = "c:/upload/"; // 파일이저장될위치
			File f = new File(uploadUrl+fileName);
			try {
				file.transferTo(f);// 파일저장
			}catch(Exception e) {e.printStackTrace();}
			board.setBfile(fileName); // board객체에 file이름저장
		}
		System.out.println(fileName);//콘솔창에 출력해준다.
		bService.updateOne(board);
		
		return "redirect:blist";
	}//update
	
	
	@GetMapping("/breply")
	public String breply (int bno, Model model) {// 번호를 가져오고, 출력은 모델로연결
		Board board = bService.selectOne(bno);
		model.addAttribute("Board",board);
		return "/board/breply";
	}//bwrite
	
	
	@PostMapping("/breply")//				   							
	public String breply(Board board, @RequestPart MultipartFile file) {
		System.out.println("답변달기");
		System.out.println("bno:"+board.getBno());
		
		System.out.println("bno:"+board.getBgroup());
		System.out.println("bno:"+board.getBindent());
		System.out.println("bno:"+board.getBstep());
		
		String fileName ="";
		if(!file.isEmpty()) {
			String ori_file = file.getOriginalFilename();// 실제파일이름
			UUID uuid = UUID.randomUUID();// 랜덤숫자생성
			fileName = uuid+"_"+ori_file; // 최종파일이름
			String uploadUrl = "c:/upload/"; // 파일이저장될위치
			File f = new File(uploadUrl+fileName);
			try {
				file.transferTo(f);// 파일저장
			}catch(Exception e) {e.printStackTrace();}
		}
		board.setBfile(fileName); // board객체에 file이름저장
		System.out.println(fileName);//콘솔창에 출력해준다.
		bService.replypOne(board);
		
		return "redirect:blist";
	}//dobwrite
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
