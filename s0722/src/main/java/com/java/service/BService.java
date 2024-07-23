package com.java.service;

import java.util.ArrayList;
import java.util.HashMap;

import com.java.dto.Board;
import com.java.mapper.BMapper;

public interface BService {

	HashMap<String, Object> selectAll(int page, String category, String s_word);

	HashMap<String, Object> selectOne(int bno);

	void insertOne(Board board);

	void insertReplyOne(Board board);
	
	
}
