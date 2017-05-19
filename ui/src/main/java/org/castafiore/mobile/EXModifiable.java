package org.castafiore.mobile;

import org.castafiore.ui.EXContainer;

public class EXModifiable extends EXContainer {
	
	public EXModifiable(String name, String tagName) {
		super(name, tagName);
	}

	public void setModifier(String modifier) {
		setAttribute("modifier", modifier);
	}

	public String getModifier() {
		return getAttribute("modifier");
	}


}
