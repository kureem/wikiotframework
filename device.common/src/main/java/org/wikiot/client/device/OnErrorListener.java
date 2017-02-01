package org.wikiot.client.device;

public interface OnErrorListener {
	
	public void onError(Device device, Throwable t, String message);

}
