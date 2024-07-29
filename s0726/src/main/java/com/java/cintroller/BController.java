package com.java.cintroller;

import java.util.ArrayList;

import javax.xml.stream.events.Comment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.java.dto.Board;
import com.java.dto.cBoard;
import com.java.service.BService;

@Controller
public class BController {
	@Autowired BService bService;
	@RequestMapping("/notice")
	public String notice(Model model) {
		ArrayList<Board>list = bService.selectAll();
		model.addAttribute("list", list);//모델에 실려보냄
		return "board/notice";
	}//notice
	
//	@RequestMapping("/notice_view")
//	public String notice_viewMo(int bno, Model model) {
//		Board board = bService.selectOne(bno);
//		model.addAttribute("board", board);
//		return "board/notice_view";
//	}//notice_view
	
	@RequestMapping("/notice_view")
	public String notice_viewMo(int bno, Model model) {
		Board board = bService.selectOne(bno);
		ArrayList<cBoard>comList = bService.commnentAll(bno);
		model.addAttribute("comList",comList);//jsp에 보여주기 위해서 보낸다.
		model.addAttribute("board", board);
		System.out.println(comList.size());
		return "board/notice_view";
	}//notice_view
	
	@PostMapping("/board/insertComm")
	@ResponseBody
	public cBoard commentInsert(cBoard cboard){
		cBoard cbod = bService.commentInsert(cboard); 
		return cbod;
	}
	
//	
//	@RequestMapping("/notice_view")
//	public String notice_view(int bno, Model model) {
//		Board board = bService.selectOne(bno);
//		model.addAttribute("board",board);
//		return "board/notice_view";
//	}
	
}










