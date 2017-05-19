package framework.portal;

import framework.JSContainer;

public class JSIcon extends JSContainer{

	public JSIcon(String name) {
		super(name, "i");
	}
	
	
	public JSIcon setIcon(String cls){
		 setAttribute("class",  cls);
		 return this;
	}
	
	

}
