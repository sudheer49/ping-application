package com.ping.trace;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.LocalDateTime;

import com.ping.report.Report;
import com.ping.report.Result;

public class TraceRequest {

	public void traceRequest(String host) {
		String route = "";
		 try {
		        Process traceRt;
		        traceRt = Runtime.getRuntime().exec("tracert " + host);
		        route = convertStreamToString(traceRt.getInputStream());
		    }
		    catch (Exception ex) {
		    	route = "error while performing trace route command "+ex.getMessage();
		    }
		 	Report report = new Report(host,route,LocalDateTime.now());
			Result.updateResult("TRACE", report);
	}

	public static String convertStreamToString(InputStream inputStream) throws IOException {
		InputStreamReader isReader = new InputStreamReader(inputStream);
		BufferedReader reader = new BufferedReader(isReader);
	      StringBuffer sb = new StringBuffer();
	      String str;
	      while((str = reader.readLine())!= null){
	         sb.append(str);
	      }
		return sb.toString();
	}
}
