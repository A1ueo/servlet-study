package com.gn.controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.json.simple.JSONObject;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GuestBookWriteServlet
 */
@WebServlet("/guestBookWrite")
public class GuestBookWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GuestBookWriteServlet() {
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
		
		String name = request.getParameter("name");
		String msg = request.getParameter("msg");
		
		LocalDateTime dateTime = LocalDateTime.now();
		String now = dateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm"));
		System.out.println(name);
		System.out.println(msg);
		System.out.println(now);
		
		JSONObject obj = new JSONObject();
		obj.put("name", name);
		obj.put("msg", msg);
		obj.put("now", now);
		
		response.setContentType("application/json; charset=utf-8");
		response.getWriter().print(obj);
		System.out.println("응답 전송");
	}

}
