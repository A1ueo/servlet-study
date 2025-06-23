package com.gn.mapping;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * Servlet implementation class SendGetServlet
 */
@WebServlet("/joinMember")
public class SendGetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SendGetServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("user_name");
		String gender = request.getParameter("gender");
		int age = Integer.parseInt(request.getParameter("user_age"));
		
		String[] hobbyArr = request.getParameterValues("hobby");
		
		System.out.println("이름: " + name);
		System.out.print("성별: ");
		if ("1".equals(gender)) {
			System.out.println("남자");
		} else if ("2".equals(gender)){
			System.out.println("여자");
		}
		
		System.out.println("나이: " + age);
		if (hobbyArr == null || hobbyArr.length == 0) {
			System.out.println("취미 없음");
		}
		else {
				System.out.println("===== 취미 목록 =====");
				Map<String, String> map = new HashMap<String, String>() {{
					put("1", "야구");
					put("2", "농구");
					put("3", "축구");
				}};
				
				StringBuilder sb = new StringBuilder();
				for (int i = 0; i < hobbyArr.length; i++) {
					if (i != 0) sb.append(", ");
					sb.append(map.get(hobbyArr[i]));
				}
				sb.append('\n');
				System.out.println(sb);
		}
//		// 1. 응답 형식 지정
//		response.setContentType("text/html; charset=utf-8");
//		
//		// 2. 응답하고자 하는 사용자와의 연결통로 생성
//		PrintWriter out = response.getWriter();
//		
//		// 3. HTML 구문 한줄씩 쌓기
//		out.println("<html>");
//		out.println("<head>");
//		out.println("<meta charset='UTF-8'>");
//		out.println("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
//		out.println("<title>회원가입 결과화면</title>");
//		out.println("</head>");
//		out.println("<body>");
//		out.println("<h1>" + name + "님, 환영합니다</h1>");
//		out.println("<h2>앞으로도 자주 와주실꺼죠?</h2>");
//		out.println("<a href='/'>홈페이지로 이동</a>");
//		out.println("</body>");
//		out.println("</html>");
//		
//		// 4. 쌓여있는 데이터 밀어내기
//		out.flush();
		
		// jsp로 변경
		// 1. jsp로 요청을 넘기는 역할 = 어느 jsp에 넘길지 지정
		RequestDispatcher view = request.getRequestDispatcher("views/joinSuccess.jsp");
		// 2. jsp에게 데이터를 넘겨주기
		request.setAttribute("name", name);
		// 3. 화면을 jsp에게 넘기고, 응답을 jsp에게 맡기기
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
