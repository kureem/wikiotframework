package framework.portal;

import framework.JSContainer;

public class JSNavbarGroup extends JSContainer{

	public JSNavbarGroup(String name) {
		super(name, "ul");
		addClass("nav navbar-nav");
		// TODO Auto-generated constructor stub
	}
	

public JSNavbarGroup addButtonItem(JSButton container){
		
		JSContainer li = new JSContainer("li");
		addChild(li);
		li.addChild(container);
		return this;
	}
	
	public JSNavbarGroup addDropdownItem(JSContainer container){
		
		container.setTag("li");
		addChild(container);
		return this;
	}
	
	
	public JSNavbarGroup addTextItem(JSContainer text){
		JSContainer li = new JSContainer("li");
		addChild(li);
		li.addChild(text);
		li.addClass("navbar-text");
		return this;
	}
	
	public void setPosition(HorizontalDirection direction){
		if(direction == HorizontalDirection.LEFT){
			removeClass("navbar-right");
		}else{
			addClass("navbar-right");
		}
	}
	

}
