package framework.services;

import framework.JSContainer;

public interface ComponentFactory {

	public boolean supports(String name);
	
	public JSContainer createInstance(Layout layout, boolean designMode);
	
	
}
