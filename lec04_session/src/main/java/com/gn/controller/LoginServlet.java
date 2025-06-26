package com.gn.controller;

import java.io.IOException;

import com.gn.dto.Account;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public LoginServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String userId = request.getParameter("user_id");
		String userPw = request.getParameter("user_pw");
		
		HttpSession session = request.getSession(true);
		if ("admin".equals(userId)) {
			if ("admin1234".equals(userPw)) {
				String name = "관리자";
				Account account = new Account(userId, name);
				session.setAttribute("account", account);
				session.setMaxInactiveInterval(60 * 30);
				
				System.out.println("로그인 세션");
			}
		}
//		Account acc = (Account) session.getAttribute("account");
//		System.out.println(acc);
		
		response.sendRedirect("/");
	}

}
