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

@WebServlet("/ReimbursmentRequest")
public class ReimbursementRequest extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ReimbursementRequest() {
        super();
        // TODO Auto-generated constructor stub
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("Requests.html").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Employee_ccorpService eccs = new Employee_ccorpServiceImpl();
		HttpSession session=request.getSession(false);
		int empId= Integer.parseInt(session.getAttribute("emp_id").toString());
		double amt= Double.parseDouble(request.getParameter("amt").toString());
		int day= Integer.parseInt(request.getParameter("day").toString());
		int month= Integer.parseInt(request.getParameter("month").toString());
		int year= Integer.parseInt(request.getParameter("year").toString());
		eccs.makeRequest(amt, day, month, year, empId);
		System.out.println("request has been made!");
		response.sendRedirect("profile");
}
}
