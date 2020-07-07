package com.ping.report;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class Result {

	private static final Logger LOGGER = Logger.getLogger(Result.class.getName());
	public static Map<String,Report> result = new HashMap<>();
	
	public static void updateResult(String key,Report report) {
		result.put(key, report);
	}	
	
	public static void logUpdate() {
		//LOGGER.warning(report.toString());
	}
}
