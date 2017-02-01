package org.wikiot.client.device;

public interface OnAfterConnectionClosed {
	
	public void afterConnectionClosed(Device device, String reason, Exception e);

}
