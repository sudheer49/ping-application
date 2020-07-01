package com.ping;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.Scanner;

public class PingApplication {

	public static void main(String[] args) throws UnknownHostException, IOException, InterruptedException {
		Scanner myCmd = new Scanner(System.in);
		System.out.println("Enter ping command :");
		String pingCommand = myCmd.nextLine();
		String[] pingArray = pingCommand.split(" ");
		int noOfTimesHit =  Integer.parseInt(pingArray[2]);
		String host = pingArray[3];
		sendPingRequest(noOfTimesHit,host);
	}

	// Sends ping request to a provided IP address 
	  public static void sendPingRequest(int noOfTimesHit,String ipAddress) 
	              throws UnknownHostException, IOException, InterruptedException 
	  { 
		  
		for(int i=0;i<noOfTimesHit;i++) {
			Thread th = new Thread(new PingThread());
			th.start();
			Thread.sleep(3000); // TO-do :this is delay, Shoudl moved to config file 
		}
	  }
}
