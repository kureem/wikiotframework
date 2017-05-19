package framework.builder;

import framework.portal.JSButton;
import framework.services.Component;

public class JSComponent extends JSButton{

	private Component component;
	
	public JSComponent(Component comp) {
		super(comp.getName());
		setText(comp.getLabel());
		setIcon(comp.getIcon());
		addClass("btn-default");
		addClass("btn-xs");
	}
	
	

}
