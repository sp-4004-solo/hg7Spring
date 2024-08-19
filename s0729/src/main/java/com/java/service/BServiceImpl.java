package com.java.service;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.dto.Board;
import com.java.dto.galleryList;
import com.java.mapper.BMapper;
@Service//interface에 service어노테이션 불러온다.
public class BServiceImpl implements BService{
	@Autowired BMapper bmapper; 
	@Override
	public ArrayList<Board> selectAll() {
		ArrayList<Board>list= bmapper.selectAll();
		return list;
	}//selectAll

	
		@Override
	public Board insertBoard(Board board) {
		bmapper.insertBoard(board);
		Board bdto = bmapper.selectOne(board);
		return board;
	}//insertBoard


		@Override
		public void insertGallery(galleryList gallerylist) {
			bmapper.insertGallery(gallerylist);
			
		}//insertGallery

		
	

}//class
