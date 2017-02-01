package org.wikiot.server.robot2d;

import java.util.Map;

import org.springframework.stereotype.Component;
import org.wikiot.server.Device;
import org.wikiot.server.EventListener;
import org.wikiot.server.websocket.GenericIOTApplet;

@Component
public class Robot2D extends GenericIOTApplet{
	
	public Robot2D(){
		addRequiredDevice("rb.0.0", "5");
		addRequiredDevice("rbc.0.0", "6");		
	}

	@Override
	public void initDevice(Device device) {
		if(device.getDeviceId().endsWith("6")){
			device.addEvent(new OnReset(), "OnReset");
			device.addEvent(new OnMoveXBy(), "OnMoveX");
			device.addEvent(new OnMoveYBy(),"OnMoveY");
		}
	}
	
	
	public class OnReset implements EventListener{

		@Override
		public void execute(Device source, String type, Map<String, String> parameters) {
			findDevice("5").invoke("reset");
		}
		
	}
	
	public class OnMoveXBy implements EventListener{

		@Override
		public void execute(Device source, String type, Map<String, String> parameters) {
			findDevice("5").invoke("MoveX",parameters);
		}
		
	}
	
	public class OnMoveYBy implements EventListener{

		@Override
		public void execute(Device source, String type, Map<String, String> parameters) {
			findDevice("5").invoke("MoveY",parameters);
		}
		
	}
	

}
