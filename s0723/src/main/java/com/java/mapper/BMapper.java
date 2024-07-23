package com.java.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.java.dto.Board;

@Mapper
public interface BMapper {

	public ArrayList<Board> selectAll();

	public Board selectOne(int bno);

	public Board selectPrev(int bno);

	public Board selectNext(int bno); 
		
	
}
