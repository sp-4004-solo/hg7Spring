package com.java.controller;

import java.util.ArrayList;

import javax.swing.border.Border;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.java.dto.Board;
import com.java.service.BoardService;

import jakarta.servlet.http.HttpSession;

@Controller
//Controller 반드시 써줘야 역할을 한다
public class BController {
	
	@Autowired
	BoardService boardService;
	@Autowired
	HttpSession session;
	@RequestMapping("/board/bList")
	public String bList(Model model) {
		
		ArrayList<Board>list = boardService.selectBoardAll();
		System.out.println(list.get(0).getBTITLE());
		model.addAttribute("list",list);//전송
		return "board/bList";
	}//bList
	
	@RequestMapping("/board/bView")
	public String bView(int BNO, Model model) {
		System.out.println();//확인용
		Board board = boardService.boardSelectOne(BNO);
		System.out.println(board.getBTITLE());
		model.addAttribute("board",board);//전송
		return "board/bView";
	}//bView
	
	
	
}//class Bcontroller
