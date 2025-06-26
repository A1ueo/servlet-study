package com.gn.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.gn.dto.Product;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/AddToCartServlet")
public class AddToCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AddToCartServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Product> ProductList = new ArrayList<Product>();
		ProductList.add(new Product(1001, "키보드", 25000));
		ProductList.add(new Product(1002, "마우스", 15000));
		ProductList.add(new Product(1003, "모니터", 180000));
		
		HttpSession session = request.getSession(true);
		String productName = (String) request.getParameter("product");
		
		List<Product> list = null;
		if (session != null) 
			list = (List) session.getAttribute("product_list");
		if (list != null) {
		}
		
		
		
		response.sendRedirect("/views/productPage.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

}
