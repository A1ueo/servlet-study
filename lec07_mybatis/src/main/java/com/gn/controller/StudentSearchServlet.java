package com.gn.controller;

import java.io.IOException;

import com.gn.dto.Student;
import com.gn.service.StudentService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class StudentSearchServlet
 */
@WebServlet("/student/search")
public class StudentSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private StudentService service = new StudentService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentSearchServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String studentName = request.getParameter("student_name");
//		System.out.println(studentName);
		Student student = service.getStudentByName(studentName);
//		System.out.println(student);
		request.setAttribute("student", student);
		request.getRequestDispatcher("/student/list").forward(request, response);
//		response.setContentType("text/plain; charset=utf-8");
//		response.getWriter().write("success");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
