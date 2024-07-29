package com.java.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.java.dto.Board;
import com.java.dto.cBoard;

@Mapper
public interface BMapper {

	ArrayList<Board> selectAll();

	Board selectOne(int bno);

	cBoard commnentOne(int bno);

	ArrayList<cBoard> commnentAll(int bno);

	void commentInsert(cBoard cboard);

}
