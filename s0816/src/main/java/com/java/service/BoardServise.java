package com.java.service;

import java.util.HashMap;

import com.java.dto.Page;

public interface BoardServise {

	HashMap<String, Object> selectAllBoard(Page pageDto);

	HashMap<String, Object> selectOneBoard(int bno, Page pageDto);

	

	

}
