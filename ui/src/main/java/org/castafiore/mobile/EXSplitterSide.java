package org.castafiore.mobile;

import org.castafiore.ui.EXContainer;
import org.castafiore.ui.Event;
import org.castafiore.ui.js.JSMap;

public class EXSplitterSide extends EXContainer{

	private String animation;	
	private JSMap animationOptions;	
	private String openThreshold;//	Number 
	private String collapse;//	String	
	private String swipeTargetWidth;//	String	The width of swipeable area calculated from the edge (in pixels). Use this to enable swipe only when the finger touch on the screen edge. Optional.
	private String width;//	String	Can be specified in either pixels or as a percentage, e.g. 90% or 200px. Optional.
	private String side;//	String 
	private String mode;//	String	Current mode. Possible values are "collapse" or "split". This attribute is read only. Optional.
	private String page;//	String	The URL of the menu page. Optional. Works only during initialization.
	private boolean swipeable;//o	Boolean	Whether to enable swipe interaction on collapse mode. Optional.
	
	
	private Event modechange;//	Fired just after the component’s mode changes.
	private Event preopen;//	Fired just before the sliding menu is opened.
	private Event postopen;//	Fired just after the sliding menu is opened.
	private Event preclose;//	Fired just before the sliding menu is closed.
	private Event postclose;
	
	public EXSplitterSide(String name) {
		super(name, "ons-splitter-side");
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

	public String getOpenThreshold() {
		return openThreshold;
	}

	public void setOpenThreshold(String openThreshold) {
		this.openThreshold = openThreshold;
		setAttribute("open-threshold", openThreshold);
	}

	public String getCollapse() {
		return collapse;
	}

	public void setCollapse(String collapse) {
		this.collapse = collapse;
		setAttribute("collapse", collapse);
	}

	public String getSwipeTargetWidth() {
		return swipeTargetWidth;
	}

	public void setSwipeTargetWidth(String swipeTargetWidth) {
		this.swipeTargetWidth = swipeTargetWidth;
		setAttribute("swipe-target-width", swipeTargetWidth);
	}

	public String getWidth() {
		return width;
	}

	public void setWidth(String width) {
		this.width = width;
		setAttribute("width", width);
	}

	public String getSide() {
		return side;
	}

	public void setSide(String side) {
		this.side = side;
		setAttribute("side", side);
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
		setAttribute("mode", mode);
	}

	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
		setAttribute("page", page);
	}

	public boolean isSwipeable() {
		return swipeable;
	}

	public void setSwipeable(boolean swipeable) {
		this.swipeable = swipeable;
		if(swipeable){
			setAttribute("swipable", "true");
		}else{
			setAttribute("swipable", (String)null);
		}
	}
	
	
	
	public void open(JSMap options){//	Open menu in collapse mode.
		
	}
	public void close(JSMap options){
		//Close menu in collapse mode.
	}
	public void toggle(JSMap options){//
		//Opens if it’s closed. Closes if it’s open.
	}
	public void load(String page, JSMap options){
		
	}

	public Event getModechange() {
		return modechange;
	}

	public void setModechange(Event modechange) {
		this.modechange = modechange;
		addEvent(modechange, "modechange");
	}

	public Event getPreopen() {
		return preopen;
	}

	public void setPreopen(Event preopen) {
		this.preopen = preopen;
		addEvent(preopen, "preopen");
	}

	public Event getPostopen() {
		return postopen;
	}

	public void setPostopen(Event postopen) {
		this.postopen = postopen;
		addEvent(postopen, "postopen");
	}

	public Event getPreclose() {
		return preclose;
	}

	public void setPreclose(Event preclose) {
		this.preclose = preclose;
		addEvent(preclose, "preclose");
	}

	public Event getPostclose() {
		return postclose;
	}

	public void setPostclose(Event postclose) {
		this.postclose = postclose;
		addEvent(postclose, "postclose");
	}
	
	

}
