package com.java.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.annotation.JsonCreator.Mode;
import com.java.service.BService;

@Controller
public class BController {
	@Autowired BService bService;
	@RequestMapping("/board/notice")
	public String notice(Model model) {
		//board를 db에서 가져와서 게시판에 출력하기
		HashMap<String, Object>map = bService.selectAll();
		model.addAttribute("list",map.get("list")); 
		return "board/notice";
	}//notice
	
	@RequestMapping("/board/noticeView")
	public String noticeView(int bno, Model model) {
		HashMap<String, Object>map = bService.selectOne(bno);
		model.addAttribute("board",map.get("board"));
		model.addAttribute("prev",map.get("prev"));
		model.addAttribute("next",map.get("next"));
		return "board/noticeView";
	}//noticeView
}
