package com.gn.service;

import java.util.List;

import com.gn.dao.ProductDao;
import com.gn.dto.Product;

public class ProductService {
	ProductDao dao = new ProductDao();

	public List<Product> searchProducts(String name, int category, int sort) {
		Product param = new Product();
		param.setProductName(name);
		param.setProductCategory(category);
		param.setSort(sort);
		
		List<Product> list = dao.searchProducts(param);
		
//		db에서 정렬하는 것 보다 오래걸림
//		switch (sort) {
//		case 0:
//			break;
//		case 1:
//			list.sort((x, y) -> {
//				return Integer.compare(x.getProductPrice(), y.getProductPrice());
//			});
//			break;
//		case 2:
//			list.sort((x, y) -> {
//				return Integer.compare(y.getProductPrice(), x.getProductPrice());
//			});
//			break;
//		case 3:
//			list.sort((x, y) -> {
//				return Integer.compare(y.getProductNo(), x.getProductNo());
//			});
//			break;
//		}
		
		return list;
	}
	
}
