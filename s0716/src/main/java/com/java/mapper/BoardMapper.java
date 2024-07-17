package com.java.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.java.dto.Board;

@Mapper
public interface BoardMapper {

	ArrayList<Board> selectBoardAll();//boardMapper.xml에 넣어줌

	Board selectBoardOne(int BNO);//boardMapper.xml에 넣어줌

}//interface BoardMapper
