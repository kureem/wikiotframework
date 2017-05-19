package org.castafiore.mobile;

import org.castafiore.ui.EXContainer;
import org.castafiore.ui.Event;
import org.castafiore.ui.js.JSMap;

public class EXTabbar extends EXContainer {

	private String position;
	
	private String animation;

	private JSMap animationOptions;
	
	private Event prechange;//	Fires just before the tab is changed.
	private Event postchange;//	Fires just after the tab is changed.
	private Event reactive;//

	public EXTabbar(String name) {
		super(name, "ons-tabbar");
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

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
		setAttribute("position", position);
	}
	
	public void setActiveTab(int index, JSMap options){
		//Show specified tab page. Animations and other options can be specified by the second parameter.
	}
	public void setTabbarVisibility(boolean visible){
		//Used to hide or show the tab bar.
	}

	public Event getPrechange() {
		return prechange;
	}

	public void setPrechange(Event prechange) {
		this.prechange = prechange;
		addEvent(prechange, "prechange");
	}

	public Event getPostchange() {
		return postchange;
	}

	public void setPostchange(Event postchange) {
		this.postchange = postchange;
		addEvent(postchange, "postchange");
	}

	public Event getReactive() {
		return reactive;
	}

	public void setReactive(Event reactive) {
		this.reactive = reactive;
		addEvent(reactive, "reactive");
	}
	
	

}
