package com.ccorp.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;

import com.ccorp.beans.Employee;
import com.ccorp.beans.Request;
import com.ccorp.util.ConnectionUtility;



public class Employee_ccorpDAOImpl implements Employee_ccorpDAO{

	

	@Override
	public Employee getEmployee(int eid) {
		Employee emp = new Employee();
		try(Connection con = ConnectionUtility.getConnectionFromFile("C:\\Users\\Abesari\\kita\\ccorp\\src\\main\\resources\\connection.properties")) {
			String query = "SELECT * FROM EMPLOYEE";
			PreparedStatement stmt = con.prepareStatement(query);
			
			
			ResultSet rs=stmt.executeQuery();
			while (rs.next()) {
				int id=rs.getInt("eid");
				String name = rs.getString("name");
				String pass = rs.getString("pass");
				String email = rs.getString("EMAIL");
				int rank = rs.getInt("ranking");
				int repsto = rs.getInt("REPORTSTO");
				emp = new Employee(id, name, pass, email, rank, repsto);
		}
		}	 catch (SQLException | IOException e) {
			e.printStackTrace();	}
	
		return emp;
	}

	@Override
	public boolean Employeelogin(String name, String pass) {
		boolean x = false;
		try(Connection con = ConnectionUtility.getConnectionFromFile("C:\\Users\\Abesari\\kita\\ccorp\\src\\main\\resources\\connection.properties")) {
			String query = "SELECT * FROM LOGIN WHERE NAME=? AND PASS=?";
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setString(1, name);
			stmt.setString(2, pass);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				x=true;
			}
		}
		catch (SQLException | IOException e) {
			e.printStackTrace();
		}return x;
		}
		

	@Override
	public boolean isManager(int eid) {
		boolean man = false;
		try(Connection con = ConnectionUtility.getConnectionFromFile("C:\\Users\\Abesari\\kita\\ccorp\\src\\main\\resources\\connection.properties")) {
		String query = "SELECT RANKING FROM EMPLOYEE WHERE EID=?";
		PreparedStatement stmt = con.prepareStatement(query);
		stmt.setInt(1, eid);
		
		ResultSet rs= stmt.executeQuery();
		if(rs.getInt("RANKING")==1) {
			man=true;
		}
		
	}
	catch (SQLException | IOException e) {
		e.printStackTrace();
	}
		return man;
	}
	

	@Override
	public int getIdFromLogin(String name, String pass) {
		int x = 0;
		try(Connection con = ConnectionUtility.getConnectionFromFile("C:\\Users\\Abesari\\kita\\ccorp\\src\\main\\resources\\connection.properties")){
		String query = "SELECT EMP_ID FROM LOGIN WHERE NAME=? AND PASS=?";
		PreparedStatement stmt = con.prepareStatement(query);
		stmt.setString(1, name);
		stmt.setString(2, pass);
		ResultSet rs = stmt.executeQuery();
		rs.next();
		x=rs.getInt("EMP_ID");
	}
		catch (SQLException | IOException e) {
			e.printStackTrace();
		}
			return x;
		}

	@Override
	public void makeRequest(double amt, int day, int month, int year, int empId) {
		try(Connection con = ConnectionUtility.getConnectionFromFile("C:\\Users\\Abesari\\kita\\ccorp\\src\\main\\resources\\connection.properties")){
			String query = "INSERT INTO REQUEST (AMOUNT, DAY_OF, MONTH_OF, YEAR_OF, EMP_ID) VALUES (?,?,?,?,?)";
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setDouble(1, amt);;
			stmt.setInt(2, day);
			stmt.setInt(3, month);
			stmt.setInt(4, year);
			stmt.setInt(5, empId);

			
			stmt.executeUpdate();
			stmt.close();			
			
		}catch (SQLIntegrityConstraintViolationException reason ) { 
			String str="[ERROR] - please enter a valid date!";
			System.out.println(str);
		}
		catch (SQLException | IOException e) {
			e.printStackTrace();
		}		
		
	}

	@Override
	public ArrayList<Request> viewPending(int empid) {
		ArrayList <Request> li= new ArrayList<>();
		try(Connection con = ConnectionUtility.getConnectionFromFile("C:\\Users\\Abesari\\kita\\ccorp\\src\\main\\resources\\connection.properties")){
			String query = "Select * from Request WHERE EMP_ID=" + empid + "AND STATUS= 'PENDING'";
			PreparedStatement stmt = con.prepareStatement(query);
			ResultSet rs = stmt.executeQuery(query);
			


			
			while(rs.next()) {
				
				 int reqId = rs.getInt("REQ_NUM");
				 double amount = rs.getDouble("AMOUNT");
				 int day= rs.getInt("DAY_OF");
				 int month= rs.getInt("MONTH_OF");
				 int year= rs.getInt("YEAR_OF");
				 String stat=rs.getString("STATUS");
				 String ans=rs.getString("REQ_ANSWER");
				 int empId= rs.getInt("EMP_ID");
				 
				 li.add(new Request(reqId,amount,day,month,year,stat,ans,empId));
			}
			
		}
		catch (SQLException | IOException e) {
			e.printStackTrace();
		}		
	return li;
	}

	@Override
	public ArrayList<Request> viewResolved(int empid) {
		ArrayList <Request> li= new ArrayList<>();
		try(Connection con = ConnectionUtility.getConnectionFromFile("C:\\Users\\Abesari\\kita\\ccorp\\src\\main\\resources\\connection.properties")){
			String query = "Select * from Request Where EMP_ID= "+empid+" AND status='RESOLVED'";
			PreparedStatement stmt = con.prepareStatement(query);
			ResultSet rs = stmt.executeQuery(query);
			


			
			while(rs.next()) {
				
				 
				 int reqId = rs.getInt("REQ_NUM");
				 double amount = rs.getDouble("AMOUNT");
				 int day= rs.getInt("DAY_OF");
				 int month= rs.getInt("MONTH_OF");
				 int year= rs.getInt("YEAR_OF");
				 String stat=rs.getString("STATUS");
				 String ans=rs.getString("REQ_ANSWER");
				 int empId= rs.getInt("EMP_ID");
				 
				 li.add(new Request(reqId,amount,day,month,year,stat,ans,empId));
			}
			
		}
		catch (SQLException | IOException e) {
			e.printStackTrace();
		}		
	return li;
	}

	

	@Override
	public ArrayList<Request> viewAllRequests() {
		ArrayList <Request> li= new ArrayList<>();
		try(Connection con = ConnectionUtility.getConnectionFromFile("C:\\Users\\Abesari\\kita\\ccorp\\src\\main\\resources\\connection.properties")){
			String query = "Select * from Request";
			PreparedStatement stmt = con.prepareStatement(query);
			ResultSet rs = stmt.executeQuery(query);
			


			
			while(rs.next()) {
				
				 
				 int reqId = rs.getInt("REQ_NUM");
				 double amount = rs.getDouble("AMOUNT");
				 int day= rs.getInt("DAY_OF");
				 int month= rs.getInt("MONTH_OF");
				 int year= rs.getInt("YEAR_OF");
				 String stat=rs.getString("STATUS");
				 String ans=rs.getString("REQ_ANSWER");
				 int empId= rs.getInt("EMP_ID");
				 
				 li.add(new Request(reqId,amount,day,month,year,stat,ans,empId));
			}
			
		}
		catch (SQLException | IOException e) {
			e.printStackTrace();
		}		
	return li;
	}

	@Override
	public ArrayList<Employee> viewAllEmployeesInfo() {
		ArrayList<Employee> li= new ArrayList<>();
		System.out.println("testing");
		try(Connection con = ConnectionUtility.getConnectionFromFile("C:\\Users\\Abesari\\kita\\ccorp\\src\\main\\resources\\connection.properties")){
		String query = "SELECT * FROM EMPLOYEE";
		PreparedStatement stmt = con.prepareStatement(query);
		
		ResultSet rs=stmt.executeQuery();
		while (rs.next()) {
			int eid=rs.getInt("eid");
			String name = rs.getString("NAME");
			String pass = rs.getString("PASS");
			String email = rs.getString("EMAIL");
			int rank = rs.getInt("IS_MANAGER");
			int repsto = rs.getInt("REPORTSTO");
			 li.add(new Employee(eid, name, pass, email, rank, repsto));
		} 
}
	catch (SQLException | IOException e) {
		e.printStackTrace();
	}		
		return li;
	}

	@Override
	public Employee viewMyInfo(int eid) {
		Employee emp = new Employee();
		
		try(Connection con = ConnectionUtility.getConnectionFromFile("C:\\Users\\Abesari\\kita\\ccorp\\src\\main\\resources\\connection.properties")){
			String query = "SELECT * FROM EMPLOYEE where EID="+eid;
			PreparedStatement stmt = con.prepareStatement(query);
			
			ResultSet rs=stmt.executeQuery();
			while (rs.next()) {
				int id=rs.getInt("eid");
				String name = rs.getString("NAME");
				String pass = rs.getString("PASS");
				String email = rs.getString("EMAIL");
				int rank = rs.getInt("IS_MANAGER");
				int repsto = rs.getInt("REPORTSTO");
				 emp= (new Employee(id, name, pass, email, rank, repsto));
				 
			} 
	}
		catch (SQLException | IOException e) {
			e.printStackTrace();
		}		
			
		
		
		return emp;
		
	}

	@Override
	public void RespondtoRequest(String answer, int reqId) {
		try(Connection con = ConnectionUtility.getConnectionFromFile("C:\\Users\\Abesari\\kita\\ccorp\\src\\main\\resources\\connection.properties")){
			String query="UPDATE REQUEST SET STATUS= 'RESOLVED', REQ_ANSWER= ? WHERE REQ_NUM= ?";

			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setString(1, answer);
			stmt.setInt(2, reqId);

			

			stmt.executeUpdate();
			
			
		}
		catch (SQLException | IOException e) {
			e.printStackTrace();
		}
		
		
		
		

		}
	

	@Override
	public boolean YouManageThatEmployee(int empid, int manId) {
		boolean x=false;
		try(Connection con = ConnectionUtility.getConnectionFromFile("C:\\Users\\Abesari\\kita\\ccorp\\src\\main\\resources\\connection.properties")){
			String query = "Select * from employee WHERE EID="+empid+"AND REPTSTO ="+manId;
			PreparedStatement stmt = con.prepareStatement(query);
			ResultSet rs = stmt.executeQuery(query);
			
			if(rs.next()) {
				x=true;
				 
			}
			
		}
		catch (SQLException | IOException e) {
			e.printStackTrace();
		}
		
		
		
		
		return x;
				
	}
	

	@Override
	public int getEmpIdFromReqNum(int reqNum) {
		int x=0;
		try(Connection con = ConnectionUtility.getConnectionFromFile("C:\\Users\\Abesari\\kita\\ccorp\\src\\main\\resources\\connection.properties")){
			String query = "Select EMP_ID from REQUEST WHERE REQ_NUM="+reqNum;
			PreparedStatement stmt = con.prepareStatement(query);
			ResultSet rs = stmt.executeQuery(query);
			if(rs.next()) {
			x=rs.getInt("EMP_ID");
			}
		}
		catch (SQLException | IOException e) {
			e.printStackTrace();
		}		return x;
	}
		
	
}
