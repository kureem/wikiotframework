package framework.mobile;

import framework.EventListener;
import framework.JSColor;
import framework.JSMap;

public class ONSDialog extends ONSModifiable {

	private boolean cancelable;

	private boolean disabled;

	private String animation;

	private JSMap animationOptions;

	private JSColor maskColor;

	private EventListener preshow;// Fired just before the alert dialog is displayed.
	private EventListener postshow;// Fired just after the alert dialog is displayed.
	private EventListener prehide;// Fired just before the alert dialog is hidden.
	private EventListener posthide;// Fired just after the alert dialog is hidden.

	public ONSDialog(String name) {
		super(name, "ons-dialog");
	}

	protected ONSDialog(String name, String tag) {
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

	public JSColor getMaskColor() {
		return maskColor;
	}

	public void setMaskColor(JSColor maskColor) {
		this.maskColor = maskColor;
		if (maskColor != null) {
			setAttribute("mask-color", "rgba(" + maskColor.getRed() + "," + maskColor.getGreen() + ","
					+ maskColor.getBlue() + "," + maskColor.getAlpha() + ")");
		} else {
			setAttribute("mask-color", (String) null);
		}
	}

	public EventListener getPreshow() {
		return preshow;
	}

	public void setPreshow(EventListener preshow) {
		this.preshow = preshow;
		addEventListener(preshow, "preshow");
	}

	public EventListener getPostshow() {
		return postshow;
	}

	public void setPostshow(EventListener postshow) {
		this.postshow = postshow;
		addEventListener(postshow, "postshow");
	}

	public EventListener getPrehide() {
		return prehide;
	}

	public void setPrehide(EventListener prehide) {
		this.prehide = prehide;
		addEventListener(prehide, "prehide");
	}

	public EventListener getPosthide() {
		return posthide;
	}

	public void setPosthide(EventListener posthide) {
		this.posthide = posthide;
		addEventListener(posthide, "posthide");
	}

	public void show(JSMap options) {

	}

	public void hide(JSMap options) {
		// set
	}

}
