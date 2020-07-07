package com.ping;


import com.ping.icmp.ICMPRequest;
import com.ping.tcp.TCPRequest;
import com.ping.trace.TraceRequest;

public class PingThread implements Runnable {

	private String host;
	private int noOfTimesHit;
	private String protocal;

	public PingThread() {
		super();
	}

	public PingThread(String host, int noOfTimesHit, String protocal) {
		super();
		this.host = host;
		this.noOfTimesHit = noOfTimesHit;
		this.protocal = protocal;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public int getNoOfTimesHit() {
		return noOfTimesHit;
	}

	public void setNoOfTimesHit(int noOfTimesHit) {
		this.noOfTimesHit = noOfTimesHit;
	}

	public String getProtocal() {
		return protocal;
	}

	public void setProtocal(String protocal) {
		this.protocal = protocal;
	}

	@Override
	public void run() {
		ICMPRequest icmpRequest = new ICMPRequest();
		TCPRequest tcpRequest = new TCPRequest();
		TraceRequest traceRequest = new TraceRequest();
		if (this.protocal.equalsIgnoreCase("ICMP")) {
			icmpRequest.icmpRequest(this.host);
		} else if (this.protocal.equalsIgnoreCase("TCP")) {
			tcpRequest.tcpRequest(this.host);
		} else {
			traceRequest.traceRequest(this.host);
		}
	}
}
