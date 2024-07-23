package com.java.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.java.dto.Board;
import com.java.dto.Member;
import com.java.mapper.BMapper;

@Service
public class BServiceImpl implements BService{
@Autowired BMapper bMapper;
	@Override
	public HashMap<String, Object> selectAll(int page, String category, String s_word) {
		HashMap<String, Object> map = new HashMap<>();//빈껍데기생성
		// page, 게시글 관련 부분.
		// 1. 총 게시글의 수
		int listCount = bMapper.selectListCount(category, s_word);
		// 2. 최대페이지
		int maxPage = (int)Math.ceil(listCount/10.0);
		// 3. startPage, endPage
		int startPage = (int)((page-1)/10)*10+1;
		int endPage = startPage+10-1;
		// 4. startRow, endRow
		int startRow = (page-1)*10+1;
		int endRow = startRow+10-1;
		if(endPage > maxPage) endPage=maxPage;
		// startrow부터 endrow 까지의 게시글 가져오기
		ArrayList<Board> list =   bMapper.selectAll(startRow,endRow,category,s_word);
		// map에 내용 추가하기
		map.put("listCount", listCount);
		map.put("maxPage", maxPage);
		map.put("startPage", startPage);
		map.put("endPage", endPage);
		map.put("startRow", startRow);
		map.put("endRow", endRow);
		map.put("page", page);
		map.put("list", list);
		map.put("category", category);
		map.put("s_word", s_word);
		
		return map;
	}
	@Override
	public HashMap<String, Object> selectOne(int bno) {
		HashMap<String,Object>map = new HashMap<>();//빈껍데기 생성
		Board board = bMapper.selectOne(bno);
		//보드라는 객체생성후 bMapper의 selectOne 메서드에 bno 매개변수를 넣어서 호출했다.
		Board prev = bMapper.selectPrev(bno);
		Board next = bMapper.selectnext(bno);
		
		//		  key값   value값
		map.put("board", board);
		map.put("prev", prev);
		map.put("next", next);
		
//		System.out.println("prev bno:"+prev.getBno());
//		System.out.println("board bno:"+board.getBno());
//		System.out.println("next bno:"+next.getBno());
//		
		
		return map;
	}
	@Override
	public void insertOne(Board board) {
		bMapper.insertOne(board);
	}
	@Override
	public void insertReplyOne(Board board) {
		bMapper.insertReplyOne(board);
		
	}
	
	
	 
}
