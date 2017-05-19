package org.castafiore.mobile;

import org.castafiore.ui.EXContainer;

public class EXRow extends EXContainer {

	private String verticalAlign;

	public EXRow(String name) {
		super(name, "ons-row");
	}

	public String getVerticalAlign() {
		return verticalAlign;
	}

	public void setVerticalAlign(String verticalAlign) {
		this.verticalAlign = verticalAlign;
		setAttribute("vertical-align", verticalAlign);
	}

}
