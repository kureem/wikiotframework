package framework.portal;

import framework.JSContainer;
import framework.Renderable;

public class JSPageContainer extends JSContainer{

	private JSContainer content = new JSContainer("div").addClass("page-content");

	public JSPageContainer(String name) {
		super(name, "div");
		addChild(content);
		addClass("page-container");
	}
	
	public Renderable getContent(){
		return content;
	}

	
}
