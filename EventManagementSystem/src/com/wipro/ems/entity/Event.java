package com.wipro.ems.entity;

import java.time.LocalDate;

public class Event {
 
	 private String eventId;
	 private String name ;
	 private String venue;
	 private LocalDate date;
	 private String description;
	 
	 
	 public Event(String eventId, String name, String venue, LocalDate date, String description) {
		this.eventId=eventId;
		this.name=name;
		this.venue=venue;
		this.date=date;
		this.description=description;
	}

	public void setEventId(String eventId) {
		 this.eventId=eventId;
	 }
	 
	 public String getEventId() {
		 return eventId;
	 }
	 
	 public void setName(String name) {
		 this.name=name;
	 }
	 
	 public String getName() {
		 return name;
	 }
	 
	 public void setVenue(String venue) {
		 this.venue=venue;
	 }
	 
	 public String getVenue() {
		 return venue;
	 }
	 
	 public void setDate(LocalDate date) {
		 this.date=date;
	 }
	 
	 public LocalDate getDate() {
		 return date;
	 }
	
	 public void setDescription(String description) {
		 this.description=description;
	 }
	 
	 public String getDescription() {
		 return description;
	 }
	
	 
	
	 
	
}
