package com.wipro.ems.entity;

public class TaskUpdate {
	
	 private String updateId ;
	 private String taskId;
	 private String date;
	 private String notes;
	 
	public TaskUpdate(String updateId, String taskId, String date, String notes) {
		this.updateId=updateId;
		this.taskId=taskId;
		this.date=date;
		this.notes=notes;	
	}
	public String getUpdateId() {
		return updateId;
	}
	public void setUpdateId(String updateId) {
		this.updateId = updateId;
	}
	public String getTaskId() {
		return taskId;
	}
	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	 
	 

}
