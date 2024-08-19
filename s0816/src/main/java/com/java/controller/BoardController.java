package com.java.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.java.dto.Page;
import com.java.service.BoardServise;

@Controller
public class BoardController {
	@Autowired BoardServise bservice;
	
	@RequestMapping("/board/blist")
	public String blist(Model model, Page pageDto) {
		// 게시판과 연결됨
				HashMap<String, Object> map =  bservice.selectAllBoard(pageDto);
				
				model.addAttribute("list", map.get("list"));
				model.addAttribute("pageDto", map.get("pageDto"));
		
		return "board/blist";
	}
	
	@RequestMapping("/board/bView")
	public String bview(Model model, int bno, Page pageDto) {
		HashMap<String, Object>map = bservice.selectOneBoard(bno, pageDto);
		model.addAttribute("bdto",map.get("bdto"));
		model.addAttribute("prev",map.get("prev"));//이전글
		model.addAttribute("next",map.get("next"));//다음글
		
		
		
		return "board/bview";
	}

}
