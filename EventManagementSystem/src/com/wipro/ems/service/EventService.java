package com.wipro.ems.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.wipro.ems.entity.Event;
import com.wipro.ems.entity.Staff;
import com.wipro.ems.entity.Task;
import com.wipro.ems.entity.TaskStatus;
import com.wipro.ems.entity.TaskUpdate;

import com.wipro.ems.util.*;

public class EventService{

	private ArrayList<Event> events;
	private ArrayList<Task> tasks;
	private ArrayList<Staff> staffList;
	private ArrayList<TaskUpdate> updates;

	public EventService(ArrayList<Event> events,ArrayList<Task> tasks, ArrayList<Staff> staffList,ArrayList<TaskUpdate> updates) {
		this.setEvents(events);
		this.setTasks(tasks);
		this.setStaffList(staffList);
		this.setUpdates(updates);	
	}

	public ArrayList<Event> getEvents() {
		return events;
	}

	public void setEvents(ArrayList<Event> events) {
		this.events = events;
	}

	public ArrayList<Task> getTasks() {
		return tasks;
	}

	public void setTasks(ArrayList<Task> tasks) {
		this.tasks = tasks;
	}

	public ArrayList<Staff> getStaffList() {
		return staffList;
	}

	public void setStaffList(ArrayList<Staff> staffList) {
		this.staffList = staffList;
	}

	public ArrayList<TaskUpdate> getUpdates() {
		return updates;
	}

	public void setUpdates(ArrayList<TaskUpdate> updates) {
		this.updates = updates;
	}
	
    public void addEvent(Event e) {
		if(e != null) {
			events.add(e);
			System.out.println("Event Registerd :" + e.getName() + "at" + e.getVenue() + "On" + e.getDate());
		}
		else {
			System.out.print("Provide a Valid data");
		}
	}
	
	public Event findEvent(String eventId) throws EventNotFoundException{
		for(Event e : events) {
			if(e.getEventId().equals(eventId)) {
				return e;
			}
		}
		throw new EventNotFoundException("Event Not Found");
	}
    
	public void addTask(Task t) throws EventNotFoundException{
		
		Event event = findEvent(t.getEventId());
		
		 if(event == null) {
			 throw new EventNotFoundException("Event Not found");
		 }
		 
		 if(t.getEstimatedHours()<=0) {
			 System.out.println("Not A valid time");
		 }
		 t.setStatus(TaskStatus.PENDING);
		 
	}
	
	public Task findTask(String taskId) throws TaskNotFoundException {
		
		for(Task task : tasks) {
			if(task.getTaskId().equals(taskId));
			   return task;
		}
		
		throw new TaskNotFoundException("Task Not Found");
	}
	
	public void assignStaffToTask(String taskId,String staffId) throws TaskNotFoundException,InvalidTaskOperationException{
		
		Task task = findTask(taskId);
		
		if(task.getAssignedStaffId() != null) {
			throw new TaskNotFoundException("Task Already Assigned to other staff member");
		}
		
		task.setAssignedStaffId(staffId);
		task.setStatus(TaskStatus.IN_PROGRESS);
	}
	
	public void updateTaskStatus(String taskId,String newStatus) throws TaskNotFoundException,InvalidTaskOperationException{
		
		Task task = findTask(taskId); 

	    TaskStatus currentStatus = task.getStatus();
	    TaskStatus updatedStatus;
	    try {
	        updatedStatus = TaskStatus.valueOf(newStatus.toUpperCase());
	    } catch (IllegalArgumentException e) {
	        throw new InvalidTaskOperationException("Invalid task status");
	    }
	    if (currentStatus == TaskStatus.COMPLETED && updatedStatus == TaskStatus.PENDING) {
	        throw new InvalidTaskOperationException("Cannot change status from COMPLETED to PENDING");
	    }
	    task.setStatus(updatedStatus);
	}
	
	public void recordTaskUpdate(String updateId, String taskId, String date, String notes)throws TaskNotFoundException, InvalidTaskOperationException {

	    if(notes == null || notes.trim().isEmpty()) {
	        throw new InvalidTaskOperationException("Update notes cannot be empty");
	    }
	    
	    TaskUpdate update = new TaskUpdate(updateId,taskId,date,notes);

	    updates.add(update);
	    
	}
	
	public ArrayList<Task> getTasksForEvent(String eventId){
		ArrayList<Task> eventTask = new ArrayList<>();
		
		for(Task task : tasks) {
			if(task.getEventId().equals(eventId)) {
				eventTask.add(task);
			}
		}
		return eventTask;
	}
	
	public String generateEventSummary(String eventId) {
		    
		    int totalTasks = 0;
		    int completedTasks = 0;
		    int pendingTasks = 0;
		    
		    Set<String> assignedStaff = new HashSet<>();
		    List<String> criticalUpdates = new ArrayList<>();
		    
		    for (Task task : tasks) {
		        if (task.getEventId().equals(eventId)) {
		            totalTasks++;

		            if (task.getStatus() == TaskStatus.COMPLETED) {
		                completedTasks++;
		            } else {
		                pendingTasks++;
		            }

		            if (task.getAssignedStaffId() != null) {
		                assignedStaff.add(task.getAssignedStaffId());
		            }
		        }
		    }
		    
		    for (TaskUpdate update : updates) {
		        if (update.getTaskId().startsWith(eventId) &&
		            update.getNotes().toLowerCase().contains("delay")) {
		            criticalUpdates.add(update.getNotes());
		        }
		    }
		    
		    return "Event Summary Report\n" +
	           "----------------------\n" +
	           "Event ID: " + eventId + "\n" +
	           "Total Tasks: " + totalTasks + "\n" +
	           "Completed Tasks: " + completedTasks + "\n" +
	           "Pending Tasks: " + pendingTasks + "\n" +
	           "Assigned Staff Count: " + assignedStaff.size() + "\n" +
	           "Critical Updates: " + criticalUpdates.size() + "\n";     
		
	}	
	
}
