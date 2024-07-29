package com.java.service;

import java.util.ArrayList;

import javax.xml.stream.events.Comment;

import com.java.dto.Board;
import com.java.dto.cBoard;

public interface BService {

	ArrayList<Board> selectAll();

	Board selectOne(int bno);

	ArrayList<cBoard> commnentAll(int bno);

	cBoard commentInsert(cBoard cboard);

	

	

	

}
