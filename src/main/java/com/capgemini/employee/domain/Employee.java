package com.capgemini.employee.domain;


public class Employee {
	
	private String empID;
	private String empName;
	private int	age;
	private String officeName;
	private String address;
	private String mobileNo;
	
	//Getters and Setters for all the Fields
	
	public String getEmpID() {
		return empID;
	}
	public void setEmpID(String empID) {
		this.empID = empID;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getOfficeName() {
		return officeName;
	}
	public void setOfficeName(String officeName) {
		this.officeName = officeName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	
	//All Args Constructer
	
	public Employee(String empID, String empName, int age, String officeName, String address, String mobileNo) {
		super();
		this.empID = empID;
		this.empName = empName;
		this.age = age;
		this.officeName = officeName;
		this.address = address;
		this.mobileNo = mobileNo;
	}
	
	//No Args Constructer
	public Employee() {
		super();
	}
	
	
	
	
	

}
