package com.java.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.java.dto.Board;
import com.java.dto.galleryList;

public interface BService {

	ArrayList<Board> selectAll();

	Board insertBoard(Board board);

	void insertGallery(galleryList gallerylist);

}//BService
