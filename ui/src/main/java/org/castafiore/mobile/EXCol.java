package org.castafiore.mobile;

import org.castafiore.ui.EXContainer;

public class EXCol extends EXContainer {

	private String verticalAlign;

	private String width;

	public EXCol(String name) {
		super(name, "ons-col");
	}

	public String getVerticalAlign() {
		return verticalAlign;
	}

	public void setVerticalAlign(String verticalAlign) {
		this.verticalAlign = verticalAlign;
		setAttribute("vertical-align", verticalAlign);
	}

	public String getWidth() {
		return width;
	}

	public void setWidth(String width) {
		this.width = width;
		setAttribute("width", width);
	}

}
