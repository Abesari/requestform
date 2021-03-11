package com.ccorp.beans;

public class Employee {
	public Employee() {
		super();
	}
	public Employee(int eid, String name, String pass, String email, int rank, int repsto) {
		this.eid=eid;
		this.name=name;
		this.pass=pass;
		this.email=email;
		this.rank=rank;
		this.repsto=repsto;
	}
	private int eid;
	private String name;
	private String pass;
	private String email;
	private int rank;
	private int repsto;
	
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	public int getRepsto() {
		return repsto;
	}
	public void setRepsto(int repsto) {
		this.repsto = repsto;
	}
	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", name=" + name + ", pass=" + pass + ", email=" + email + ", rank=" + rank
				+ ", repsto=" + repsto + "]";
	}
	
}
