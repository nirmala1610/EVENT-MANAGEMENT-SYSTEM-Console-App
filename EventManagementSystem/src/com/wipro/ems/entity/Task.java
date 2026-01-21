package com.wipro.ems.entity;

public class Task {

	 private String taskId;
	 private String eventId;
	 private String taskname ;
	 private String assignedStaffId;
	 private TaskStatus  status;
	 private int estimatedHours ;
	 
	 public Task(String taskId, String eventId, String taskname, String assignedStaffId, TaskStatus  status, int estimatedHours) {
         this.taskId=taskId;
         this.eventId=eventId;
         this.assignedStaffId=assignedStaffId;
         this.status=status;
         this.estimatedHours=estimatedHours;
	}

	public void setTaskId(String taskId) {
		 this.taskId=taskId;
	 }
	 
	 public String getTaskId() {
		 return taskId;
	 }
	 
	 public void setEventId(String eventId) {
		 this.eventId=eventId;
	 }
	 
	 public String getEventId() {
		 return eventId;
	 }
	 
	 public void setTaskName(String taskname) {
		 this.taskname=taskname;
	 }
	 
	 public String getTaskName() {
		 return taskname;
	 }
	 
	 public void setAssignedStaffId(String assignedStaffId) {
		 this.assignedStaffId=assignedStaffId;
	 }
	 
	 public String getAssignedStaffId() {
		 return assignedStaffId;
	 }
	 
	 public void setStatus(TaskStatus  status) {
		 this.status=status;
	 }
	 
	 public TaskStatus  getStatus() {
		 return status;
	 }
	
	 public void setEstimatedHours(int estimatedHours) {
		 this.estimatedHours=estimatedHours;
	 }
	 
	 public int getEstimatedHours() {
		 return estimatedHours;
	 }
}
