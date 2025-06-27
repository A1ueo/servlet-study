package com.gn.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.gn.dto.Book;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SearchBookServlet
 */
@WebServlet("/searchBook")
public class SearchBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchBookServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		List<Book> list = new ArrayList<Book>();
		list.add(new Book(1, "자바의 정석", "김철수"));
		list.add(new Book(2, "스프링 입문", "이순신"));
		list.add(new Book(3, "MySQL 실습", "홍길동"));
		list.add(new Book(4, "웹 개발 가이드", "유관순"));
		
		String keyword = request.getParameter("keyword");
		System.out.println(keyword);
		
		JSONArray arr = new JSONArray();
		
		int num = -1;
		try {
			num = Integer.parseInt(keyword);
		} catch (Exception e) {
		}
		
		for (Book book : list) {
			if (book.getAutor().contains(keyword) || book.getTitle().contains(keyword)
					 || (num != -1 && book.getNo() == num)) {
				JSONObject obj = new JSONObject();
				obj.put("no", book.getNo());
				obj.put("title", book.getTitle());
				obj.put("author", book.getAutor());
				
				arr.add(obj);
				System.out.println("배열에 저장");
			}
		}
		
		JSONObject result = new JSONObject();
		result.put("arr", arr);
		response.setContentType("application/json; charset=utf-8");
		response.getWriter().print(result);
		System.out.println("응답");
	}

}
