package com.java.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.java.dto.Board;

@Mapper
public interface BMapper {
	
	//게시글 전체 가져오기
	public ArrayList<Board> selectAll(int startRow, 
			int endRow, String category, String s_word);

	//게시글 하나 가져오기
	public Board selectOne(int bno);

	//이전 게시글 가져오기
	public Board selectPrev(int bno, String category, String s_word);

	//다음 게시글 가져오기
	public Board selectNext(int bno, String category, String s_word);

	public int selectListCount(String category, String s_word); 
		
	
}
