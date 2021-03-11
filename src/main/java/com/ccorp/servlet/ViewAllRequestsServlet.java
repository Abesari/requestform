package com.ccorp.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.ccorp.beans.Request;
import com.ccorp.service.Employee_ccorpService;
import com.ccorp.service.Employee_ccorpServiceImpl;



@WebServlet("/ViewAllRequests")
public class ViewAllRequestsServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	 public ViewAllRequestsServlet() {
	        super();
	        // TODO Auto-generated constructor stub
	    }

	 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 Employee_ccorpService eccs = new Employee_ccorpServiceImpl();
			HttpSession session=request.getSession(false);
			
			int user= Integer.parseInt(session.getAttribute("emp_id").toString());
			
			if(eccs.isManager(user)) {
				ArrayList<Request> list= eccs.viewAllRequests();
				
				String resp = (new ObjectMapper()).writeValueAsString(list);
				response.getWriter().write(resp);
			}
}
	 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub
			doGet(request, response);
		}
	 
}
