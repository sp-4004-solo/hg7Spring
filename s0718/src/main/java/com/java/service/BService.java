package com.java.service;

import java.util.ArrayList;
import java.util.HashMap;

import com.java.dto.Board;

public interface BService {

	HashMap<String, Object> selectAll(int page);

	Board getselectOne(int bno);

	void insertOne(Board board);

	void updateOne(Board board);

	void deleteOne(int bno);

	void insertReplyOne(Board board);

	

}
