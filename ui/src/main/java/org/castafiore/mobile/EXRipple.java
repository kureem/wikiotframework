package org.castafiore.mobile;

import java.awt.Color;

import org.castafiore.ui.EXContainer;

public class EXRipple extends EXContainer {

	private Color color;

	private Color backgroundColor;

	private boolean disabled;

	public EXRipple(String name) {
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

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
		if (color != null) {
			setAttribute("color", "rgba(" + color.getRed() + "," + color.getGreen() + "," + color.getBlue() + ","
					+ color.getAlpha() + ")");
		} else {
			setAttribute("color", (String) null);
		}
	}

	public Color getBackgroundColor() {
		return backgroundColor;
	}

	public void setBackgroundColor(Color backgroundColor) {
		this.backgroundColor = backgroundColor;
		if (backgroundColor != null) {
			setAttribute("background-color", "rgba(" + backgroundColor.getRed() + "," + backgroundColor.getGreen() + ","
					+ backgroundColor.getBlue() + "," + backgroundColor.getAlpha() + ")");
		} else {
			setAttribute("background-color", (String) null);
		}
	}

}
