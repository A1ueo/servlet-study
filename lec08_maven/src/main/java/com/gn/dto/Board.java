package com.gn.dto;

public class Board {
	private int boardNo;
	private String boardTitle;
	private String boardContent;
	private int boardWriter;
	
	// db에서 날짜 정보 처리 CURRENT_TIMESTAMP
	private String regDate;
	private String modDate;
}
