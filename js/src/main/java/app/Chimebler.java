package app;

import framework.JSContainer;

public class Chimebler extends JSContainer{

	private CHLogin loginPage = new CHLogin();
	
	
	
	public Chimebler() {
		super("chimebler", "div");
		addChild(loginPage);
	}
	
	

}
