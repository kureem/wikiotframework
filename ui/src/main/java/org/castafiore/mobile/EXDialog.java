package org.castafiore.mobile;

import java.awt.Color;

import org.castafiore.ui.Event;
import org.castafiore.ui.js.JSMap;

public class EXDialog extends EXModifiable {

	private boolean cancelable;

	private boolean disabled;

	private String animation;

	private JSMap animationOptions;

	private Color maskColor;

	private Event preshow;// Fired just before the alert dialog is displayed.
	private Event postshow;// Fired just after the alert dialog is displayed.
	private Event prehide;// Fired just before the alert dialog is hidden.
	private Event posthide;// Fired just after the alert dialog is hidden.

	public EXDialog(String name) {
		super(name, "ons-dialog");
	}

	protected EXDialog(String name, String tag) {
		super(name, tag);
	}

	public boolean isCancelable() {
		return cancelable;
	}

	public void setCancelable(boolean cancelable) {
		this.cancelable = cancelable;
		if (cancelable) {
			setAttribute("cancelable", "true");
		} else {
			setAttribute("cancelable", (String) null);
		}
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

	public String getAnimation() {
		return animation;
	}

	public void setAnimation(String animation) {
		this.animation = animation;
		setAttribute("animation", animation);
	}

	public JSMap getAnimationOptions() {
		return animationOptions;
	}

	public void setAnimationOptions(JSMap animationOptions) {
		this.animationOptions = animationOptions;
		if (animationOptions != null)
			setAttribute("animation-options", animationOptions.getJavascript());
		else
			setAttribute("animation-options", (String) null);
	}

	public Color getMaskColor() {
		return maskColor;
	}

	public void setMaskColor(Color maskColor) {
		this.maskColor = maskColor;
		if (maskColor != null) {
			setAttribute("mask-color", "rgba(" + maskColor.getRed() + "," + maskColor.getGreen() + ","
					+ maskColor.getBlue() + "," + maskColor.getAlpha() + ")");
		} else {
			setAttribute("mask-color", (String) null);
		}
	}

	public Event getPreshow() {
		return preshow;
	}

	public void setPreshow(Event preshow) {
		this.preshow = preshow;
		addEvent(preshow, "preshow");
	}

	public Event getPostshow() {
		return postshow;
	}

	public void setPostshow(Event postshow) {
		this.postshow = postshow;
		addEvent(postshow, "postshow");
	}

	public Event getPrehide() {
		return prehide;
	}

	public void setPrehide(Event prehide) {
		this.prehide = prehide;
		addEvent(prehide, "prehide");
	}

	public Event getPosthide() {
		return posthide;
	}

	public void setPosthide(Event posthide) {
		this.posthide = posthide;
		addEvent(posthide, "posthide");
	}

	public void show(JSMap options) {

	}

	public void hide(JSMap options) {
		// set
	}

}
