package com.gn.controller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BookReserveEndServlet
 */
@WebServlet("/bookReserveEnd")
public class BookReserveEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookReserveEndServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String name = request.getParameter("user_name");
		String phone = request.getParameter("user_phone");
		String email = request.getParameter("user_email");
		int bookNum = Integer.parseInt(request.getParameter("book_name"));
		int period = Integer.parseInt(request.getParameter("borrow_period"));
		
		String title = "";
		int price = 0;
		switch (bookNum) {
		case 1:
			title = "자바 프로그래밍 입문";
			price = 1500;
			break;
		case 2:
			title = "웹 개발의 기초";
			price = 1800 + 500 * (period - 1);
			break;
		case 3:
			title = "데이터베이스 시스템";
			price = 2000 + 500 * (period - 1);
			break;
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("views/book/confirm.jsp");
		
		request.setAttribute("name", name);
		request.setAttribute("phone", phone);
		request.setAttribute("email", email);
		request.setAttribute("period", period);
		
		request.setAttribute("title", title);
		request.setAttribute("price", price);
		
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
