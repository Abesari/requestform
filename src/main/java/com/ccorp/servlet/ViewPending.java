package com.ccorp.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ccorp.beans.Request;
import com.ccorp.service.Employee_ccorpService;
import com.ccorp.service.Employee_ccorpServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;


@WebServlet("/viewpending")
public class ViewPending extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;



	public ViewPending() {
        super();
        // TODO Auto-generated constructor stub
    }


	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Employee_ccorpService s = new Employee_ccorpServiceImpl();
		HttpSession session=request.getSession(false);
		int user= Integer.parseInt(session.getAttribute("emp_id").toString());
		ArrayList<Request> list= s.viewPending(user);
		
		String resp = (new ObjectMapper()).writeValueAsString(list);
		response.getWriter().write(resp);
		
		
		//response.getWriter().write(om.writeValueAsString(s.viewResolved(user)));
		//s.viewResolved(user)
		//response.getWriter().write((new ObjectMapper()).writeValueAsString(u));
		
	
	}
}
