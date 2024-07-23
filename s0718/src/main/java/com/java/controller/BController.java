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
	
	
	
	@Autowired BService bService;
	
	
	@RequestMapping("/blist")
	public String blist(@RequestParam(defaultValue = "1")int page, Model model) {
		
		HashMap<String, Object>map = bService.selectAll(page);
		model.addAttribute("list",map.get("list"));
		model.addAttribute("page",map.get("page"));
		model.addAttribute("endRow",map.get("endRow"));
		model.addAttribute("startRow",map.get("startRow"));
		model.addAttribute("endPage",map.get("endPage"));
		model.addAttribute("startPage",map.get("startPage"));
		model.addAttribute("maxPage",map.get("maxPage"));
		model.addAttribute("listCount",map.get("listCount"));
		return "board/blist";
	}//blist

	@RequestMapping("/bview")
	public String bview(int bno, Model model) {
		System.out.println("bno:"+bno);
		Board board = bService.getselectOne(bno); 
		model.addAttribute("board",board);
		return "board/bview";
	}//bview
	
	//쓸수 잇는 화면
	@GetMapping("/bwrite")
	public String bwrite() {
		return "board/bwrite";
	}
	
	//글쓰기 화면에서 저장버튼을 눌렀을때
		@PostMapping("/bwrite")
		public String doBwrite(Board board, Model model
				, @RequestPart MultipartFile file ) {
			System.out.println("post방식으로 들어옵니다");
			
			String fileName="";
			// 파일이 있을 경우 파일 저장
			if(!file.isEmpty()) {//비어있다는 메소드
				String ori_fileName = file.getOriginalFilename(); //실제 파일이름
				UUID uuid = UUID.randomUUID();    // 랜덤숫자 생성
				fileName = uuid+"_"+ori_fileName; // 파일이름 변경 (중복방지)
				System.out.println(fileName);
				String uploadUrl = "c:/upload/" ; // 파일 업로드위치
				File f = new File(uploadUrl+fileName);
				try {
					file.transferTo(f); // 파일 저장
				}catch(Exception e) {e.printStackTrace();}
			}
			board.setBfile(fileName);
			System.out.println("bwrite - fileName : "+ board.getBfile());
			
			bService.insertOne(board);
			
			return "redirect:blist";
		}//doBwrite
		
	
	@GetMapping("/bmodi")
	public String bmodi(int bno, Model model) {//번호를 모델로 실려보냄
		Board board = bService.getselectOne(bno);
		model.addAttribute("board",board);
		return "board/bmodi";
	}//bmodi
	
	@PostMapping("/bmodi")
	public String doBmodi(Board board, Model model, @RequestPart MultipartFile file ) {
		
		String fileName="";
		// 파일이 있을 경우 파일 저장
		if(!file.isEmpty()) {
			String ori_fileName = file.getOriginalFilename(); //실제 파일이름
			UUID uuid = UUID.randomUUID();    // 랜덤숫자 생성
			fileName = uuid+"_"+ori_fileName; // 파일이름 변경 (중복방지)
			System.out.println(fileName);
			String uploadUrl = "c:/upload/" ; // 파일 업로드위치
			File f = new File(uploadUrl+fileName);
			try {
				file.transferTo(f); // 파일 저장
				board.setBfile(fileName);
			}catch(Exception e) {e.printStackTrace();}
		}
		System.out.println("bwrite - fileName : "+ board.getBfile());
		
		bService.updateOne(board);
		
		return "redirect:blist";
	}//dobmodi
	
	@RequestMapping("/bdelete")
	public String bdelete(int bno) {
		System.out.println("delete:"+bno);
		bService.deleteOne(bno);
		return "board/blist";
	}//bdelete
	
	
	//답글창열림
	@GetMapping("/breply")
	public String breply(int bno, Model model) {
		Board board = bService.getselectOne(bno); 
		model.addAttribute("board",board);
		return "board/breply";
	}//breply
	
	
	//답글이 등록됨
	@PostMapping("/breply")
	public String breply(Board board, Model model
			, @RequestPart MultipartFile file) {
		
		System.out.println("bno:"+board.getBno());
		System.out.println("bno:"+board.getBstep());
		System.out.println("bno:"+board.getBgroup());
		System.out.println("bno:"+board.getBindent());
		String fileName="";
		// 파일이 있을 경우 파일 저장
		if(!file.isEmpty()) {
			String ori_fileName = file.getOriginalFilename(); //실제 파일이름
			UUID uuid = UUID.randomUUID();    // 랜덤숫자 생성
			fileName = uuid+"_"+ori_fileName; // 파일이름 변경 (중복방지)
			System.out.println(fileName);
			String uploadUrl = "c:/upload/" ; // 파일 업로드위치
			File f = new File(uploadUrl+fileName);
			try {
				file.transferTo(f); // 파일 저장
				board.setBfile(fileName);
			}catch(Exception e) {e.printStackTrace();}
		}
		
		bService.insertReplyOne(board);
		
		return "redirect:blist";
		
	}//breply
	
	
	
	
	
}//class
