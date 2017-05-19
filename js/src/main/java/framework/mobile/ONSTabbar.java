package framework.mobile;
import jsweet.lang.Object;
import framework.EventListener;
import framework.JSContainer;
import jsweet.lang.JSON;

public class ONSTabbar extends JSContainer {

	private String position;
	
	private String animation;

	private Object animationOptions;
	
	private EventListener prechange;//	Fires just before the tab is changed.
	private EventListener postchange;//	Fires just after the tab is changed.
	private EventListener reactive;//

	public ONSTabbar(String name) {
		super(name, "ons-tabbar");
	}

	public String getAnimation() {
		return animation;
	}
	
	

	public void setAnimation(String animation) {
		this.animation = animation;
		setAttribute("animation", animation);
	}

	public Object getAnimationOptions() {
		return animationOptions;
	}

	public void setAnimationOptions(Object animationOptions) {
		this.animationOptions = animationOptions;
		if (animationOptions != null)
			setAttribute("animation-options", JSON.stringify(animationOptions));
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
	
	public void setActiveTab(int index, Object options){
		//Show specified tab page. Animations and other options can be specified by the second parameter.
	}
	public void setTabbarVisibility(boolean visible){
		//Used to hide or show the tab bar.
	}

	public EventListener getPrechange() {
		return prechange;
	}

	public void setPrechange(EventListener prechange) {
		this.prechange = prechange;
		addEventListener(prechange, "prechange");
	}

	public EventListener getPostchange() {
		return postchange;
	}

	public void setPostchange(EventListener postchange) {
		this.postchange = postchange;
		addEventListener(postchange, "postchange");
	}

	public EventListener getReactive() {
		return reactive;
	}

	public void setReactive(EventListener reactive) {
		this.reactive = reactive;
		addEventListener(reactive, "reactive");
	}
	
	

}
