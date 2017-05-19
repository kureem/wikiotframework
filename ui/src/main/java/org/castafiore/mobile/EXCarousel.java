package org.castafiore.mobile;

import org.castafiore.ui.EXContainer;
import org.castafiore.ui.Event;
import org.castafiore.ui.js.JSMap;

public class EXCarousel extends EXContainer {

	private String direction;// String The direction of the carousel. Can be
								// either “horizontal” or “vertical”. Default is
								// “horizontal”. Optional.
	private boolean fullscreen;// If this attribute is set the carousel will
								// cover the whole screen. Optional.
	private boolean overscrollable;// If this attribute is set the carousel will
									// be scrollable over the edge. It will
									// bounce back when released. Optional.
	private boolean centered;// If this attribute is set the carousel then the
								// selected item will be in the center of the
								// carousel instead of the beginning. Useful
								// only when the items are smaller than the
								// carousel. Optional.
	private String itemWidth;// String ons-carousel-item’s width. Only works
								// when the direction is set to “horizontal”.
								// Optional.
	private String itemHeight;// String ons-carousel-item’s height. Only works
								// when the direction is set to “vertical”.
								// Optional.
	private boolean autoScroll;// If this attribute is set the carousel will be
								// automatically scrolled to the closest item
								// border when released. Optional.
	private double autoScrollRatio;// Number A number between 0.0 and 1.0 that
									// specifies how much the user must drag the
									// carousel in order for it to auto scroll
									// to the next item. Optional.
	private boolean swipeable;// If this attribute is set the carousel can be
								// scrolled by drag or swipe. Optional.
	private boolean disabled;// If this attribute is set the carousel is
								// disabled. Optional.
	private Integer initialIndex;// Number Specify the index of the
									// ons-carousel-item to show initially.
									// Default is 0. Optional. Works only during
									// initialization.
	private boolean autoRefresh;// When this attribute is set the carousel will
								// automatically refresh when the number of
								// child nodes change. Optional.
	private String animation;// String If this attribute is set to "none" the
								// transitions will not be animated. Optional.
	private JSMap animationOptions;// Expression Specify the animation’s
									// duration, timing and delay with an object
									// literal. E.g. {duration: 0.2, delay: 1,
									// timing: 'ease-in'}. Optional.
	private Event postchange;//	Fired just after the current carousel item has changed.
	private Event refresh;//	Fired when the carousel has been refreshed.
	private Event overscroll;//	Fired when the carousel has been overscrolled.

	public EXCarousel(String name) {
		super(name, "ons-carousel");
	}
	
	
	public void setActiveIndex(int index, JSMap options){
		//Specify the index of the <ons-carousel-item> to show.
	}
	public void next(JSMap options)	{
		//Show next <ons-carousel-item>.
	}
	public void prev(JSMap options)	{
		//Show previous <ons-carousel-item>.
	}
	public void refresh()	{
		//Update the layout of the carousel. Used when adding <ons-carousel-items> dynamically or to automatically adjust the size.
	}
	public void first(){
		//Show first <ons-carousel-item>.
	}
	public void last(){
		//Show last ons-carousel item.
	}


	protected void setBoolean(String attr, boolean b){
		if(b){
			setAttribute(attr, "true");
		}else{
			setAttribute(attr, (String)null);
		}
	}
	public String getDirection() {
		return direction;
	}


	public void setDirection(String direction) {
		this.direction = direction;
		setAttribute("direction", direction);
	}


	public boolean isFullscreen() {
		return fullscreen;
	}


	public void setFullscreen(boolean fullscreen) {
		this.fullscreen = fullscreen;
		setBoolean("fullscreen", fullscreen);
		
	}


	public boolean isOverscrollable() {
		return overscrollable;
	}


	public void setOverscrollable(boolean overscrollable) {
		this.overscrollable = overscrollable;
		setBoolean("overscrollable", overscrollable);
	}


	public boolean isCentered() {
		return centered;
	}


	public void setCentered(boolean centered) {
		this.centered = centered;
		setBoolean("centered", centered);
	}


	public String getItemWidth() {
		return itemWidth;
	}


	public void setItemWidth(String itemWidth) {
		this.itemWidth = itemWidth;
		setAttribute("item-width", itemWidth);
	}


	public String getItemHeight() {
		return itemHeight;
	}


	public void setItemHeight(String itemHeight) {
		this.itemHeight = itemHeight;
		setAttribute("item-height", itemHeight);
	}


	public boolean isAutoScroll() {
		return autoScroll;
	}


	public void setAutoScroll(boolean autoScroll) {
		this.autoScroll = autoScroll;
		setBoolean("auto-scroll", autoScroll);
	}


	public double getAutoScrollRatio() {
		return autoScrollRatio;
	}


	public void setAutoScrollRatio(double autoScrollRatio) {
		this.autoScrollRatio = autoScrollRatio;
		setAttribute("auto-scroll-ratio", autoScrollRatio + "");
	}


	public boolean isSwipeable() {
		return swipeable;
	}


	public void setSwipeable(boolean swipeable) {
		this.swipeable = swipeable;
		setBoolean("swipable", swipeable);
	}


	public boolean isDisabled() {
		return disabled;
	}


	public void setDisabled(boolean disabled) {
		this.disabled = disabled;
		setBoolean("disabled", disabled);
	}


	public Integer getInitialIndex() {
		return initialIndex;
	}


	public void setInitialIndex(Integer initialIndex) {
		this.initialIndex = initialIndex;
		setAttribute("initial-index", initialIndex.toString());
	}


	public boolean isAutoRefresh() {
		return autoRefresh;
	}


	public void setAutoRefresh(boolean autoRefresh) {
		this.autoRefresh = autoRefresh;
		setBoolean("auto-refresh", autoRefresh);
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
		if(animationOptions != null)
			setAttribute("animation-options", animationOptions.getJavascript());
		else
			setAttribute("animation-options", (String)null);
	}


	public Event getPostchange() {
		return postchange;
	}


	public void setPostchange(Event postchange) {
		this.postchange = postchange;
		addEvent(postchange, "postchange");
	}


	public Event getRefresh() {
		return refresh;
	}


	public void setRefresh(Event refresh) {
		this.refresh = refresh;
		addEvent(refresh, "refresh");
	}


	public Event getOverscroll() {
		return overscroll;
	}


	public void setOverscroll(Event overscroll) {
		this.overscroll = overscroll;
		addEvent(overscroll, "overscroll");
	}
	
	

}
