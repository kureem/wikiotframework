package framework.portal.widgets;

import framework.JSContainer;
import framework.portal.JSBadge;
import framework.portal.JSButton;
import framework.portal.JSDropdown;
import framework.portal.JSIcon;
import framework.portal.JSLabel;

public class JSNavigation extends JSContainer {

	public JSNavigation(String name) {
		super(name, "ul");
		addClass("navigation navigation-main navigation-accordion");
		
		
	}

	public JSNavigation addHeader(String label) {
		addChild(new JSContainer("li").addClass("navigation-header").setHtml(label));
		return this;
	}

	public JSNavigation addHeader(String label, JSIcon icon) {
		addChild( new JSContainer("li").addClass("navigation-header").setHtml(label).addChild(icon) );
		return this;
	}
	
	public JSNavigation addButton(JSButton button) {
		addChild(new JSContainer("li").addChild(button));
		return this;
	}

	public JSNavigation addButton(JSButton button, JSLabel label) {
		button.addChild(label);
		return addButton(button);
	}

	public JSNavigation addButton(JSButton button, JSBadge badge) {
		button.addChild(badge);
		return addButton(button);
	}

	public JSNavigation addSeparator() {
		addChild(new JSContainer("li").addClass("navigation-divider"));
		return this;
	}
	
	public JSNavigation addDropdown(JSDropdown dropdown){
		dropdown.setTag("li");
		addChild(dropdown);
		return this;
	}

}
