package com.ping.report;

import java.time.LocalDateTime;

public class Report {

	private String host;
	private String response;
	private LocalDateTime timeStamp;
	
	public Report(String host,String response, LocalDateTime timeStamp) {
		super();
		this.host = host;
		this.response = response;
		this.timeStamp = timeStamp;
	}
	public String getResponse() {
		return response;
	}
	public void setResponse(String response) {
		this.response = response;
	}
	public LocalDateTime getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(LocalDateTime timeStamp) {
		this.timeStamp = timeStamp;
	}
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	@Override
	public String toString() {
		return "Report [host=" + host + ", response=" + response + ", timeStamp=" + timeStamp + "]";
	}
	
}
