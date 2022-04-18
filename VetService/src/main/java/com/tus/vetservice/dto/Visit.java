package com.tus.vetservice.dto;

import java.time.LocalDate;

public class Visit {
private int visitId;
	
	private LocalDate date;
	private String description;
	public int getVisitId() {
		return visitId;
	}
	public void setVisitId(int visitId) {
		this.visitId = visitId;
	}
	public Visit(int visitId, LocalDate date, String description) {
		super();
		this.visitId = visitId;
		this.date = date;
		this.description = description;
	}
	public Visit()
	{
		
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

}
