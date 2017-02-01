package org.wikiot.client.device;

import java.io.IOException;

import org.wikiot.io.UpStreamMessage;

public interface WikiotTransportLayer {

	public boolean sendRequest(UpStreamMessage request);

	public WikiotTransportLayer addDownStreamMessageListener(DownStreamMessageListener listener);

	public WikiotTransportLayer addOnDisconnectedListener(OnDisconnectedListener handler);

	public WikiotTransportLayer addOnConnectedListener(OnConnectedListener listener);

	public WikiotTransportLayer addOnOpenListener(OnOpenListener listener);

	public WikiotTransportLayer addOnConnectionErrorListener(OnErrorListener listener);

	public WikiotTransportLayer addAfterConnectionClosedListener(OnAfterConnectionClosed listener);

	public boolean isConnected();

	public WikiotTransportLayer disconnect() throws IOException;

	public WikiotTransportLayer connect();

	public Device getDevice();
	
	public void setHost(String host);
	
	public void setPath(String path);

}
