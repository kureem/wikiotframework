package org.castafiore.mobile;

import org.castafiore.ui.EXContainer;

public class EXIcon extends EXContainer {

	private String icon;

	private String size;

	private String rotate;

	private boolean fixedWidth;

	private boolean spin;

	public EXIcon(String name) {
		super(name, "ons-icon");
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
		setAttribute("icon", icon);
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
		setAttribute("size", size);
	}

	public String getRotate() {
		return rotate;
	}

	public void setRotate(String rotate) {
		this.rotate = rotate;
		setAttribute("rotate", rotate);
	}

	public boolean isFixedWidth() {
		return fixedWidth;
	}

	public void setFixedWidth(boolean fixedWidth) {
		this.fixedWidth = fixedWidth;
		setAttribute("fixed-width", fixedWidth + "");
	}

	public boolean isSpin() {
		return spin;
	}

	public void setSpin(boolean spin) {
		this.spin = spin;
		if (spin) {
			setAttribute("spin", "true");
		} else {
			setAttribute("spin", (String) null);
		}
	}

}
