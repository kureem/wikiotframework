package framework.mobile;

import framework.JSContainer;

public class ONSCol extends JSContainer {

	private String verticalAlign;

	private String width;

	public ONSCol(String name) {
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
