package com.ccorp.service;

import java.util.ArrayList;

import com.ccorp.beans.Employee;
import com.ccorp.beans.Request;
import com.ccorp.dao.Employee_ccorpDAO;
import com.ccorp.dao.Employee_ccorpDAOImpl;

public class Employee_ccorpServiceImpl implements Employee_ccorpService {
	
	private Employee_ccorpDAO eccd = new Employee_ccorpDAOImpl();

	public boolean Employeelogin(String name, String pass) {
		return eccd.Employeelogin(name, pass);
	}

	public boolean isManager(int eid) {
		// TODO Auto-generated method stub
		return eccd.isManager(eid);
	}

	public int getIdFromLogin(String name, String pass) {
		// TODO Auto-generated method stub
		return eccd.getIdFromLogin(name, pass);
	}

	@Override
	public void makeRequest(double amt, int day, int month, int year, int empId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<Request> viewPending(int empid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Request> viewResolved(int empid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Request> viewAllRequests() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Employee> viewAllEmployeesInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee viewMyInfo(int empid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void RespondtoRequest(String answer, int reqId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean YouManageThatEmployee(int empid, int manId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getEmpIdFromReqNum(int reqNum) {
		// TODO Auto-generated method stub
		return 0;
	}

}
