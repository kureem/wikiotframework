package framework.portal;

import framework.JSContainer;

public class JSDropdown extends JSContainer{

	public JSDropdown(JSButton button, JSDropdownMenu menu) {
		super("", "div");
		addClass("dropdown");
		setButtonAndMenu(button, menu);
	}
	
	
	public void setButtonAndMenu(JSButton button, JSDropdownMenu menu){
		this.getChildren().clear();
		button.addClass("dropdown-toggle");
		button.setAttribute("data-toggle", "dropdown");
		button.setAttribute("aria-expanded", "true");
		addChild(button);
		
		addChild(menu);
	}
	

	
}
