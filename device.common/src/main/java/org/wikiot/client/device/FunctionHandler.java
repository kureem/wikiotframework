package org.wikiot.client.device;

import java.util.Map;

public interface FunctionHandler {
	
	public void execute(String name, Map<String, String> input);

}
 