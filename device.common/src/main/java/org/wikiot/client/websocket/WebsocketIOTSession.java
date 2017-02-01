package org.wikiot.client.websocket;

import java.io.IOException;
import java.net.URI;
import java.security.Principal;
import java.util.Map;

import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.wikiot.client.device.WikiotMessage;
import org.wikiot.client.device.WikiotSession;

public class WebsocketIOTSession implements WikiotSession<WebSocketSession> {

	private WebSocketSession session;
	
	

	public WebsocketIOTSession(WebSocketSession session) {
		this.session = session;
	}

	@Override
	public String getId() {

		return session.getId();
	}

	@Override
	public URI getUri() {
		return session.getUri();
	}

	@Override
	public Map<String, Object> getAttributes() {
		return session.getAttributes();
	}

	@Override
	public Principal getPrincipal() {

		return session.getPrincipal();
	}

	@Override
	public String getLocalAddress() {

		if (session.getLocalAddress() != null) {
			return session.getLocalAddress().toString();
		}
		return null;
	}

	@Override
	public String getRemoteAddress() {
		if (session.getRemoteAddress() != null) {
			return session.getRemoteAddress().toString();
		}
		return null;
	}

	@Override
	public String getProtocol() {
		return session.getAcceptedProtocol();
	}

	@SuppressWarnings("unchecked")
	@Override
	public void sendMessage(WikiotMessage message) throws IOException {
		session.sendMessage((WebSocketMessage<String>) message);
	}

	@Override
	public boolean isOpen() {

		return session.isOpen();
	}

	@Override
	public void close() throws IOException {
		session.close();
	}
	
	public WebSocketSession getNativeSession(){
		return this.session;
	}

}
