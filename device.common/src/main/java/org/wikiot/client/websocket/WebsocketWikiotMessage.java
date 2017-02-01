package org.wikiot.client.websocket;

import org.springframework.web.socket.WebSocketMessage;
import org.wikiot.client.device.WikiotMessage;
import org.wikiot.io.UpStreamMessage;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class WebsocketWikiotMessage extends UpStreamMessage implements WebSocketMessage<String>, WikiotMessage {

	@JsonIgnore
	private ObjectMapper mapper = new ObjectMapper();
	
	public WebsocketWikiotMessage(ObjectMapper mapper){
		setMapper(mapper);
	}

	public WebsocketWikiotMessage(){
		this(new ObjectMapper());
	}
	public ObjectMapper getMapper() {
		return mapper;
	}

	public void setMapper(ObjectMapper mapper) {
		this.mapper = mapper;
	}

	@Override
	public String getPayload() {
		try {
			return mapper.writeValueAsString(this);
		} catch (JsonProcessingException e) {
			throw new RuntimeException("There was an error trying to serialize of the message", e);
		}
	}

	@Override
	public int getPayloadLength() {

		return getPayload().length();
	}

	@Override
	public boolean isLast() {
		return true;
	}

	@Override
	public String getTextMessage() {
		return getPayload();
	}

}
