package com.spring.deptvo;

public class DeptVO {
	private String deptid=""; // 학과코드
	private String deptname=""; // 학과명
	private String depttel=""; // 학과전화

	public String getDeptid() {
		return deptid;
	}

	public String getDeptname() {
		return deptname;
	}

	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}

	public String getDepttel() {
		return depttel;
	}

	public void setDepttel(String depttel) {
		this.depttel = depttel;
	}

	public void setDeptid(String deptid) {
		this.deptid = deptid;
	}
	
}
