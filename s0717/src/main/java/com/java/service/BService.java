package com.java.service;

import java.util.ArrayList;

import com.java.dto.Board;

public interface BService {

	ArrayList<Board> selectBoardAll();

	Board selectBoardOne(int bno);

	void insertOne(Board board);

	void updateOne(Board board);

	void bdeleteOne(int bno);

	void updateBhitUp(int bno);


	

}//
