package com.gn.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public class Product {
	private int code;
	private String name;
	private int price;
}
