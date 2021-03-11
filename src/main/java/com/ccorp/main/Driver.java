package com.ccorp.main;

import com.ccorp.beans.Employee;
import com.ccorp.dao.Employee_ccorpDAO;
import com.ccorp.dao.Employee_ccorpDAOImpl;
import com.ccorp.service.Employee_ccorpService;
import com.ccorp.service.Employee_ccorpServiceImpl;

public class Driver {

	public static void main(String[] args) {
		System.out.println("MAIN METHOD CALLED");
		System.out.println("MAIN METHOD CALLED");
		System.out.println("MAIN METHOD CALLED");
		System.out.println("MAIN METHOD CALLED");
		Employee_ccorpDAO eccd= new Employee_ccorpDAOImpl();
		Employee_ccorpService eccs= new Employee_ccorpServiceImpl();
	
		String user="Minato";
		String pass="Yon";
		
		/*
		 * Employee emp = eccd.getEmployee(1); System.out.println(emp);
		 */
		System.out.println(eccd.Employeelogin(user, pass));
	}
	

}
