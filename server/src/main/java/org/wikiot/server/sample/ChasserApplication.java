package org.wikiot.server.sample;

import java.util.Map;

import org.springframework.stereotype.Component;
import org.wikiot.server.Device;
import org.wikiot.server.EventListener;
import org.wikiot.server.websocket.GenericIOTApplet;

@Component
public class ChasserApplication extends GenericIOTApplet{

	@Override
	public void initDevice(Device device) {
		
		if(device.getDeviceId().equals("18")){
			device.addEvent(new EventListener() {
				
				@Override
				public void execute(Device source, String type, Map<String, String> parameters) {
					findDevice("17").invoke("SwitchOn", parameters);
					
				}
			}, "Pitch");
		}
		
	}

	
	
}
