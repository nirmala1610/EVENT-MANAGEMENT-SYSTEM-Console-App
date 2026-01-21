package com.wipro.ems.entity;

public class Staff {

	private String staffId;
	private String name;
	private String role;
	
	public Staff(String staffId, String name, String role) {
		this.staffId=staffId;
		this.name=name;
		this.role=role;
	}

	public void setStaffId(String staffId) {
		 this.staffId=staffId;
	 }
	 
	 public String getStaffId() {
		 return staffId;
	 }
	 
	 public void setName(String name) {
		 this.name=name;
	 }
	 
	 public String getName() {
		 return name;
	 }
	 
	 public void setRole(String role) {
		 this.role=role;
	 }
	 
	 public String getRole() {
		 return role;
	 }
	
}
