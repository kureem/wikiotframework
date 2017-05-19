package framework.portal;

import framework.JSContainer;

public class JSBreadcrumbElements extends JSContainer{

	public JSBreadcrumbElements(String name) {
		super(name, "ul");
		addClass("breadcrumb-elements");
	}
	
	public void addButtonItem(JSButton button){
		JSContainer li = new JSContainer("","li");
		li.addChild(button);
		addChild(li);
	}
	
	public void addDropdownItem(JSDropdown dropdown){
		
		addChild(dropdown);
	}

}
