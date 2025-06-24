package com.gn.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PizzaOrderEndServlet
 */
@WebServlet("/pizzaOrderEnd")
public class PizzaOrderEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PizzaOrderEndServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String userName = request.getParameter("user_name");
		String userPhone = request.getParameter("user_phone");
		String userEmail = request.getParameter("user_email");
		int size = Integer.parseInt(request.getParameter("size"));
//		String shrimp = request.getParameter("shrimp");
//		String sweet = request.getParameter("sweet");
//		String potato = request.getParameter("potato");
//		String pine = request.getParameter("pine");
		String[] toppingArr = request.getParameterValues("toppings");
		String deliveryTime = request.getParameter("delivery_time");
		
		System.out.printf("%s %s %s%n", userName, userPhone, userEmail);
		for (String topping : toppingArr)
			System.out.print(topping + " ");
		System.out.println();
		System.out.println(deliveryTime);
		
		String pizzaSize = "";
		int price = 0;
		switch (size) {
		case 1:
			pizzaSize = "스몰";
			price += 15900;
			break;
		case 2:
			pizzaSize = "미디움";
			price += 21000;
			break;
		case 3:
			pizzaSize = "라지";
			price += 27900;
			break;
		}
		
		List<String> toppingList = new ArrayList<String>();
		for (String str : toppingArr) {
			if (str != null) {
				if ("1".equals(str)) price += 2000;
				else price += 1000;
				switch (str) {
				case "1":
					toppingList.add("새우");
					break;
				case "2":
					toppingList.add("고구마");
					break;
				case "3":
					toppingList.add("감자");
					break;
				case "4":
					toppingList.add("파인애플");
					break;
				}
			}
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("views/pizza/result.jsp");
		request.setAttribute("userName", userName);
		request.setAttribute("userPhone", userPhone);
		request.setAttribute("userEmail", userEmail);
		request.setAttribute("pizzaSize", pizzaSize);
		request.setAttribute("toppingList", toppingList);
		request.setAttribute("price", price);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
