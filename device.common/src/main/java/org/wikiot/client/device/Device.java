package org.wikiot.client.device;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.Assert;
import org.wikiot.DefinitionRegistry;
import org.wikiot.DeviceDefinition;
import org.wikiot.EventDefinition;
import org.wikiot.Property;
import org.wikiot.io.OnEvent;
import org.wikiot.io.UpStreamMessage;
import org.wikiot.io.Util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 
 * This class is a generic wrapper for a device.<br>
 * This implementation is in java and intended to run on any device that can
 * executes a jvm.<br>
 * See other projects for implementation of a device wrapper in other<br>
 * languages. <br>
 * The device is associated with an iot server.<br>
 * This class helps for the following:<br>
 * <ul>
 * <li>Create a device definition dynamically</li>
 * <li>Manage websocket connection with server</li>
 * <li>Encapsulates the complexities of constructing websocket messages
 * according to the iot protocol</li>
 * <li>Manage life cycle of device</li>
 * </ul>
 * 
 * <pre>
 * 
 * {
 * 	&#64;code
 * 	final Device mydevice = new Device("BasicSwitch", "Switch", "Switch", "switch.png");
 * 
 * 	mydevice.registerFunction("SwitchOn", "Function exposed to server");
 * 
 * 	mydevice.registerFunction("SwitchOff", "Function exposed to server for switching off the device");
 * 
 * 	mydevice.setWebsocketLayer(new JavaWebsocketLayer(mydevice));
 * 
 * 	final JLabel state = new JLabel();
 * 
 * 	mydevice.addFunctionHandler(new FunctionHandler() {
 * 
 * 		public void execute(String name, Map<String, String> input) {
 * 			if (name.equals("SwitchOn")) {
 * 				state.setText("Switched on");
 * 			} else {
 * 				state.setText("Switched off");
 * 			}
 * 		}
 * 	});
 * 
 * 	mydevice.onReady(new OnReady() {
 * 
 * 		public void ready() {
 * 			JFrame frame = new JFrame("My switch");
 * 
 * 			frame.getContentPane().add(state, BorderLayout.NORTH);
 * 
 * 			frame.setSize(200, 200);
 * 
 * 			frame.setVisible(true);
 * 
 * 		}
 * 	});
 * 
 * 	mydevice.connect("ws://localhost:8080/iot/websockets/iot");
 * 
 * }
 * </pre>
 * 
 * @author Kureem Rossaye
 * 
 */
public class Device implements OnConnectedListener, InitializingBean {

	@Autowired
	protected DefinitionRegistry definitionRegistry;

	@Autowired
	protected WikiotTransportLayer transport;


	private String deviceId = Util.getMacAddress();

	@Value("${definition.id:mic.0.0}")
	private String definitionId;

	private transient DeviceDefinition definition = new DeviceDefinition();
	
	
	private List<FunctionHandler> handlers = new LinkedList<FunctionHandler>();
	


	public DefinitionRegistry getDefinitionRegistry() {
		return definitionRegistry;
	}

	public void setDefinitionRegistry(DefinitionRegistry definitionRegistry) {
		this.definitionRegistry = definitionRegistry;
	}

	public WikiotTransportLayer getTransport() {
		return transport;
	}

	public void setTransport(WikiotTransportLayer transport) {
		this.transport = transport;
	}


	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public String getDefinitionId() {
		return definitionId;
	}

	public void setDefinitionId(String definitionId) {
		this.definitionId = definitionId;
	}

	public DeviceDefinition getDefinition() {
		return definition;
	}

	public void setTransportLayer(WikiotTransportLayer layer) {
		this.transport = layer;
		transport.addOnConnectedListener(this);
	}

	public Device setSpec(String key, String value) {
		for (Property p : definition.getProps()) {
			if (p.getName().equals(key)) {
				p.setValue(value);
				return this;
			}
		}
		Property p = new Property();
		p.setName(key);
		p.setValue(value);
		definition.getProps().add(p);
		return this;
	}

	public Device registerEvent(String name, String description) {
		EventDefinition event = new EventDefinition();
		event.setName(name);
		event.setDescription(description);
		definition.getEvts().add(event);
		return this;
	}

	public void handshake() {
		UpStreamMessage up = new UpStreamMessage();
		up.setDeviceId(deviceId);

		try {
			String s;
			s = new ObjectMapper().writeValueAsString(definition);
			up.setBody(s);
			up.setType(UpStreamMessage.HANDSHAKE);
			transport.sendRequest(up);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}

	}

	public void propagateEvent(String event, Map<String, String> parameters) {
		UpStreamMessage request = new UpStreamMessage();
		request.setType(UpStreamMessage.IO);
		request.setDeviceId(deviceId);
		OnEvent e = new OnEvent();
		e.setName(event);
		e.setParams(parameters);
		try {
			String body = new ObjectMapper().writeValueAsString(e);
			request.setBody(body);
			transport.sendRequest(request);

		} catch (JsonProcessingException e1) {
			e1.printStackTrace();
		}

	}

	public void propagateEvent(String event) {
		propagateEvent(event, new HashMap<String, String>());

	}

	public Device addFunctionHandler(FunctionHandler handler) {
		handlers.add(handler);
		return this;
	}

	public Device addOnDisconnectedListener(OnDisconnectedListener handler) {
		transport.addOnDisconnectedListener(handler);
		return this;
	}

	public Device connect() {
		transport.connect();
		return this;
	}

	public Device reconnect() {
		connect();
		return this;
	}

	public boolean isConnected() {
		return transport.isConnected();
	}

	public Device disconnect() throws IOException {
		transport.disconnect();
		return this;
	}

	@Override
	public void onConnected(Device device) {
		
	}

	

	@Override
	public void afterPropertiesSet() throws Exception {

		Assert.notNull(transport, "No transport implementation obtained");
		Assert.notNull(deviceId, "device Id cannot be null");
		Assert.notNull(definitionId, "Definition Id cannot be null");

		Assert.notNull(definitionRegistry, "No suitable been found for definitionRegistry. It cannot be null");

		definition = definitionRegistry.getDefinition(definitionId);

	}

}
