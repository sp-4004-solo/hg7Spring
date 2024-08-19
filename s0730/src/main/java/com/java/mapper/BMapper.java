package com.java.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.java.dto.Board;

@Mapper
public interface BMapper  {

	public ArrayList<Board> selectBoardAll();

	public void insertOne(Board board);

	public Board selectOne(int bno);

	
	
	
	
	
}//class
