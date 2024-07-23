package com.java.controller;

import java.io.File;
import java.util.ArrayList;
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



@Controller
@RequestMapping("/board")
public class BController {
	
	@Autowired
	BService bService;
	
	
	@GetMapping("/bdelete")
	public String bdeleteOne(int bno) {
		System.out.println("bdelete");
		bService.bdeleteOne(bno);
		return "redirect:blist";
		
	}//bdelete
	
	@GetMapping("/bmodi")
	public String bmodi(int bno, Model model) {
		System.out.println("get으로 게시글 수정 ");
		System.out.println(bno);
		Board board = bService.selectBoardOne(bno);
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
		
		
		
	}//bmodi
	
	
	@RequestMapping("/blist")
	public String blist(Model  model) {
		
		ArrayList<Board>list = bService.selectBoardAll();
		//확인용
		System.out.println(list.get(0).getBtitle());
		
		//model
		model.addAttribute("list",list);
		return "board/blist";
		
	}//blist
	
	@RequestMapping("/bview")
	public String bview(int bno, Model model) {
		System.out.println("bno:"+bno);
		Board bDto = bService.selectBoardOne(bno);
		bService.updateBhitUp(bno);
		//확인용
		System.out.println(bDto.getBtitle());
		//model
		model.addAttribute("board",bDto);
		
		return "board/bview";
		
	}//bview
	
	//글쓰기 화면을 출력
	@GetMapping("/bwrite")
	public String bwrite() {
		System.out.println("Get방식으로 들어옵니다.");
		return "/board/bwrite";
		
	}//bwrite
	
	
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
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}//class
