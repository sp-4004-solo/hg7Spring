package com.java.service;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.dto.Board;
import com.java.mapper.BMapper;

@Service
public class BServiceImpl implements BService{
@Autowired BMapper bMapper;
	@Override
	public ArrayList<Board> selectBoardAll() {
		//Board board = bMapper.selectBoardAll();//사용안함.
		ArrayList<Board>list = bMapper.selectBoardAll();
		return list;
	}//selectBoardAll
	
	@Override
	public void insertOne(Board board) {
		bMapper.insertOne(board);
	}//insertOne

	@Override
	public Board selectOne(int bno) {
		Board board = bMapper.selectOne(bno);
		return board;
	}
	
	
	
	
	
	
	
	
	
	
}//class

