package com.ping.tcp;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDateTime;

import com.ping.report.Report;
import com.ping.report.Result;

public class TCPRequest {

	public void tcpRequest(String host) {
		String response = "";
		HttpURLConnection con = null;
		int statusCode = 200;
		try {
			URL url = new URL("https://" + host);
			con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("Content-Type", "application/json");
			con.setConnectTimeout(5000);
			con.setReadTimeout(5000);
			response = con.getResponseMessage();
			statusCode = con.getResponseCode();
		} catch (Exception ex) {
			response = "Exception :" + ex.getMessage();
		}
		Report report = new Report(host,response, LocalDateTime.now());
		Result.updateResult("TCP", report);
		if (statusCode != 200 || response.contains("Exception")) {
			// log code
			Result.logUpdate();
			System.out.println("Some error while executing TCP request, Please check log");
		}
	}
}
