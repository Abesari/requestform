package com.ccorp.beans;

public class Request {
	public Request() {
		super();
	}
	public Request(	double amount,  int day,  int month, int year) {
		super();
		this.amount=amount;
		this.day=day;
		this.month=month;
		this.year=year;
		
	}
	public Request(double amount, int day, int month, int year, int empId) {
		super();
		this.amount=amount;
		this.day=day;
		this.month=month;
		this.year=year;
		this.empId=empId;
	}
	
	private int reqId;
	private double amount;
	private int day;
	private int month;
	private int year;
	private String status;
	private String reqAns;
	private int empId;
	
	
	
	@Override
	public String toString() {
		return "Request [reqId=" + reqId + ", amount=" + amount + ", day=" + day + ", month=" + month + ", year=" + year
				+ ", status=" + status + ", reqAns=" + reqAns + ", empId=" + empId + "]";
	}
	public Request(	 int reqId,  double amount,  int day,  int month,	 int year,	String status,	 String reqAns,  int empId) {
		super();
		this.reqId=reqId;
		this.amount=amount;
		this.day=day;
		this.month=month;
		this.year=year;
		this.status=status;
		this.reqAns=reqAns;
		this.empId=empId;
	}
	
	public int getReqId() {
		return reqId;
	}
	public void setReqId(int reqId) {
		this.reqId = reqId;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getReqAns() {
		return reqAns;
	}
	public void setReqAns(String reqAns) {
		this.reqAns = reqAns;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
}
