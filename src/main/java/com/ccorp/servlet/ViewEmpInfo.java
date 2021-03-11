package com.ccorp.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ccorp.beans.Employee;
import com.ccorp.service.Employee_ccorpService;
import com.ccorp.service.Employee_ccorpServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet("/ViewMyInfo")
public class ViewEmpInfo extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	 public ViewEmpInfo() {
	        super();
	        // TODO Auto-generated constructor stub
	    }
	 
	 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 Employee_ccorpService eccs = new Employee_ccorpServiceImpl();
		 HttpSession session=request.getSession(false);
		 int user= Integer.parseInt(session.getAttribute("emp_id").toString());
		 Employee emp = eccs.viewMyInfo(user);
		 
		 String resp = (new ObjectMapper()).writeValueAsString(emp);
			response.getWriter().write(resp);
	 }
	 
	 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub
			doGet(request, response);
		}

	 
}
