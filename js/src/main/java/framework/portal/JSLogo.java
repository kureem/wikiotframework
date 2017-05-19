package framework.portal;

import framework.JSContainer;

public class JSLogo extends JSContainer{

	private JSContainer img = new JSContainer("img");
	public JSLogo(String name) {
		super(name, "a");
		addChild(img);
		addClass("navbar-brand");
		
	}
	
	public void setSrc(String url){
		img.setAttribute("src", url);
	}
	
	

}
