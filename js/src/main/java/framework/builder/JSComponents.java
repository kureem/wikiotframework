package framework.builder;

import framework.JSContainer;
import framework.portal.JSRow;

public class JSComponents extends JSContainer{

	private JSRow row = new JSRow();
	
	public JSComponents(String name) {
		super(name, "div");
		addClass("content-group");
		addChild(row);
		row.addClass("row-seamless").addClass("btn-block-group");
	}
	
	

}
