package org.castafiore.mobile;

import org.castafiore.ui.EXContainer;
import org.castafiore.ui.js.JSMap;

public class EXModal extends EXContainer{

	private String animation;

	private JSMap animationOptions;

	public EXModal(String name) {
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
