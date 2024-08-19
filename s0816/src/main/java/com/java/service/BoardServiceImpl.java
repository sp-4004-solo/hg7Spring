package com.java.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.dto.Board;
import com.java.dto.Page;
import com.java.mapper.BoardMapper;
@Service
public class BoardServiceImpl implements BoardServise{
	@Autowired BoardMapper bmapper;
	@Override
	public HashMap<String, Object> selectAllBoard(Page pageDto) {
		pageDto=pageMethod(pageDto);//새로운 정보
		
		ArrayList<Board>list = bmapper.selectAllBoard(pageDto);
		HashMap<String, Object>map=new HashMap<>();
		
		map.put("list",list);
		map.put("pageDt",pageDto);
		
		
		return map;
	}
	
	private Page pageMethod(Page pageDto) {
		// 전체 게시글 수 저장
		pageDto.setListCount(   bmapper.selectListCount()   );
		// 최대 넘버링 페이지
		pageDto.setMaxPage( (int)Math.ceil( (double)pageDto.getListCount()/10  ));
		// 시작 넘버링페이지
		pageDto.setStartPage(  (int)((pageDto.getPage()-1)/10)*10 +1     );
		// 끝 넘버링 페이지
		pageDto.setEndPage(  pageDto.getStartPage() + 10 - 1   );
		// 게시글 시작번호
		pageDto.setStartRow( (pageDto.getPage() - 1 ) * 10 + 1   );
		// 게시글 끝나는 번호
		pageDto.setEndRow( pageDto.getStartRow() + 10 - 1 );
		
		return pageDto;
	}

	@Override
	public HashMap<String, Object> selectOneBoard(int bno, Page pageDto) {
		
		HashMap<String, Object>map = new HashMap<>();
		Board bdto = bmapper.selectOneBoard(bno);
		Board prev = bmapper.selectPrevBoard(bno);
		Board next = bmapper.selectNextBoard(bno);
		
		map.put("bdto",bdto);
		map.put("prev",prev);
		map.put("next",next);
		
		
		
		return map;
	}

}
