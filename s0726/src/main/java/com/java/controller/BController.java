package com.java.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.java.dto.Board;
import com.java.dto.cBoard;
import com.java.service.BService;

@Controller
@RequestMapping("/board")
public class BController {
	@Autowired BService bService;
	
	@RequestMapping("/notice")
	public String notice(Model model) {
		ArrayList<Board> list = bService.selectAll();
		model.addAttribute("list",list);
		return "board/notice";
	}
	@RequestMapping("/notice_view")
	public String notice_view(int bno, Model model) {
		Board board = bService.selectOne(bno);
		ArrayList<cBoard> clist = bService.selectComAll(bno);
		model.addAttribute("board",board);
		model.addAttribute("clist",clist);
		return "board/notice_view";
	}
	@RequestMapping("/insertComm")
	@ResponseBody
	public cBoard incomm(cBoard cb) {
		System.out.println(cb.getCcontent());
		cBoard comment = bService.insertCom(cb);
		return comment;
	}
	
	
	
}
