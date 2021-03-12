package com.ccorp.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ccorp.service.Employee_ccorpService;
import com.ccorp.service.Employee_ccorpServiceImpl;


public class LoginCheckServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Employee_ccorpService eccs = new Employee_ccorpServiceImpl();

	
	public LoginCheckServlet() {
		super();
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("Good job for logging in!");
		request.getRequestDispatcher("ccorp.html").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		
		if (eccs.Employeelogin(request.getParameter("name"), request.getParameter("pass")) == true) {
			System.out.println("working");
			session.setAttribute("emp_id", eccs.getIdFromLogin(request.getParameter("name"), request.getParameter("pass")));
			response.sendRedirect("requests.html");
		} else {
			response.sendRedirect("denied.html");
		}
		
	}
	
}
