package org.wikiot.server.sample;

import java.util.Map;

import org.springframework.stereotype.Component;
import org.wikiot.server.Device;
import org.wikiot.server.EventListener;
import org.wikiot.server.websocket.GenericIOTApplet;

@Component
public class FireAlarmApp extends GenericIOTApplet {

	public FireAlarmApp(){
		addRequiredDevice("al.0.0", "0");
		addRequiredDevice("sn.0.0", "1");		
	}

	@Override
	public void initDevice(Device device) {
		//when device is first initialised, we add the listener for the 2 events on the remote control
		if(device.getDeviceId().equals("1")){
			device.addEvent(new OnCloseFire(), "OnCloseFire");
			device.addEvent(new OnDistantFire(), "OnDistantFire");
		}
		
	}

	
	/**
	 * Implementation of the OnSwitchOn listener
	 *
	 */
	class OnCloseFire implements EventListener{

		@Override
		public void execute(Device source, String type,
				Map<String, String> parameters) {
			//finds the device and invoke the SwitchOn function
			findDevice("0").invoke("Danger");
			
		}
		
	}
	
	class OnDistantFire implements EventListener{

		@Override
		public void execute(Device source, String type,	Map<String, String> parameters) {
			
			//finds the device and invokes the SwitchOff event
			findDevice("0").invoke("Warning");
			
		}
		
	}

}
