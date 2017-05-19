package framework.mobile;

import framework.JSContainer;

public class ONSRow extends JSContainer {

	private String verticalAlign;

	public ONSRow(String name) {
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
