package com.dreamydiary.myapp.dd.model;

public class EventVO {
	private String userId;
	private String title;
	private String start;
	private String end;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getStart() {
		return start;
	}
	public void setStart(String start) {
		this.start = start;
	}
	public String getEnd() {
		return end;
	}
	public void setEnd(String end) {
		this.end = end;
	}
	@Override
	public String toString() {
		return "EventVO [userId=" + userId + ", title=" + title + ", start=" + start + ", end=" + end + "]";
	}
	

}
