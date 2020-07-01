package com.ping;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class PingThread implements Runnable {

	@Override
	public void run() {
		InetAddress geek;
		try {
			geek = InetAddress.getByName("jasmin.com");

			System.out.println("Sending Ping Request to " + "ssd.com");
			if (geek.isReachable(5000))
				System.out.println("Host is reachable");
			else
				System.out.println("Sorry ! We can't reach to this host");
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
