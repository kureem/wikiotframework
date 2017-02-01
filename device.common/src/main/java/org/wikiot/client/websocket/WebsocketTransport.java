package org.wikiot.client.websocket;

import java.io.IOException;
import java.net.URI;
import java.util.LinkedList;
import java.util.List;

import javax.websocket.ContainerProvider;
import javax.websocket.Session;
import javax.websocket.WebSocketContainer;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;
import org.springframework.web.socket.sockjs.client.RestTemplateXhrTransport;
import org.springframework.web.socket.sockjs.client.SockJsClient;
import org.springframework.web.socket.sockjs.client.Transport;
import org.springframework.web.socket.sockjs.client.WebSocketTransport;
import org.wikiot.client.device.Device;
import org.wikiot.client.device.DownStreamMessageListener;
import org.wikiot.client.device.OnAfterConnectionClosed;
import org.wikiot.client.device.OnBeforeConnectionListener;
import org.wikiot.client.device.OnConnectedListener;
import org.wikiot.client.device.OnDisconnectedListener;
import org.wikiot.client.device.OnErrorListener;
import org.wikiot.client.device.OnOpenListener;
import org.wikiot.client.device.OnReadyListener;
import org.wikiot.client.device.WikiotTransportLayer;
import org.wikiot.io.DownStreamMessage;
import org.wikiot.io.UpStreamMessage;

import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class WebsocketTransport implements WikiotTransportLayer, InitializingBean, WebSocketHandler,
		ListenableFutureCallback<WebSocketSession> {

	protected final Log logger = LogFactory.getLog(getClass());

	@Autowired
	private SockJsClient client;

	protected final List<DownStreamMessageListener> messageListeners = new LinkedList<DownStreamMessageListener>();

	protected final List<OnConnectedListener> onConnectedListeners = new LinkedList<OnConnectedListener>();

	protected final List<OnDisconnectedListener> onDisconnectedListeners = new LinkedList<OnDisconnectedListener>();

	protected final List<OnOpenListener> onOpenListeners = new LinkedList<OnOpenListener>();

	protected final List<OnErrorListener> onErrorListener = new LinkedList<OnErrorListener>();

	protected final List<OnReadyListener> onReadyListener = new LinkedList<OnReadyListener>();

	protected final List<OnAfterConnectionClosed> onAfterConnectionClosedListener = new LinkedList<OnAfterConnectionClosed>();

	protected final List<OnBeforeConnectionListener> beforeConnectionListener = new LinkedList<OnBeforeConnectionListener>();
	@Value("${wikiot.host:http://localhost:8081}")
	protected String host;
	@Value("${wikiot.path:/ws}")
	protected String path;

	protected ObjectMapper mapper = new ObjectMapper();

	protected WebSocketSession session;

	protected Session nativeSession;

	protected Device device;

	private List<Transport> transports = new LinkedList<Transport>();

	public WebsocketTransport(Device device) {
		super();
		this.device = device;
	}

	@Override
	public boolean sendRequest(UpStreamMessage request) {
		try {
			if (isConnected()) {

				Assert.isInstanceOf(WebsocketWikiotMessage.class, request,
						"Fatal error: Upstream message should be an implementation of WikiotMessage as well");
				session.sendMessage((WebsocketWikiotMessage) request);
				return true;
			} else {

				logger.error(
						"Trying to send an upstream message while session is closed!!. Please reconnect first. Nothing is done here");
				return false;
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}

	@Override
	public boolean isConnected() {
		return session != null && session.isOpen();
	}

	@Override
	public WikiotTransportLayer disconnect() throws IOException {
		if (session != null) {
			session.close();
		}
		session = null;
		for (OnDisconnectedListener l : onDisconnectedListeners) {
			l.onDisconnected(getDevice(), true);
		}
		return this;

	}

	@Override
	public WikiotTransportLayer connect() {
		try {
			WebSocketContainer container = ContainerProvider.getWebSocketContainer();
			nativeSession = container.connectToServer(this, new URI(host + path));
			return this;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}

	@Override
	public WikiotTransportLayer addOnConnectedListener(OnConnectedListener listener) {
		onConnectedListeners.add(listener);
		return this;
	}

	@Override
	public Device getDevice() {
		return device;
	}

	public void setDevice(Device device) {
		this.device = device;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}
	
	

	protected String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		Assert.notNull(host, "Server must be specified. Please set the endpoint of the websocket server");
		if (client == null) {

			logger.warn("No suitable bean found for SockJsClient. Construction a sensible default one");

			if (transports.size() == 0) {
				transports.add(new WebSocketTransport(new StandardWebSocketClient()));
				transports.add(new RestTemplateXhrTransport());
				logger.warn("Transports not configured. Using default ones");
			}

			client = new SockJsClient(transports);
		}
		ListenableFuture<WebSocketSession> future = client.doHandshake(this, host + path);
		future.addCallback(this);
	}

	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		this.session = session;
		for (OnConnectedListener l : onConnectedListeners) {
			l.onConnected(getDevice());
		}

	}

	@Override
	public boolean supportsPartialMessages() {
		return false;
	}

	@Override
	public WikiotTransportLayer addOnDisconnectedListener(OnDisconnectedListener handler) {
		this.addOnDisconnectedListener(handler);
		return this;
	}

	@Override
	public WikiotTransportLayer addOnOpenListener(OnOpenListener listener) {
		this.onOpenListeners.add(listener);
		return this;
	}

	@Override
	public WikiotTransportLayer addOnConnectionErrorListener(OnErrorListener listener) {
		this.onErrorListener.add(listener);
		return this;
	}

	@Override
	public WikiotTransportLayer addAfterConnectionClosedListener(OnAfterConnectionClosed listener) {

		onAfterConnectionClosedListener.add(listener);
		return this;
	}

	@Override
	public void handleMessage(WebSocketSession session, WebSocketMessage<?> ws) throws Exception {

		try {
			String message = (String) ws.getPayload();

			DownStreamMessage response = mapper.readValue(message.getBytes(), DownStreamMessage.class);

			for (DownStreamMessageListener m : messageListeners) {
				m.onMessage(response);
			}

		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
		for (OnErrorListener e : onErrorListener) {

			e.onError(device, exception, session.getRemoteAddress().toString());
		}
	}

	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception {

		for (OnAfterConnectionClosed l : onAfterConnectionClosedListener) {
			l.afterConnectionClosed(getDevice(), closeStatus.getReason(), null);
		}

	}

	@Override
	public void onSuccess(WebSocketSession result) {
		this.session = result;
		logger.info("Handshake successful");

	}

	@Override
	public void onFailure(Throwable ex) {

		this.session = null;
		throw new RuntimeException("Error in handshake", ex);

	}

	@Override
	public WikiotTransportLayer addDownStreamMessageListener(DownStreamMessageListener listener) {

		messageListeners.add(listener);
		return this;
	}
	

}
