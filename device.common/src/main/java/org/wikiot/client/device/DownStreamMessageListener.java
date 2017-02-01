package org.wikiot.client.device;

import org.wikiot.io.DownStreamMessage;

public interface DownStreamMessageListener {
	
	public void onMessage(DownStreamMessage message);

}
