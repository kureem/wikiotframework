package framework.portal;

import framework.JSContainer;

public class JSImage extends JSContainer {

	public JSImage(String name) {
		super(name, "img");
	}
	
	public void setSource(String src){
		setAttribute("src", src);
		
	}
	
	public String getSource(){
		return getAttribute("src");
	}

	
}
