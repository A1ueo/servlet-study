package com.gn.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Product {
	private int productNo;
	private String productName;
	private int productPrice;
	private int productCategory;
	
	// 상속을 사용해서 별도의 클래스를 만드는게 
	// 깔끔해 보일 것으로 생각됨..
	private int sort;
}
