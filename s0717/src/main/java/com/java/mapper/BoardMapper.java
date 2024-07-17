package com.java.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.java.dto.Board;

@Mapper
public interface BoardMapper {

	ArrayList<Board> selectBoardAll();

	Board selectBoardOne(int bno);

	void insertOne(Board board);

	void updateOne(Board board);

	void bdeleteOne(int bno);

	void updateBhitUp(int bno);
	
	
}
