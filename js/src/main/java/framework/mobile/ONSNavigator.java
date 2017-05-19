package framework.mobile;

import framework.EventListener;
import framework.JSContainer;
import framework.JSMap;

public class ONSNavigator extends JSContainer {

	private String animation;

	private JSMap animationOptions;

	private EventListener prepush;// Fired just before a page is pushed.
	private EventListener prepop;// Fired just before a page is popped.
	private EventListener postpush;// Fired just after a page is pushed.
	private EventListener postpop;// Fired just after a page is popped.

	public ONSNavigator(String name) {
		super(name, "ons-navigator");
	}

	public void popPage(JSMap options) {
		// Pops the current page from the page stack. The previous page will be
		// displayed.
	}

	public void pushPage(String page, JSMap options) {
		// Pushes the specified page into the stack.
	}

	public void replacePage(String page, JSMap options) {
		// Replaces the current top page with the specified one. Extends
		// pushPage() parameters.
	}

	public void insertPage(int index, String page, JSMap options) {
		// Insert the specified page into the stack with at a position defined
		// by the index argument. Extends pushPage() parameters.
	}

	public void resetToPage(String page, JSMap options) {
		// Clears page stack and adds the specified page to the stack. Extends
		// pushPage() parameters.
	}

	public void bringPageTop(int item, JSMap options) {
		// Brings the given page to the top of the page stack if it already
		// exists or pushes it into the stack if doesn’t. Extends pushPage()
		// parameters.
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

	public EventListener getPrepush() {
		return prepush;
	}

	public void setPrepush(EventListener prepush) {
		this.prepush = prepush;
		addEventListener(prepush, "prepush");
	}

	public EventListener getPrepop() {
		return prepop;
	}

	public void setPrepop(EventListener prepop) {
		this.prepop = prepop;
		addEventListener(prepop, "prepop");
	}

	public EventListener getPostpush() {
		return postpush;
	}

	public void setPostpush(EventListener postpush) {
		this.postpush = postpush;
		addEventListener(postpush, "postpush");
	}

	public EventListener getPostpop() {
		return postpop;

	}

	public void setPostpop(EventListener postpop) {
		this.postpop = postpop;
		addEventListener(postpop, "postpop");
	}

}
