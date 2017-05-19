package framework.mobile;

import framework.JSContainer;
import framework.JSMap;

public class ONSModal extends JSContainer{

	private String animation;

	private JSMap animationOptions;

	public ONSModal(String name) {
		super(name, "ons-dialog");
	}
	
	public String getAnimation() {
		return animation;
	}

	public void setAnimation(String animation) {
		this.animation = animation;
		setAttribute("animation",animation);
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

}
