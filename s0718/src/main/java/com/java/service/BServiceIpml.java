package com.java.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.dto.Board;
import com.java.mapper.Bmapper;

@Service
public class BServiceIpml implements BService {
	@Autowired Bmapper bmapper;
	@Override
	public HashMap<String, Object> selectAll(int page) {
		
		HashMap<String, Object> map = new HashMap<>();
		
		//1. 전체게시물 수
		int listCount=bmapper.selectListCount();  //1.전체게시물수
		//ArrayList<Board>list = bmapper.selectAll();
		//최대페이지
		int maxPage = (int)Math.ceil(listCount/10.0);
		System.out.println("최대페이지"+maxPage);
		
		int startPage = (int)((page-1)/10)*10+1;
		int endPage = startPage+10-1;
		//page에 11이 넘어와야 스타트 페이지가 바뀐다.
		System.out.println("startPage:"+startPage);
		System.out.println("endPage:"+endPage);
		int startRow = (page-1)*10+1;
		int endRow  = startRow+10-1;
		System.out.println("startRow:"+startRow);
		System.out.println("endRow:"+endRow);
		
		//내가 가진 페이지까지만 노출
		
		if(endPage>maxPage)endPage = maxPage;
		
		ArrayList<Board>list = bmapper.selectAll(startRow, endRow);
		
		map.put("listCount", listCount);
		map.put("maxPage", maxPage);
		map.put("startPage", startPage);
		map.put("endPage", endPage);
		map.put("page", page);
		map.put("list", list);
		map.put("startRow", startRow);
		map.put("endRow", endRow);
		
		
		
		return map;
	}
	@Override
	public Board getselectOne(int bno) {
		Board board = bmapper.getselectOne(bno);
		return board;
	}
	@Override
	public void insertOne(Board board) {
		bmapper.insertOne(board);
		
	}
	@Override
	public void updateOne(Board board) {
		bmapper.updateOne(board);
		
	}
	@Override
	public void deleteOne(int bno) {
		bmapper.deleteOne(bno);
		
	}
	@Override
	public void insertReplyOne(Board board) {
		bmapper.insertReplyOne(board);
		bmapper.updateBstepCount(board);
	}

}
