# wikiotframework

### Description 
This project platform that allows interaction between smart devices.
The framework uses the same principle as an application server where developers can build smart devices and deploy them on the platform.
The platform uses websocket for communication.
Generally, a smart system will consists of
1. several devices like thermostats, light detecter, fire alarms
2. An application that will allow the devices to interact in a smart way



## How to install the platform

Clone this project with git and install the library in your local Maven repository (so that you can refer to it as a dependency in other Maven projects):

```bash
> mvn install
```


### Create your first iot application
And IOT application generally consists of several devices
The devices interact with each other via a server application
#### A device
```java

final Device mydevice = new Device("BasicSwitch", "Switch", "Switch", "switch.png");
  
  	mydevice.registerFunction("SwitchOn", "Function exposed to server");
  
  	mydevice.registerFunction("SwitchOff", "Function exposed to server for switching off the device");
  
  	mydevice.setWebsocketLayer(new JavaWebsocketLayer(mydevice));
  
  	final JLabel state = new JLabel();
  
  	mydevice.addFunctionHandler(new FunctionHandler() {
  
  		public void execute(String name, Map<String, String> input) {
  			if (name.equals("SwitchOn")) {
  				state.setText("Switched on");
  			} else {
  				state.setText("Switched off");
  			}
  		}
  	});
  
  	mydevice.onReady(new OnReady() {
  
  		public void ready() {
  			JFrame frame = new JFrame("My switch");
  
  			frame.getContentPane().add(state, BorderLayout.NORTH);
  
 			frame.setSize(200, 200);
  
  			frame.setVisible(true);
 
 		}
  	});
  
  	mydevice.connect("ws://localhost:8080/iot/websockets/iot");
  
 }

```
The server application
```java
package org.castafiore.iot.sample;

import java.util.Map;

import org.castafiore.iot.Device;
import org.castafiore.iot.EventListener;
import org.castafiore.iot.websocket.GenericIOTApplet;
import org.springframework.stereotype.Component;

//@Component
public class RemoteControlApplet extends GenericIOTApplet {

	public RemoteControlApplet(){
		addRequiredDevice("ctr.0.0", "0");
		addRequiredDevice("sw.0.0", "1");		
	}

	@Override
	public void initDevice(Device device) {
		//when device is first initialised, we add the listener for the 2 events on the remote control
		if(device.getDeviceId().equals("0")){
			device.addEvent(new OnSwitchOn(), "OnSwitchOn");
			device.addEvent(new OnSwitchOff(), "OnSwitchOff");
		}
		
	}

	
	/**
	 * Implementation of the OnSwitchOn listener
	 *
	 */
	class OnSwitchOn implements EventListener{

		@Override
		public void execute(Device source, String type,
				Map<String, String> parameters) {
			//finds the device and invoke the SwitchOn function
			findDevice("1").invoke("SwitchOn");
			
		}
		
	}
	
	class OnSwitchOff implements EventListener{

		@Override
		public void execute(Device source, String type,	Map<String, String> parameters) {
			
			//finds the device and invokes the SwitchOff event
			findDevice("1").invoke("SwitchOff");
			
		}
		
	}

}
```

More samples can be found here 


## License

By default, JSweet candies are published with the Apache 2 Open Source license. Since they are pure APIs, remember that it does not make sense to try to bind a JSweet candy to a commercial license (on contrary to the bridged JS library/framework, which can be distributed under a non-open source license).  
