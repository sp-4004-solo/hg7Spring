package com.java.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.dto.Board;
import com.java.mapper.BoardMapper;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Service	
public class BoardServiceImpl implements BoardService{
	@Autowired// 메퍼선언
	BoardMapper boardMapper;//메퍼 불러오기
	@Override
	public ArrayList<Board> selectBoardAll() {
		ArrayList<Board> list = boardMapper.selectBoardAll();
		return list;
	}
	@Override
	public Board boardSelectOne(int BNO) {
		Board board = boardMapper.selectBoardOne(BNO);
		return board;
	}//boardSelectOne

}//BoardServiceImpl
