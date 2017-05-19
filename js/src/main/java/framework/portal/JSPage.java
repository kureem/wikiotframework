package framework.portal;

import java.util.HashMap;
import java.util.Map;

import framework.JSContainer;
import framework.Renderable;

public abstract class JSPage extends JSContainer {

	private JSPageHeader header = new JSPageHeader("header");

	private JSContainer content = new JSContainer("content", "div");

	private Map<String, String> parameters = new HashMap<>();
	
	private WireFrame owner;

	public JSPage(String name) {
		super(name, "div");
		addClass("page");
		addChild(header);
		content.addClass("content");
		addChild(content);
	}
	
	public void setOwner(WireFrame frame){
		this.owner = frame;
	}
	
	public WireFrame getOwner(){
		return owner;
	}

	public JSPageHeader getHeader() {
		return header;
	}

	public Renderable getContent() {
		return content;
	}

	public Map<String, String> getParameters() {
		return parameters;
	}

	public void setParameters(Map<String, String> parameters) {
		this.parameters = parameters;
	}

	public abstract void buildPage();

}
