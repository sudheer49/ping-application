package com.ping;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.Scanner;

import com.ping.report.Result;

public class PingApplication {

	public static void main(String[] args) throws UnknownHostException, IOException, InterruptedException {
		enableCommand();
	}

	public static void enableCommand() throws UnknownHostException, IOException, InterruptedException {
		Scanner myCmd = new Scanner(System.in);
		System.out.println("Enter ping command :");
		String pingCommand = myCmd.nextLine();
		String[] pingArray = pingCommand.split(" ");
		int noOfTimesHit =  Integer.parseInt(pingArray[3]);
		String host = pingArray[4];
		sendPingRequest(host,noOfTimesHit,pingArray[0]);
		enableCommand();
	}
	// Sends ping request to a provided IP address 
	  public static void sendPingRequest(String host,int noOfTimesHit,String protocal) 
	              throws UnknownHostException, IOException, InterruptedException 
	  { 
		  
		for(int i=0;i<noOfTimesHit;i++) {
			Thread th = new Thread(new PingThread(host,noOfTimesHit,protocal));
			th.start();
			Thread.sleep(3000); // TO-do :this is delay, Should moved to config file 
		}
		System.out.println(Result.result);
	  }
	  
	  
}
