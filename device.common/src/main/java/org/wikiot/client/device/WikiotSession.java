package org.wikiot.client.device;

import java.io.IOException;
import java.net.URI;
import java.security.Principal;
import java.util.Map;

public interface WikiotSession<T> {

	public String getId();

	public URI getUri();

	public Map<String, Object> getAttributes();

	public Principal getPrincipal();

	public String getLocalAddress();

	public String getRemoteAddress();

	public String getProtocol();

	public void sendMessage(WikiotMessage message) throws IOException;

	public boolean isOpen();

	public void close() throws IOException;
	
	public T getNativeSession();

}
