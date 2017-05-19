package framework.mobile;

import framework.JSColor;
import framework.JSContainer;

public class ONSRipple extends JSContainer {

	private JSColor color;

	private JSColor backgroundColor;

	private boolean disabled;

	public ONSRipple(String name) {
		super(name, "ons-ripple");
	}

	public boolean isDisabled() {
		return disabled;
	}

	public void setDisabled(boolean disabled) {
		this.disabled = disabled;
		if (disabled) {
			setAttribute("disabled", "true");
		} else {
			setAttribute("disabled", (String) null);
		}
	}

	public JSColor getColor() {
		return color;
	}

	public void setColor(JSColor color) {
		this.color = color;
		if (color != null) {
			setAttribute("color", "rgba(" + color.getRed() + "," + color.getGreen() + "," + color.getBlue() + ","
					+ color.getAlpha() + ")");
		} else {
			setAttribute("color", (String) null);
		}
	}

	public JSColor getBackgroundColor() {
		return backgroundColor;
	}

	public void setBackgroundColor(JSColor backgroundColor) {
		this.backgroundColor = backgroundColor;
		if (backgroundColor != null) {
			setAttribute("background-color", "rgba(" + backgroundColor.getRed() + "," + backgroundColor.getGreen() + ","
					+ backgroundColor.getBlue() + "," + backgroundColor.getAlpha() + ")");
		} else {
			setAttribute("background-color", (String) null);
		}
	}

}
