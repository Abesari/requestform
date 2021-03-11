package com.ccorp.dao;

import java.util.ArrayList;

import com.ccorp.beans.Employee;
import com.ccorp.beans.Request;

public interface Employee_ccorpDAO {
	
	public Employee getEmployee(int eid);
	public boolean Employeelogin(String name, String pass);
	public boolean isManager(int eid);
	public int getIdFromLogin(String name, String pass);
	public void makeRequest(double amt, int day, int month, int year, int empId);
	public ArrayList<Request> viewPending(int empid);
	public ArrayList<Request> viewResolved(int empid);
	public Employee viewMyInfo(int empid);
	
	
	public ArrayList<Request> viewAllRequests();
	public ArrayList<Employee> viewAllEmployeesInfo();
	public void RespondtoRequest(String answer,int reqId);
	public boolean YouManageThatEmployee(int empid, int manId);
	public int getEmpIdFromReqNum (int reqNum);

}
