package com.java.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.dto.Board;
import com.java.mapper.Bmapper;

@Service
public class BServiceImpl implements BService{
	@Autowired Bmapper bmapper;
	@Override
	
	
	public HashMap<String, Object> selectAll(int page) {
		HashMap<String, Object> map = new HashMap<>();
		
		//1. 총게시글 수
		int listCount = bmapper.selectListCount();
		//2. 최대페이지
		int maxPage = (int)Math.ceil(listCount/10.0);
		System.out.println("게시글 수:"+listCount);
		System.out.println("현재페이지 수:"+page);
		System.out.println("maxPage :"+ maxPage);
		//3. startPage, endPage
		int startPage = (int)((page-1)/10)*10+1;
		int endPage = startPage+10-1;
		//page=2이면 1 2 3 4 5 6 7 8 9 10
		//page=22이면 21 22 23 ........30
		//4. startRow, enfRow
		int startRow = (page-1)*10+1;
		int endRow = startRow+10-1;
		System.out.println("게시글 수 :"+listCount);
		System.out.println("현재 페이지 :"+page);
		System.out.println("최대 페이지 :"+maxPage);
		System.out.println("start 페이지 :"+startPage);
		System.out.println("end페이지 :"+endPage);
		System.out.println("startRow 페이지 :"+startRow);
		System.out.println("endRow페이지 :"+endRow);
		
		if(endPage > maxPage) endPage=maxPage;
		ArrayList<Board>list = bmapper.selectAll(startRow, endRow);
		
		map.put("listCount",listCount);
		map.put("maxPage",maxPage);
		map.put("startPage",startPage);
		map.put("endPage",endPage);
		map.put("startRow",startRow);
		map.put("endRow",endRow);
		map.put("list",list);
		map.put("page",page);
		
		return map;
	}
	@Override
	public Board selectOne(int bno) {
		Board b;
		b = bmapper.selectOne(bno);
		return b;
	}
	@Override
	public void insertOne(Board board) {
		bmapper.insertOne(board);
	}
	@Override
	public void deleteOne(int bno) {
		bmapper.deleteOne(bno);
		
	}
	@Override
	public void updateOne(Board board) {
		bmapper.updateOne(board);
		
	}
	@Override
	public void replypOne(Board board) {
		//1.답글게시글을 추가하는 부분
		bmapper.insertReplyOne(board);
		//2. bstep조정하는 부분
		bmapper.updateBstepCount(board);
		
	}
	
}
