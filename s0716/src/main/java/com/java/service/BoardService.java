package com.java.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.java.dto.Board;

@Service
public interface BoardService {

	public ArrayList<Board> selectBoardAll();

	public Board boardSelectOne(int BNO);
	
		
	
	
}//class BoardService
