package com.java.service;

import java.util.ArrayList;
import java.util.List;

import javax.xml.stream.events.Comment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.dto.Board;
import com.java.dto.cBoard;
import com.java.mapper.BMapper;

@Service

public class BServiceImpl implements BService {
	@Autowired BMapper bMapper;
	@Override
	public ArrayList<Board> selectAll() {
		ArrayList<Board>list = bMapper.selectAll();
		return list;
	}
	@Override
	public Board selectOne(int bno) {
		Board board = bMapper.selectOne(bno);
		return board;
	}
	@Override
	public ArrayList<cBoard> commnentAll(int bno) {
		ArrayList<cBoard>comt = bMapper.commnentAll(bno);
		return comt;
	}
	@Override
	public cBoard commentInsert(cBoard cboard) {
		bMapper.commentInsert(cboard);
		cBoard cbod = bMapper.commnentOne(cboard.getCno());
		return null;
	}
	
	
	
}
