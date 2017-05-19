package framework.mobile;

import framework.EventListener;
import framework.JSContainer;
import framework.JSMap;

public class ONSSplitterSide extends JSContainer{

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
	
	
	private EventListener modechange;//	Fired just after the component’s mode changes.
	private EventListener preopen;//	Fired just before the sliding menu is opened.
	private EventListener postopen;//	Fired just after the sliding menu is opened.
	private EventListener preclose;//	Fired just before the sliding menu is closed.
	private EventListener postclose;
	
	public ONSSplitterSide(String name) {
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

	public EventListener getModechange() {
		return modechange;
	}

	public void setModechange(EventListener modechange) {
		this.modechange = modechange;
		addEventListener(modechange, "modechange");
	}

	public EventListener getPreopen() {
		return preopen;
	}

	public void setPreopen(EventListener preopen) {
		this.preopen = preopen;
		addEventListener(preopen, "preopen");
	}

	public EventListener getPostopen() {
		return postopen;
	}

	public void setPostopen(EventListener postopen) {
		this.postopen = postopen;
		addEventListener(postopen, "postopen");
	}

	public EventListener getPreclose() {
		return preclose;
	}

	public void setPreclose(EventListener preclose) {
		this.preclose = preclose;
		addEventListener(preclose, "preclose");
	}

	public EventListener getPostclose() {
		return postclose;
	}

	public void setPostclose(EventListener postclose) {
		this.postclose = postclose;
		addEventListener(postclose, "postclose");
	}
	
	

}
