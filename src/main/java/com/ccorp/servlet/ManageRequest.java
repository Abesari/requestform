package com.ccorp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ccorp.service.Employee_ccorpService;
import com.ccorp.service.Employee_ccorpServiceImpl;



@WebServlet("/ManageRequest")
public class ManageRequest extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	 public ManageRequest() {
	        super();
	        // TODO Auto-generated constructor stub
	    }
	 
	 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			request.getRequestDispatcher("Emphome.html").forward(request, response);
		}
	 
	 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			Employee_ccorpService s = new Employee_ccorpServiceImpl();
			HttpSession session=request.getSession(false);
			
			
			
			int manId= Integer.parseInt(session.getAttribute("emp_id").toString());
			if(s.isManager(manId)) {
				String answer=request.getParameter("response").toString();
				
				
				int reqNum=Integer.parseInt(request.getParameter("reqnum").toString());
				int empId=s.getEmpIdFromReqNum(reqNum);
				
				if(s.YouManageThatEmployee(empId, manId)) {
					s.RespondtoRequest(answer, reqNum);
					PrintWriter out = response.getWriter();
					out.println("Your Response has been recorded!");
					
				}
				
				
			}
		
			
			
			
			
			//s.makeRequest(amt, day, month, year, empId);
			System.out.println("request made!");
			response.sendRedirect("profile");
		}
}
