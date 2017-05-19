package framework;

import def.jquery.JQueryEventObject;

public interface EventListener  {
	
	public void performAction(JSContainer source, Event<JQueryEventObject> evt);

}
