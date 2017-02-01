package org.wikiot.io;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;

public class Util {
	
	public static String getMacAddress(){
		try {
			InetAddress address = InetAddress. getLocalHost();
			NetworkInterface nwi = NetworkInterface. getByInetAddress(address);
			byte mac[] = nwi. getHardwareAddress();
			return new String(mac);
		} catch (UnknownHostException | SocketException e) {
			e.printStackTrace();
			return null;
		}
	}

}
