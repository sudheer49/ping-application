package com.ping.icmp;

import java.time.LocalDateTime;

import com.ping.report.Report;
import com.ping.report.Result;
import com.ping.trace.TraceRequest;

public class ICMPRequest {

	public void icmpRequest(String host) {
		String response = "";
		try {
			Process pingProcess;
			pingProcess = Runtime.getRuntime().exec("ping -n 1 " + host);
			response = TraceRequest.convertStreamToString(pingProcess.getInputStream());
		} catch (Exception ex) {
			response = "Exception :"+ex.getMessage();
		}
		Report report = new Report(host,response, LocalDateTime.now());
		Result.updateResult("ICMP", report);
		
		if(response.contains("Exception") || !response.contains("Lost = 0")) {
			//log code
			Result.logUpdate();
			System.out.println("Some error while executing ICMP command, Please check log");
		}
	}
}
