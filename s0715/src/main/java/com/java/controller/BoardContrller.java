package com.java.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BoardContrller {
	//주소
		@RequestMapping("/board/board1")
		public String board1() {
			//파일의 위치
			return "board/board1";
		}
		
}
