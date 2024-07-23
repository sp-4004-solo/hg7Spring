package com.java.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.java.dto.Board;

@Mapper
public interface Bmapper {

//	ArrayList<Board> selectAll();
	ArrayList<Board> selectAll(int startRow, int endRow);

	Board selectOne(int bno);

	void insertOne(Board board);

	void deleteOne(int bno);

	void updateOne(Board board);

	void insertReplyOne(Board board);

	void updateBstepCount(Board board);

	int selectListCount();



	
}
