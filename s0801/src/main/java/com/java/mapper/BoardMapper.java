package com.java.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.java.dto.Board;
import com.java.dto.Comment;

@Mapper
public interface BoardMapper {

	ArrayList<Board> selectAll();

	Board selectOne(int bno);

	ArrayList<Comment> selectComAll(int bno);

	Comment selectCommentOne(Comment comment);

	void insertCommentOne(Comment comment);

	void delComment(int cno);

	void updateCommentOne(Comment comment);

	void insertOne(Board board);

	

}//interface
