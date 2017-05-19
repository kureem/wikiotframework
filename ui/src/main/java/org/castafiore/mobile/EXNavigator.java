package org.castafiore.mobile;

import org.castafiore.ui.EXContainer;
import org.castafiore.ui.Event;
import org.castafiore.ui.js.JSMap;

public class EXNavigator extends EXContainer {

	private String animation;

	private JSMap animationOptions;

	private Event prepush;// Fired just before a page is pushed.
	private Event prepop;// Fired just before a page is popped.
	private Event postpush;// Fired just after a page is pushed.
	private Event postpop;// Fired just after a page is popped.

	public EXNavigator(String name) {
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

	public Event getPrepush() {
		return prepush;
	}

	public void setPrepush(Event prepush) {
		this.prepush = prepush;
		addEvent(prepush, "prepush");
	}

	public Event getPrepop() {
		return prepop;
	}

	public void setPrepop(Event prepop) {
		this.prepop = prepop;
		addEvent(prepop, "prepop");
	}

	public Event getPostpush() {
		return postpush;
	}

	public void setPostpush(Event postpush) {
		this.postpush = postpush;
		addEvent(postpush, "postpush");
	}

	public Event getPostpop() {
		return postpop;

	}

	public void setPostpop(Event postpop) {
		this.postpop = postpop;
		addEvent(postpop, "postpop");
	}

}
