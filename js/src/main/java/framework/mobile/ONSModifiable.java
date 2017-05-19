package framework.mobile;

import framework.JSContainer;

public class ONSModifiable extends JSContainer {
	
	public ONSModifiable(String name, String tagName) {
		super(name, tagName);
	}

	public void setModifier(String modifier) {
		setAttribute("modifier", modifier);
	}

	public String getModifier() {
		return getAttribute("modifier");
	}


}
