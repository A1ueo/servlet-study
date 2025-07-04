package com.gn.dto;

import com.gn.common.vo.Paging;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Board extends Paging {
	private int boardNo;
	private String boardTitle;
	private String boardContent;
	private int boardWriter;
	
	// db에서 날짜 정보 처리 CURRENT_TIMESTAMP
	private String regDate;
	private String modDate;
	
	private String keyword;
}
