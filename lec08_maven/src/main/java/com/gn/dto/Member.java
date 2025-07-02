package com.gn.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Member {
	private int memberNo;
	private String memberId;
	private String memberPw;
}
